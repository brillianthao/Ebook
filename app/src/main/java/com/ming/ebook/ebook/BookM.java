package com.ming.ebook.ebook;

import com.ming.ebook.dao.DbHelper;
import com.ming.ebook.dao.entity.BookBean;
import com.ming.ebook.utils.Model;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/7
 * version：1.0
 * Email:sunming@radacat.com
 */

public class BookM implements IeBookM {
    private IeBookP mIeBookP;

    public BookM(IeBookP ieBookP) {
        mIeBookP = ieBookP;
    }

    @Override
    public void getBooksFromDao() {
        Model.getInstance().getGloablThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //查询所有书籍
                List<BookBean> books = DbHelper.getInstance().getmDaoSession().getBookBeanDao().queryBuilder().list();
                mIeBookP.showBooksToView(books);
            }
        });
    }
}
