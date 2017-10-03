package com.ming.ebook;

import android.app.Application;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public class EBookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
//1.凡是和UI相关的，都不建议使用Application的Context.
//2..不要让生命周期长的对象引用activity context，即保证引用activity的对象要
// 与activity本身生命周期是一样的，若不一样，请考虑一下是否可以使用Application的Context.
