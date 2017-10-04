package com.ming.ebook.ehome;

/**
 * 创建人: sunming
 * 创建时间：2017/10/2
 * version：1.0
 * Email:sunming@radacat.com
 */

public interface IeHomeM {
    /**
     * 通过url获取数据
     *
     * @param url url
     */
    void getBannerDataByUrl(String url);

    /**
     * 通过Cache获取数据
     *
     * @param bannerKey ACache的key
     */
    void getBannerDataByCache(String bannerKey);
}
