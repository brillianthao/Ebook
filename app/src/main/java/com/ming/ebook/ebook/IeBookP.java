package com.ming.ebook.ebook;

import com.ming.ebook.dao.entity.BookBean;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public interface IeBookP {
    /**
     * 从数据库取出书架信息
     */
    void getBooksFromDao();

    /**
     * 从数据库取出书架信息
     */
    void showBooksToView(List<BookBean> bookBeanList);
}
