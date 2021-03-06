package com.ming.ebook.emine;

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

public class MineFragment extends BaseFragment {
    public static MineFragment newInstance(String param1) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        LinearLayout topBar = (LinearLayout) view.findViewById(R.id.mine_top);
        LinearLayout topSearchLL = (LinearLayout) topBar.findViewById(R.id.top_search_ll);
        topSearchLL.setVisibility(View.INVISIBLE);
        TextView title = (TextView) topBar.findViewById(R.id.top_title);
        title.setText("我的");
    }

    @Override
    protected void loadData() {

    }
}
