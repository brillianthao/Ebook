package com.ming.ebook.ehome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ming.ebook.EBookApplication;
import com.ming.ebook.R;
import com.ming.ebook.base.BaseFragment;
import com.ming.ebook.bean.BannerBean;
import com.ming.ebook.bean.Categories;
import com.ming.ebook.decoration.DividerGridItemDecoration;
import com.ming.ebook.ebook.activity.ReadActivity;
import com.ming.ebook.ehome.adapter.BannerAdapter;
import com.ming.ebook.ehome.adapter.CategoriesFemaleAdapter;
import com.ming.ebook.ehome.adapter.CategoriesMaleAdapter;
import com.ming.ebook.utils.PrintLog;
import com.ming.ebook.view.HorizontalListView;

import java.util.ArrayList;
import java.util.List;


/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public class HomeFragment extends BaseFragment implements IeHomeV, AdapterView.OnItemClickListener {
    //UI
    private HorizontalListView bannerListView;
    private RecyclerView categoriesMaleRecyclerView;
    private RecyclerView categoriesFemaleRecyclerView;
    //data
    private List<BannerBean.DataBean.RankingBean.BooksBean> mBannerBeanList;
    private BannerAdapter mBannerAdapter;
    private List<Categories.DataBean.MaleBean> mMaleBeanList;
    private CategoriesMaleAdapter mMaleCategorieAdapter;
    private List<Categories.DataBean.FemaleBean> mFemaleBeanList;
    private CategoriesFemaleAdapter mFemaleCategorieAdapter;
    //class
    private HomeP mHomeP;

    //基本方法---------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 单例
     */
    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        //top
        LinearLayout topBar = (LinearLayout) view.findViewById(R.id.home_top);
        TextView title = (TextView) topBar.findViewById(R.id.top_title);
        title.setText("书城");
        topBar.findViewById(R.id.top_right_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });

        //UI
        bannerListView = (HorizontalListView) view.findViewById(R.id.horizontal_list_view);
        categoriesMaleRecyclerView = (RecyclerView) view.findViewById(R.id.male_recycler_view);
        categoriesMaleRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 3));
        categoriesMaleRecyclerView.setHasFixedSize(true);
        categoriesMaleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoriesMaleRecyclerView.addItemDecoration(new DividerGridItemDecoration(mActivity));

        categoriesFemaleRecyclerView = (RecyclerView) view.findViewById(R.id.female_recycler_view);
        categoriesFemaleRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 3));
        categoriesFemaleRecyclerView.setHasFixedSize(true);
        categoriesFemaleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoriesFemaleRecyclerView.addItemDecoration(new DividerGridItemDecoration(mActivity));
        //data
        mBannerBeanList = new ArrayList<>();
        mBannerAdapter = new BannerAdapter(mBannerBeanList, mActivity);
        bannerListView.setAdapter(mBannerAdapter);
        bannerListView.setOnItemClickListener(this);

        mMaleBeanList = new ArrayList<>();
        mMaleCategorieAdapter = new CategoriesMaleAdapter(mMaleBeanList, mActivity);
        categoriesMaleRecyclerView.setAdapter(mMaleCategorieAdapter);

        mFemaleBeanList = new ArrayList<>();
        mFemaleCategorieAdapter = new CategoriesFemaleAdapter(mFemaleBeanList, mActivity);
        categoriesFemaleRecyclerView.setAdapter(mFemaleCategorieAdapter);

        //类
        mHomeP = new HomeP(this);
        PrintLog.d("banner initView");
    }

    @Override
    protected void loadData() {
        PrintLog.d("banner loadData()");
        //1.获取banner数据
        mHomeP.getBannerData();
        //2获取分类数据
        mHomeP.getCategoriesCountData();
    }
    //普通发法-----------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * 菜单方法
     */
    private void showMenu() {

    }

    //以下是实现V层方法--------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void showBannerDataToView(final List<BannerBean.DataBean.RankingBean.BooksBean> bannerBeanList) {
        PrintLog.d("banner showBannerDataToView");
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBannerBeanList.clear();
                mBannerAdapter.notifyDataSetChanged();
                mBannerBeanList.addAll(bannerBeanList);
                mBannerAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showBannerDataToViewError() {
        Toast.makeText(EBookApplication.getInstance().getApplicationContext(), "showBannerDataToViewError", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCategoriesMaleBeanData(final List<Categories.DataBean.MaleBean> maleList) {
        PrintLog.d("showCategoriesMaleBeanData");
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMaleBeanList.clear();
                mMaleCategorieAdapter.notifyDataSetChanged();
                mMaleBeanList.addAll(maleList);
                mMaleCategorieAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showCategoriesFemaleBeanData(final List<Categories.DataBean.FemaleBean> femaleList) {
        PrintLog.d("showCategoriesFemaleBeanData");
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mFemaleBeanList.clear();
                mFemaleCategorieAdapter.notifyDataSetChanged();
                mFemaleBeanList.addAll(femaleList);
                mFemaleCategorieAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void showCategoriesCountDataError() {
        Toast.makeText(EBookApplication.getInstance().getApplicationContext(), "showCategoriesCountDataError", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //上面横的listview点击事件
        BannerBean.DataBean.RankingBean.BooksBean booksBean = mBannerBeanList.get(position);
        //跳转
        Intent intent = new Intent(mActivity, ReadActivity.class);
        intent.putExtra("book_id", booksBean.get_id());
        intent.putExtra("book_name",booksBean.getTitle());
        intent.putExtra("book_cover",booksBean.getCover());
        mActivity.startActivity(intent);
    }


}
