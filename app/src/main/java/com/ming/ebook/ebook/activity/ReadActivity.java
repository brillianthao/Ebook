package com.ming.ebook.ebook.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ming.ebook.R;
import com.ming.ebook.base.BaseActivity;
import com.ming.ebook.bean.BookChapters;
import com.ming.ebook.bean.BookSource;
import com.ming.ebook.bean.ChaptersDetail;
import com.ming.ebook.constant.AppConstants;
import com.ming.ebook.constant.EBookUri;
import com.ming.ebook.decoration.DividerItemDecoration;
import com.ming.ebook.ebook.adapter.CategoriesListAdapter;
import com.ming.ebook.utils.Model;
import com.ming.ebook.utils.PrintLog;
import com.ming.ebook.utils.UrlEncodeUtil;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class ReadActivity extends BaseActivity implements CategoriesListAdapter.OnItemClickListener {
    private ProgressBar loadingBar;
    private ScrollView scrollViewRead;
    private TextView mTextView;
    private RecyclerView catalogueRecyclerView;
    private List<BookChapters.DataBean.ChaptersBean> categoriesList;
    private CategoriesListAdapter categoriesListAdapter;
    private int currentPosition = 0;
    //Handler
    private final Handler mHandler = new ReadActivity.ReadHandler(this);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  If null, all callbacks and messages will be removed.
        mHandler.removeCallbacksAndMessages(null);
    }

    private static class ReadHandler extends Handler {
        private final WeakReference<ReadActivity> mActivity;

        public ReadHandler(ReadActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mActivity.get() == null) {
                return;
            }

            if (msg != null) {
                mActivity.get().todo(msg);
            }
        }
    }

    /**
     * 处理msg逻辑方法
     *
     * @param msg
     */
    public void todo(Message msg) {
        switch (msg.what) {
            case AppConstants.BOOK_SOURCE_ID_HANDLER:
                List<BookSource.DataBean> dataBeenList = (List<BookSource.DataBean>) msg.obj;
                if (dataBeenList != null && dataBeenList.size() > 0) {
                    BookSource.DataBean sourceBean = dataBeenList.get(0);
                    String sourceId = sourceBean.get_id();
                    if (!TextUtils.isEmpty(sourceId)) {
                        //2.获取书籍章节
                        String bookChaptersUrl = EBookUri.BOOK_CHAPTERS + sourceId;
                        getBookSourceDataByUrl(bookChaptersUrl, AppConstants.TAG_BOOK_CHAPTERS);
                    }
                }
                break;
            case AppConstants.BOOK_CHAPTERS_HANDLER:
                List<BookChapters.DataBean.ChaptersBean> chaptersBeanList = (List<BookChapters.DataBean.ChaptersBean>) msg.obj;
                if (chaptersBeanList != null && chaptersBeanList.size() > 0) {
                    //3.1 添加章节对象
                    for (BookChapters.DataBean.ChaptersBean bean : chaptersBeanList) {
                        categoriesList.add(bean);
                    }
                    categoriesListAdapter.notifyDataSetChanged();

                    //3.2 获取章节详细内容
                    String link = chaptersBeanList.get(0).getLink();
                    String chaptersDetailUrl = EBookUri.BOOK_CHAPTERS_DETAIL + UrlEncodeUtil.encoderString(link);
                    getBookSourceDataByUrl(chaptersDetailUrl, AppConstants.TAG_BOOK_CHAPTERS_DETAIL);
                }

                break;

            case AppConstants.BOOK_CHAPTERS_DETAIL_HANDLER:
                //4.章节内容
                ChaptersDetail.DataBean.ChapterBean chapterBean = (ChaptersDetail.DataBean.ChapterBean) msg.obj;
                PrintLog.d("ReadActivity:" + chapterBean.getCpContent());
                String content = chapterBean.getTitle() + "\n" + "\n" + chapterBean.getCpContent().trim();
                mTextView.setText(content);
                //显示内容
                scrollViewRead.setVisibility(View.VISIBLE);
                catalogueRecyclerView.setVisibility(View.GONE);
                loadingBar.setVisibility(View.GONE);
                break;
            default:
                break;

        }
    }

    @Override
    protected int getContentViewId() {
        immersiveStatusBar(R.color.transparent);
        return R.layout.activity_read;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //ui
        loadingBar = (ProgressBar) findViewById(R.id.loading_bar);
        scrollViewRead = (ScrollView) findViewById(R.id.scrollView_read);
        mTextView = (TextView) findViewById(R.id.book_content);
        catalogueRecyclerView = (RecyclerView) findViewById(R.id.catalogue_recycler_view);
        catalogueRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        catalogueRecyclerView.setLayoutManager(mLayoutManager);
        catalogueRecyclerView.setItemAnimator(new DefaultItemAnimator());
        catalogueRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        findViewById(R.id.catalogue_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCatalogueList();
            }
        });

        findViewById(R.id.next_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextCatalogue();
            }
        });

        //data
        String book_id = getIntent().getStringExtra("book_id");
        PrintLog.d("ReadActivity book_id:" + book_id);
        if (!TextUtils.isEmpty(book_id)) {
            //1.获取书籍源
            String bookSourceUrl = EBookUri.BOOK_SOURCE + book_id;
            getBookSourceDataByUrl(bookSourceUrl, AppConstants.TAG_BOOK_SOURCE_ID);
        }
        categoriesList = new ArrayList<>();
        categoriesListAdapter = new CategoriesListAdapter(categoriesList, this);
        catalogueRecyclerView.setAdapter(categoriesListAdapter);
        categoriesListAdapter.setOnItemClickListener(this);

    }

    /**
     * 下一章
     */
    private void showNextCatalogue() {
        if (currentPosition < (categoriesList.size() - 1)) {
            //显示圈
            scrollViewRead.setVisibility(View.GONE);
            catalogueRecyclerView.setVisibility(View.GONE);
            loadingBar.setVisibility(View.VISIBLE);

            currentPosition++;

            String link = categoriesList.get(currentPosition).getLink();
            String chaptersDetailUrl = EBookUri.BOOK_CHAPTERS_DETAIL + UrlEncodeUtil.encoderString(link);
            getBookSourceDataByUrl(chaptersDetailUrl, AppConstants.TAG_BOOK_CHAPTERS_DETAIL);
        } else {
            Toast.makeText(ReadActivity.this, "已经到末尾了......", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 目录
     */
    private void showCatalogueList() {
        if (catalogueRecyclerView.isShown()) {
            catalogueRecyclerView.setVisibility(View.GONE);
        } else {
            catalogueRecyclerView.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onItemClick(View view, int position) {
        //显示圈
        scrollViewRead.setVisibility(View.GONE);
        catalogueRecyclerView.setVisibility(View.GONE);
        loadingBar.setVisibility(View.VISIBLE);

        String link = categoriesList.get(position).getLink();
        String chaptersDetailUrl = EBookUri.BOOK_CHAPTERS_DETAIL + UrlEncodeUtil.encoderString(link);
        getBookSourceDataByUrl(chaptersDetailUrl, AppConstants.TAG_BOOK_CHAPTERS_DETAIL);
    }

    /**
     * 网络获取数据
     */
    private void getBookSourceDataByUrl(final String url, final int tag) {

        //网络访问
        Model.getInstance().getGloablThreadPool().execute(new Runnable() {

            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                okhttp3.Request request = new okhttp3.Request.Builder()
                        .url(url)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        PrintLog.d("getBookSourceDataByUrl网络访问失败");
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull okhttp3.Response response) throws IOException {
                        int resCode = response.code();
                        if (resCode == 200) {
                            //解析json
                            String json = response.body().string();
                            PrintLog.d("getBookSourceDataByUrl json:" + json);
                            Gson gson = new Gson();
                            switch (tag) {
                                case AppConstants.TAG_BOOK_SOURCE_ID:

                                    BookSource bookSourceBean = gson.fromJson(json, BookSource.class);
                                    List<BookSource.DataBean> dataBeenList = bookSourceBean.getData();
                                    mHandler.obtainMessage(AppConstants.BOOK_SOURCE_ID_HANDLER, dataBeenList).sendToTarget();

                                    break;
                                case AppConstants.TAG_BOOK_CHAPTERS:

                                    BookChapters chaptersBean = gson.fromJson(json, BookChapters.class);
                                    List<BookChapters.DataBean.ChaptersBean> chaptersBeanList = chaptersBean.getData().getChapters();
                                    mHandler.obtainMessage(AppConstants.BOOK_CHAPTERS_HANDLER, chaptersBeanList).sendToTarget();

                                    break;
                                case AppConstants.TAG_BOOK_CHAPTERS_DETAIL:

                                    ChaptersDetail chaptersDetailBean = gson.fromJson(json, ChaptersDetail.class);
                                    ChaptersDetail.DataBean.ChapterBean chapterBean = chaptersDetailBean.getData().getChapter();
                                    mHandler.obtainMessage(AppConstants.BOOK_CHAPTERS_DETAIL_HANDLER, chapterBean).sendToTarget();

                                    break;

                                default:

                                    break;
                            }

                        }
                    }
                });
            }
        });

    }
}
