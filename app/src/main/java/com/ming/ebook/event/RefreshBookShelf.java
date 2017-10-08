package com.ming.ebook.event;

import com.ming.ebook.dao.entity.BookBean;

/**
 * 创建人: sunming
 * 创建时间：2017/10/8
 * version：1.0
 * Email:sunming@radacat.com
 */

public class RefreshBookShelf {
    private BookBean refreshBook;

    public BookBean getRefreshBook() {
        return refreshBook;
    }

    public void setRefreshBook(BookBean refreshBook) {
        this.refreshBook = refreshBook;
    }
}
