package com.ming.ebook;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.ming.ebook.base.BaseActivity;
import com.ming.ebook.base.BaseFragment;
import com.ming.ebook.ebook.BookFragment;
import com.ming.ebook.ehome.HomeFragment;
import com.ming.ebook.emine.MineFragment;
import com.ming.ebook.utils.PrintLog;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    //data
    private ArrayList<BaseFragment> fragments;
    private FragmentManager fm;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getContentViewId() {
        immersiveStatusBar(R.color.orange);
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            PrintLog.d("阻止fragment重复加载");
            savedInstanceState.putParcelable("android:support:fragments", null);
        }
        fm = getSupportFragmentManager();

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        TextBadgeItem numberBadgeItem = new TextBadgeItem()
                .setBorderWidth(4)
                .setBackgroundColor(Color.RED)
                .setText("5")
                .setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Book").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "Mine").setActiveColorResource(R.color.teal))
                .setFirstSelectedPosition(0)
                .initialise();

        fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.layFrame, HomeFragment.newInstance("Home"));
        transaction.commit();
    }

    private ArrayList<BaseFragment> getFragments() {
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("Home"));
        fragments.add(BookFragment.newInstance("Book"));
        fragments.add(MineFragment.newInstance("Mine"));
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                switch (position) {
                    case 0:
                        immersiveStatusBar(R.color.orange);
                        break;
                    case 1:
                        immersiveStatusBar(R.color.blue);
                        break;
                    case 2:
                        immersiveStatusBar(R.color.teal);
                        break;
                    default:
                        break;
                }
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.show(fragment);
                    ft.commitAllowingStateLoss();
                } else {
                    ft.add(R.id.layFrame, fragment);
                    ft.show(fragment);
                    ft.commitAllowingStateLoss();

                }
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.hide(fragment);
                    ft.commitAllowingStateLoss();
                }
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

}
