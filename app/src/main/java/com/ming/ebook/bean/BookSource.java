package com.ming.ebook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/7
 * version：1.0
 * Email:sunming@radacat.com
 */

public class BookSource implements Serializable{

    /**
     * code : 1
     * message : ok
     * data : [{"_id":"5937d42726ced9e7790c4cf8","source":"zhuishuvip","name":"优质书源","link":"http://vip.zhuishushenqi.com/toc/5937d42726ced9e7790c4cf8","lastChapter":"第523章 序幕 一","isCharge":false,"chaptersCount":528,"updated":"2017-10-06T16:04:28.289Z","starting":true,"host":"vip.zhuishushenqi.com"},{"_id":"5925ed61fb8c65b83420acc5","lastChapter":"第10章 序幕 一","link":"http://www.sanjiangge.com/book/106/106837/index.html","source":"sanjiangge","name":"三江阁","isCharge":false,"chaptersCount":512,"updated":"2017-10-06T21:34:24.662Z","starting":false,"host":"sanjiangge.com"},{"_id":"591b615f1c2880eb4c26135d","lastChapter":"第10章 序幕 一","link":"http://www.79xs.com/Html/Book/212/212127/","source":"shuhaha","name":"79小说网","isCharge":false,"chaptersCount":522,"updated":"2017-10-06T16:08:32.035Z","starting":false,"host":"79xs.com"},{"_id":"58fbbd6da5a9dc520332505c","lastChapter":"第10章 序幕 一","link":"http://www.hunhun520.com/book/zhushendiheidian/","source":"hunhun","name":"混混小说网","isCharge":false,"chaptersCount":519,"updated":"2017-10-06T16:08:31.373Z","starting":false,"host":"hunhun520.com"},{"_id":"59198441dabd13587c6b7753","source":"my176","name":"176小说","link":"http://book.my716.com/getBooks.aspx?method=chapterList&bookId=1506906","lastChapter":"第523章 序幕 一","isCharge":false,"chaptersCount":528,"updated":"2017-10-06T16:08:28.758Z","starting":false,"host":"book.my716.com"},{"_id":"5910d56454789c63113c28db","lastChapter":"第2章 宿命的呼唤 （下）","link":"http://www.luoqiu.com/read/288075/","source":"luoqiu","name":"落秋中文","isCharge":false,"chaptersCount":515,"updated":"2017-10-01T15:14:51.959Z","starting":false,"host":"luoqiu.com"},{"_id":"5910d56454789c63113c28dc","lastChapter":"明天出差","link":"http://www.xiaoxiaoshuwu.com/shtml/545/545153/index.shtml","source":"xiaoxiaoshuwu","name":"小小书屋","isCharge":false,"chaptersCount":475,"updated":"2017-09-17T18:26:41.202Z","starting":false,"host":"xiaoxiaoshuwu.com"}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 5937d42726ced9e7790c4cf8
         * source : zhuishuvip
         * name : 优质书源
         * link : http://vip.zhuishushenqi.com/toc/5937d42726ced9e7790c4cf8
         * lastChapter : 第523章 序幕 一
         * isCharge : false
         * chaptersCount : 528
         * updated : 2017-10-06T16:04:28.289Z
         * starting : true
         * host : vip.zhuishushenqi.com
         */

        private String _id;
        private String source;
        private String name;
        private String link;
        private String lastChapter;
        private boolean isCharge;
        private int chaptersCount;
        private String updated;
        private boolean starting;
        private String host;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public boolean isIsCharge() {
            return isCharge;
        }

        public void setIsCharge(boolean isCharge) {
            this.isCharge = isCharge;
        }

        public int getChaptersCount() {
            return chaptersCount;
        }

        public void setChaptersCount(int chaptersCount) {
            this.chaptersCount = chaptersCount;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public boolean isStarting() {
            return starting;
        }

        public void setStarting(boolean starting) {
            this.starting = starting;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }
    }
}
