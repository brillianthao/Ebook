package com.ming.ebook.utils;

import android.text.TextUtils;

/**
 * 创建人: sunming
 * 创建时间：2017/10/4
 * version：1.0
 * Email:sunming@radacat.com
 */

public class RegularUtils {
    /**
     * 解析网络图片地址
     *
     * @param url 传入的地址
     * @return 真正的地址
     * <p>
     * 首页banner数据源,获取最热榜前4条
     * "/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F_1228859_441552.jpg%2F",
     * %3A 替换 :
     * %2F 替换 /
     */
    public static String regularImageUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            //1.先截取到http
            String regString = url.substring(7);
            //2.将%3A 替换 :And  %2F 替换 /
            String httpOk = regString.replaceAll("%3A", ":");

            return httpOk.replaceAll("%2F", "/").trim();
        } else {
            return null;
        }
    }
}
