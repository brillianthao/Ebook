package com.ming.ebook.ebook;

import com.ming.ebook.dao.entity.BookBean;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public interface IeBookV {
    /**
     * 展示书架信息
     */
    void showBooksToView(List<BookBean> bookBeanList);
    /**
     * 展示书架信息错误
     */
    void showBooksToViewError();
}
