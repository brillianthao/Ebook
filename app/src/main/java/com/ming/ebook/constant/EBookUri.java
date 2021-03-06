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
    public static final String BASE_URL = "http://novel.juhe.im/";
    /**
     * 首页banner数据源,获取最热榜前4条
     * http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41615%2F_41615_067553.jpg%2F
     * %3A == :
     * %2F == /
     */
    public static final String BANNER = BASE_URL + "rank/54d42d92321052167dfb75e3";

    //获取带书籍数量的父分类
    public static final String CATEGORIES_WITH_COUNT = BASE_URL + "categories";
    /**
     * 获取分类详情
     * query:
     * {type: hot, new, reputation, over
     * gender, type, major(主分类), minor(子分类), start, limit
     * }
     */
    public static final String CATEGORY_HEAD = BASE_URL + "category-info?";
    public static final String CATEGORY_GENDER = "gender=";
    public static final String CATEGORY_TYPE = "&type=";
    public static final String CATEGORY_MAJOR = "&major=";
    public static final String CATEGORY_START = "&minor=&start=";

    public static final String CATEGORY_LIMIT = "&limit=";

    /**
     * 获取书籍详情
     * <p>
     * url: http://novel.juhe.im/
     * <p>
     * params:
     * <p>
     * {
     * id: book id
     * }
     */
    public static final String BOOK_INFO = BASE_URL + "book-info/";
    /**
     * query:
     * {
     * view: summary,
     * book: {bookid}
     * }
     */
    public static final String BOOK_SOURCE = BASE_URL + "book-sources?view=summary&book=";


    /**
     * params:{
     * id:
     * {
     * 书籍源 id
     * }
     */
    public static final String BOOK_CHAPTERS = BASE_URL + "book-chapters/";
    /**
     * params:
     * {
     * link: {目录中的章节link}
     * }
     */
    public static final String BOOK_CHAPTERS_DETAIL = BASE_URL + "chapters/";
}
