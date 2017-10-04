package com.ming.ebook.constant;

/**
 * 创建人: sunming
 * 创建时间：2017/10/4
 * version：1.0
 * Email:sunming@radacat.com
 * api接口
 */

public class EBookUri {
    //获取带书籍数量的父分类
    public static final String BASE_URL ="http://novel.juhe.im/";
    //获取带书籍数量的父分类
    public static final String CATEGORIES_WITH_COUNT =BASE_URL+"categories";
    //获取带子分类的分类
    public static final String SUB_CATEGORIES =BASE_URL+"sub-categories";

    /**
     * 获取分类详情
     * query:
     {
     gender, type, major(主分类), minor(子分类), start, limit
     }
     */
    public static final String CATEGORY_INFO =BASE_URL+"category-info?gender="+"male"+"&type="+"hot"+"&major="+"奇幻"+"&minor="+"西方玄幻"+"&start="+"0"+"&limit="+"20";
    /**
     * 获取书籍详情

     url: http://novel.juhe.im/

     params:

     {
     id: book id
     }
     */
    public static final String BOOK_INFO =BASE_URL+"book-info/"+"53115e30173bfacb4904897e";

    /**
     * 首页banner数据源,获取最热榜前4条
     * http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41615%2F_41615_067553.jpg%2F
     * %3A == :
     * %2F == /
     */
    public static final String BANNER =BASE_URL+ "rank/54d42d92321052167dfb75e3";
}
