package com.ming.ebook.ehome.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ming.ebook.R;
import com.ming.ebook.base.BaseActivity;
import com.ming.ebook.bean.Categories;
import com.ming.ebook.bean.CategoriesDetails;
import com.ming.ebook.constant.AppConstants;
import com.ming.ebook.constant.EBookUri;
import com.ming.ebook.dao.BookBeanDao;
import com.ming.ebook.dao.DbHelper;
import com.ming.ebook.dao.entity.BookBean;
import com.ming.ebook.decoration.DividerItemDecoration;
import com.ming.ebook.ebook.activity.ReadActivity;
import com.ming.ebook.ehome.adapter.CategoriesDetailsAdapter;
import com.ming.ebook.system.ScreenUtils;
import com.ming.ebook.utils.Model;
import com.ming.ebook.utils.PrintLog;
import com.ming.ebook.utils.RegularUtils;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class CategoriesDetailsActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, CategoriesDetailsAdapter.OnItemClickListener {
    private RadioGroup categoriesDetailsRg;
    private RecyclerView detailsRecyclerView;
    private PopupWindow bookInfoPop;

    private String detailUrl;
    private String genderName;
    private String majorName;
    private String pageType = "hot";
    private int pageStartIndex = 0;
    private int pageLimit = 8;

    List<CategoriesDetails.DataBean.BooksBean> mDetailsList;
    private CategoriesDetailsAdapter mDetailsAdapter;


    //Handler
    private final Handler mHandler = new DetailsHandler(this);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  If null, all callbacks and messages will be removed.
        mHandler.removeCallbacksAndMessages(null);
    }

    private static class DetailsHandler extends Handler {
        private final WeakReference<CategoriesDetailsActivity> mActivity;

        public DetailsHandler(CategoriesDetailsActivity activity) {
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
            case AppConstants.DETAIL_DATA_HANDLER:
                List<CategoriesDetails.DataBean.BooksBean> beanList = (List<CategoriesDetails.DataBean.BooksBean>) msg.obj;
                if (beanList != null && beanList.size() > 0) {
                    //逻辑操作
                    if (mDetailsList != null && mDetailsAdapter != null) {
                        mDetailsList.clear();
                        mDetailsAdapter.notifyDataSetChanged();
                        mDetailsList.addAll(beanList);
                        mDetailsAdapter.notifyDataSetChanged();
                    }
                }
                break;

            default:
                break;

        }
    }

    @Override
    protected int getContentViewId() {
        immersiveStatusBar(R.color.blue);
        return R.layout.activity_categories_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //UI
        categoriesDetailsRg = (RadioGroup) findViewById(R.id.categories_details_rg);
        categoriesDetailsRg.setOnCheckedChangeListener(this);
        detailsRecyclerView = (RecyclerView) findViewById(R.id.details_recycler_view);
        detailsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        detailsRecyclerView.setLayoutManager(mLayoutManager);
        detailsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        detailsRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //top
        LinearLayout topBar = (LinearLayout) findViewById(R.id.categories_details_top);
        TextView title = (TextView) topBar.findViewById(R.id.top_title);
        LinearLayout topRightLl = (LinearLayout) topBar.findViewById(R.id.top_right_ll);
        topRightLl.setVisibility(View.INVISIBLE);

        LinearLayout topSearchLL = (LinearLayout) topBar.findViewById(R.id.top_search_ll);
        topSearchLL.setVisibility(View.GONE);

        LinearLayout topBackLl = (LinearLayout) topBar.findViewById(R.id.top_back_ll);
        topBackLl.setVisibility(View.VISIBLE);
        topBackLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriesDetailsActivity.this.finish();
            }
        });

        Intent getIntent = getIntent();
        String detailsKey = getIntent.getStringExtra("details_key");
        switch (detailsKey) {
            case "MaleBean":
                Categories.DataBean.MaleBean maleBean = (Categories.DataBean.MaleBean) getIntent.getSerializableExtra("details_data");
                //topTitle
                title.setText(maleBean.getName());
                //默认请求Url
                genderName = "male";
                majorName = maleBean.getName();
                break;
            case "FemaleBean":
                Categories.DataBean.FemaleBean femaleBean = (Categories.DataBean.FemaleBean) getIntent.getSerializableExtra("details_data");
                //topTitle
                title.setText(femaleBean.getName());
                genderName = "female";
                majorName = femaleBean.getName();
                break;
            default:
                break;
        }
        //data
        mDetailsList = new ArrayList<>();
        mDetailsAdapter = new CategoriesDetailsAdapter(mDetailsList, this);
        detailsRecyclerView.setAdapter(mDetailsAdapter);
        mDetailsAdapter.setOnItemClickListener(this);
        //网络获取数据
        getDetailsDataByUrl();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.book_hot:
                categoriesDetailsRg.check(R.id.book_hot);
                pageType = "hot";
                //重新获取数据
                getDetailsDataByUrl();
                break;
            case R.id.book_new:
                categoriesDetailsRg.check(R.id.book_new);
                pageType = "new";
                //重新获取数据
                getDetailsDataByUrl();
                break;
            case R.id.book_reputation:
                categoriesDetailsRg.check(R.id.book_reputation);
                pageType = "reputation";
                //重新获取数据
                getDetailsDataByUrl();
                break;
            case R.id.book_over:
                categoriesDetailsRg.check(R.id.book_over);
                pageType = "over";
                //重新获取数据
                getDetailsDataByUrl();
                break;
            default:
                break;
        }
    }

    /**
     * 网络获取数据
     */
    private void getDetailsDataByUrl() {
        //默认请求Url
        detailUrl = EBookUri.CATEGORY_HEAD + EBookUri.CATEGORY_GENDER + genderName + EBookUri.CATEGORY_TYPE + pageType + EBookUri.CATEGORY_MAJOR + majorName + EBookUri.CATEGORY_START + pageStartIndex + EBookUri.CATEGORY_LIMIT + pageLimit;
        //网络访问
        Model.getInstance().getGloablThreadPool().execute(new Runnable() {

            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                okhttp3.Request request = new okhttp3.Request.Builder()
                        .url(detailUrl)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        PrintLog.d("getDetailsDataByUrl网络访问失败");
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull okhttp3.Response response) throws IOException {
                        int resCode = response.code();
                        if (resCode == 200) {
                            //解析json
                            String json = response.body().string();
                            PrintLog.d("getDetailsDataByUrl json:" + json);
                            Gson gson = new Gson();
                            CategoriesDetails detailsBean = gson.fromJson(json, CategoriesDetails.class);

                            List<CategoriesDetails.DataBean.BooksBean> maleBeanList = detailsBean.getData().getBooks();
                            mHandler.obtainMessage(AppConstants.DETAIL_DATA_HANDLER, maleBeanList).sendToTarget();
                        }
                    }
                });
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        //1.view
        View popView = LayoutInflater.from(this).inflate(R.layout.item_book_info, null);
        ImageView book_cover = (ImageView) popView.findViewById(R.id.pop_book_cover);
        TextView book_title = (TextView) popView.findViewById(R.id.pop_book_title);
        TextView book_author = (TextView) popView.findViewById(R.id.pop_book_author);
        TextView book_shortIntro = (TextView) popView.findViewById(R.id.pop_book_shortIntro);
        TextView book_follower = (TextView) popView.findViewById(R.id.pop_book_follower);
        Button pop_add = (Button) popView.findViewById(R.id.pop_book_add);
        Button pop_read = (Button) popView.findViewById(R.id.pop_book_read);
        final CategoriesDetails.DataBean.BooksBean booksBean = mDetailsList.get(position);
        //加载图片
        Glide.with(this)
                .load(RegularUtils.regularImageUrl(booksBean.getCover()))
                .placeholder(R.drawable.day)
                .crossFade()
                .into(book_cover);
        book_title.setText(booksBean.getTitle());
        book_author.setText(booksBean.getAuthor());
        book_shortIntro.setText(booksBean.getShortIntro());
        book_follower.setText(getString(R.string.item_followers, booksBean.getLatelyFollower()));
        pop_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.加入书架(先查询有没有)
                List<BookBean> searchBookList = DbHelper.getInstance().getmDaoSession().getBookBeanDao().queryBuilder().where(BookBeanDao.Properties.Book_id.eq(booksBean.get_id())).build().list();
                if (searchBookList.size() > 0) {
                    Toast.makeText(CategoriesDetailsActivity.this, "书架中已存在", Toast.LENGTH_SHORT).show();
                } else {
                    BookBean gridBook = new BookBean();
                    gridBook.setBook_id(booksBean.get_id());
                    gridBook.setBook_cover(booksBean.getCover());
                    gridBook.setName(booksBean.getTitle());
                    gridBook.setReaded_chapter(AppConstants.NO_READED_CHAPTER);
                    DbHelper.getInstance().getmDaoSession().getBookBeanDao().insert(gridBook);

                    Toast.makeText(CategoriesDetailsActivity.this, "已添加进书架", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pop_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookInfoPop.dismiss();
                //2.跳转到开始阅读界面
                Intent intent = new Intent(CategoriesDetailsActivity.this, ReadActivity.class);
                intent.putExtra("book_id", booksBean.get_id());
                startActivity(intent);
            }
        });
        //2.window
        int popWidth = (int) (ScreenUtils.getRealScreenWidth(this) * 0.9);
        int popHeight = (int) (ScreenUtils.getRealScreenHeight(this) * 0.3);
        bookInfoPop = new PopupWindow(popView, popWidth
                , popHeight, true);
        bookInfoPop.setTouchable(true);
        bookInfoPop.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("mPopupWindow", "onTouch : ");
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        bookInfoPop.setBackgroundDrawable(new BitmapDrawable());
        bookInfoPop.setAnimationStyle(R.style.popup_window_anim);
        bookInfoPop.showAtLocation(detailsRecyclerView, Gravity.CENTER, 0, 0);

    }
}
