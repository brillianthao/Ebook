package com.ming.ebook.utils;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by my on 2017/1/5.
 * 数据模型全局类
 */
public class Model {
    private ExecutorService executors= Executors.newCachedThreadPool();
    private Context mContext;
    //创建对象
    private static Model model=new Model();
    //私有化构造
    private Model() {
    }
    //获取单例对象
    public static Model getInstance(){
        return model;
    }
    //初始化的方法
    public void init(Context context){
        this.mContext=context;
    }
    //获取全局线程池对象
    public ExecutorService getGloablThreadPool(){
        return executors;
    }
}
