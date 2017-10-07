package com.ming.ebook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/7
 * version：1.0
 * Email:sunming@radacat.com
 */

public class BookChapters implements Serializable {

    /**
     * code : 1
     * message : ok
     * data : {"_id":"5937d42726ced9e7790c4cf8","name":"优质书源","link":"http://vip.zhuishushenqi.com/toc/5937d42726ced9e7790c4cf8","book":"58f1ff09a1a9c5154d692119","chapters":[{"title":"第1章 黑店","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cf9?cv=1498802159633","id":"5937d42726ced9e7790c4cf9","totalpage":0,"partsize":0,"currency":20,"unreadble":false,"isVip":false},{"title":"第2章 主神","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cfa?cv=1498802189378","id":"5937d42726ced9e7790c4cfa","totalpage":0,"partsize":0,"currency":15,"unreadble":false,"isVip":false},{"title":"第3章 怒了","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cfb?cv=1496831015606","id":"5937d42726ced9e7790c4cfb","totalpage":0,"partsize":0,"currency":10,"unreadble":false,"isVip":false},{"title":"第4章 食我大吊","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cfc?cv=1498802459682","id":"5937d42726ced9e7790c4cfc","totalpage":0,"partsize":0,"currency":15,"unreadble":false,"isVip":false},{"title":"第5章 很傻很天真","link":"http://vip.zhuishushenqi"updated":"2017-10-06T16:04:28.289Z","host":"vip.zhuishushenqi.com"}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 5937d42726ced9e7790c4cf8
         * name : 优质书源
         * link : http://vip.zhuishushenqi.com/toc/5937d42726ced9e7790c4cf8
         * book : 58f1ff09a1a9c5154d692119
         * chapters : [
         * {"title":"第1章 黑店","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cf9?cv=1498802159633","id":"5937d42726ced9e7790c4cf9","totalpage":0,"partsize":0,"currency":20,"unreadble":false,"isVip":false},
         * {"title":"第2章 主神","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cfa?cv=1498802189378","id":"5937d42726ced9e7790c4cfa","totalpage":0,"partsize":0,"currency":15,"unreadble":false,"isVip":false},
         * {"title":"第3章 怒了","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cfb?cv=1496831015606","id":"5937d42726ced9e7790c4cfb","totalpage":0,"partsize":0,"currency":10,"unreadble":false,"isVip":false},
         * {"title":"第4章 食我大吊","link":"http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cfc?cv=1498802459682","id":"5937d42726ced9e7790c4cfc","totalpage":0,"partsize":0,"currency":15,"unreadble":false,"isVip":false},
         * {"title":"第5章 很傻很天真","link":"http://vip.zhuishushenqi]
         * updated : 2017-10-06T16:04:28.289Z
         * host : vip.zhuishushenqi.com
         */

        private String _id;
        private String name;
        private String link;
        private String book;
        private String updated;
        private String host;
        private List<ChaptersBean> chapters;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
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

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public List<ChaptersBean> getChapters() {
            return chapters;
        }

        public void setChapters(List<ChaptersBean> chapters) {
            this.chapters = chapters;
        }

        public static class ChaptersBean {
            /**
             * title : 第1章 黑店
             * link : http://vip.zhuishushenqi.com/chapter/5937d42726ced9e7790c4cf9?cv=1498802159633
             * id : 5937d42726ced9e7790c4cf9
             * totalpage : 0
             * partsize : 0
             * currency : 20
             * unreadble : false
             * isVip : false
             */

            private String title;
            private String link;
            private String id;
            private int totalpage;
            private int partsize;
            private int currency;
            private boolean unreadble;
            private boolean isVip;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getTotalpage() {
                return totalpage;
            }

            public void setTotalpage(int totalpage) {
                this.totalpage = totalpage;
            }

            public int getPartsize() {
                return partsize;
            }

            public void setPartsize(int partsize) {
                this.partsize = partsize;
            }

            public int getCurrency() {
                return currency;
            }

            public void setCurrency(int currency) {
                this.currency = currency;
            }

            public boolean isUnreadble() {
                return unreadble;
            }

            public void setUnreadble(boolean unreadble) {
                this.unreadble = unreadble;
            }

            public boolean isIsVip() {
                return isVip;
            }

            public void setIsVip(boolean isVip) {
                this.isVip = isVip;
            }
        }
    }
}
