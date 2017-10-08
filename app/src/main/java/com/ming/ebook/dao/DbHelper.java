package com.ming.ebook.dao;

import android.database.sqlite.SQLiteDatabase;

import com.ming.ebook.EBookApplication;

/**
 * 创建人: sunming
 * 创建时间：2017/10/8
 * version：1.0
 * Email:sunming@radacat.com
 */

public class DbHelper {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private DbHelper() {
        mHelper = new DaoMaster.DevOpenHelper(EBookApplication.getInstance(), "ebook_db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    private static DbHelper instance;

    public static DbHelper getInstance() {
        if (null == instance) {
            synchronized (DbHelper.class) {
                if (null == instance) {
                    instance = new DbHelper();
                }
            }
        }
        return instance;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}

