package com.ming.ebook.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.ming.ebook.system.SystemBarTintManager;
import com.ming.ebook.utils.PrintLog;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initView(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //布局文件ID
    protected abstract int getContentViewId();

    /**
     *  初始化
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 沉浸状态栏
     * @param color
     */
    @TargetApi(19)
    public void immersiveStatusBar(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            win.setAttributes(winParams);

            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);//通知栏所需颜色

        }else {
            PrintLog.d("need Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT");
        }
    }

}
