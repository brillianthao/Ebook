package com.ming.ebook.ehome;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ming.ebook.R;
import com.ming.ebook.base.BaseFragment;


/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public class HomeFragment extends BaseFragment {
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
        LinearLayout topBar= (LinearLayout) view.findViewById(R.id.home_top);
        TextView title= (TextView) topBar.findViewById(R.id.top_title);
        title.setText("Home");
    }

    @Override
    protected void loadData() {

    }
}
