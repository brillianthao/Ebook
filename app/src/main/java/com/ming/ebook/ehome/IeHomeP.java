package com.ming.ebook.ehome;

import com.ming.ebook.bean.BannerBean;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public interface IeHomeP {
    /**
     * 获取数据
     */
    void getBannerData();
    /**
     * 数据返给P层
     *
     * @param books 书列表
     */
    void bannerDataBackP(List<BannerBean.DataBean.RankingBean.BooksBean> books);
}
