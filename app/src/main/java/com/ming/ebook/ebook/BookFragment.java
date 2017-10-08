package com.ming.ebook.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ming.ebook.EBookApplication;
import com.ming.ebook.R;
import com.ming.ebook.base.BaseFragment;
import com.ming.ebook.dao.entity.BookBean;
import com.ming.ebook.decoration.DividerGridItemDecoration;
import com.ming.ebook.ebook.activity.ReadActivity;
import com.ming.ebook.ebook.adapter.StaggeredGridAdapter;
import com.ming.ebook.utils.MyLayoutAnimationHelper;
import com.ming.ebook.view.StaggeredGridRecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public class BookFragment extends BaseFragment implements IeBookV, StaggeredGridAdapter.OnItemBookClickListener {
    private StaggeredGridRecyclerView mRecyclerView;
    private List<BookBean> bookList;
    private StaggeredGridAdapter mStaggeredGridAdapter;
    private BookP mBookP;

    public static BookFragment newInstance(String param1) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        LinearLayout topBar = (LinearLayout) view.findViewById(R.id.book_top);
        LinearLayout topSearchLL = (LinearLayout) topBar.findViewById(R.id.top_search_ll);
        topSearchLL.setVisibility(View.INVISIBLE);
        TextView title = (TextView) topBar.findViewById(R.id.top_title);
        title.setText("书架");
        mRecyclerView = (StaggeredGridRecyclerView) view.findViewById(R.id.staggered_grid_book);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(mActivity));
    }

    @Override
    protected void loadData() {
        //data
        bookList = new ArrayList<>();
        mStaggeredGridAdapter = new StaggeredGridAdapter(bookList, mActivity);
        mRecyclerView.setAdapter(mStaggeredGridAdapter);
        mStaggeredGridAdapter.setOnItemBookClickListener(this);
        //类
        mBookP = new BookP(this);
        //查询数据库获取书籍
        mBookP.getBooksFromDao();
    }
//实现v层方法----------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public void showBooksToView(final List<BookBean> bookBeanList) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bookList.clear();
                mStaggeredGridAdapter.notifyDataSetChanged();
                bookList.addAll(bookBeanList);
                mStaggeredGridAdapter.notifyDataSetChanged();
                playLayoutAnimation(MyLayoutAnimationHelper.getAnimationSetFromTop(), true);
            }
        });
    }

    @Override
    public void showBooksToViewError() {
        Toast.makeText(EBookApplication.getInstance().getApplicationContext(), "showBooksToViewError", Toast.LENGTH_SHORT).show();
    }

//----------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 播放动画
     *
     * @param animation
     * @param isReverse
     */
    public void playLayoutAnimation(Animation animation, boolean isReverse) {
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation);
        controller.setColumnDelay(0.2f);
        controller.setRowDelay(0.3f);
        controller.setOrder(isReverse ? LayoutAnimationController.ORDER_REVERSE : LayoutAnimationController.ORDER_NORMAL);

        mRecyclerView.setLayoutAnimation(controller);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
    }

    @Override
    public void itemBookClick(View v, int position) {
        BookBean book = bookList.get(position);
        //跳转
        Intent intent = new Intent(mActivity, ReadActivity.class);
        intent.putExtra("book_id", book.getBook_id());
        mActivity.startActivity(intent);
    }
}
