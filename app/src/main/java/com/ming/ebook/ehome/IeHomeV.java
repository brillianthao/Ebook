package com.ming.ebook.ehome;

import com.ming.ebook.bean.BannerBean;
import com.ming.ebook.bean.Categories;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public interface IeHomeV {
    /**
     * 返回网络获取数据
     */
    void showBannerDataToView(List<BannerBean.DataBean.RankingBean.BooksBean> bannerBeanList);
    /**
     * 返回网络获取数据null
     */
    void showBannerDataToViewError();

    /**
     * 返回网络获取数据
     */
    void showCategoriesMaleBeanData(List<Categories.DataBean.MaleBean> maleList);

    /**
     * 返回网络获取数据
     */
    void showCategoriesFemaleBeanData(List<Categories.DataBean.FemaleBean> femaleList);

    /**
     * 返回网络获取数据null
     */
    void showCategoriesCountDataError();
}
