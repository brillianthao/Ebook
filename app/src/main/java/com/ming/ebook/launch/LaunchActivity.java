package com.ming.ebook.launch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ming.ebook.MainActivity;
import com.ming.ebook.R;
import com.ming.ebook.base.BaseActivity;
import com.ming.ebook.constant.AppConstans;
import com.ming.ebook.cache.ACache;


public class LaunchActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        immersiveStatusBar(R.color.transparent);
        return R.layout.activity_launch;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //在主线程中执行
                //首先判断用户是否是第一次启动App
                ACache appCache = ACache.get(LaunchActivity.this, AppConstans.FIRST_CACHE);
                if (appCache.getAsString(AppConstans.FIRST_CACHE)==null){
                    appCache.put(AppConstans.FIRST_CACHE,AppConstans.FIRST_CACHE);
                    startActivity(GuideActivity.class);

                }else {
                    startActivity(MainActivity.class);
                }
            }
        }, 2000);
    }

    /**
     * 启动方法
     * @param cls
     */
    private void startActivity(Class<?> cls) {
        Intent intent=new Intent(this,cls);
        startActivity(intent);
        LaunchActivity.this.finish();
    }
}
