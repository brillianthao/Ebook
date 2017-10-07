package com.ming.ebook.ebook;

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

public class BookFragment extends BaseFragment implements IeBookV{
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
    }

    @Override
    protected void loadData() {

    }
}
