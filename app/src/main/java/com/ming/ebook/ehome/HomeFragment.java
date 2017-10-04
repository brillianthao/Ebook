package com.ming.ebook.ehome;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ming.ebook.R;
import com.ming.ebook.base.BaseFragment;
import com.ming.ebook.bean.BannerBean;
import com.ming.ebook.ehome.adapter.BannerAdapter;
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

public class HomeFragment extends BaseFragment implements IeHomeV {
    //UI
    private HorizontalListView bannerListView;
    //data
    private List<BannerBean.DataBean.RankingBean.BooksBean> mBannerBeanList;
    private BannerAdapter mBannerAdapter;
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
        title.setText("Home");
        topBar.findViewById(R.id.top_right_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });

        //UI
        bannerListView = (HorizontalListView) view.findViewById(R.id.horizontal_list_view);
        //data
        mBannerBeanList = new ArrayList<>();
        mBannerAdapter = new BannerAdapter(mBannerBeanList, mActivity);
        bannerListView.setAdapter(mBannerAdapter);
        //类
        mHomeP = new HomeP(this);
        PrintLog.d("banner initView");
    }

    @Override
    protected void loadData() {
        PrintLog.d("banner loadData()");
        //1.获取banner数据
        mHomeP.getBannerData();
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
        Toast.makeText(mActivity, "showBannerDataToViewError", Toast.LENGTH_SHORT).show();
    }
}
