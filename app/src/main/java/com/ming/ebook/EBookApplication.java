package com.ming.ebook;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.ming.ebook.utils.Model;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public class EBookApplication extends Application {
    private static EBookApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //分包
        MultiDex.install(this);
        //初始化数据模型层类
        Model.getInstance().init(this);
    }

    public static EBookApplication getInstance() {
        return instance;
    }
}
//1.凡是和UI相关的，都不建议使用Application的Context.
//2..不要让生命周期长的对象引用activity context，即保证引用activity的对象要
// 与activity本身生命周期是一样的，若不一样，请考虑一下是否可以使用Application的Context.
