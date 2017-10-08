package com.ming.ebook.ebook;

import com.ming.ebook.dao.entity.BookBean;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/7
 * version：1.0
 * Email:sunming@radacat.com
 */

public class BookP implements IeBookP {
    private IeBookM mIeBookM;
    private IeBookV mIeBookV;

    public BookP(IeBookV ieBookV) {
        mIeBookV = ieBookV;
        mIeBookM = new BookM(this);
    }

    @Override
    public void getBooksFromDao() {
        mIeBookM.getBooksFromDao();
    }

    @Override
    public void showBooksToView(List<BookBean> bookBeanList) {
        if (bookBeanList!=null&&bookBeanList.size()>0){
            mIeBookV.showBooksToView(bookBeanList);
        }else{
            mIeBookV.showBooksToViewError();
        }
    }
}
