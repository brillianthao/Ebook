package com.ming.ebook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/5
 * version：1.0
 * Email:sunming@radacat.com
 */

public class Categories implements Serializable{

    /**
     * code : 1
     * message : ok
     * data : {"male":[{"name":"玄幻","bookCount":481179,"monthlyCount":13467,"icon":"/icon/玄幻_.png"},{"name":"奇幻","bookCount":43973,"monthlyCount":1393,"icon":"/icon/奇幻_.png"},{"name":"武侠","bookCount":39449,"monthlyCount":961,"icon":"/icon/武侠_.png"},{"name":"仙侠","bookCount":127023,"monthlyCount":5340,"icon":"/icon/仙侠_.png"},{"name":"都市","bookCount":346645,"monthlyCount":9063,"icon":"/icon/都市_.png"},{"name":"职场","bookCount":16103,"monthlyCount":665,"icon":"/icon/职场_.png"},{"name":"历史","bookCount":69034,"monthlyCount":2201,"icon":"/icon/历史_.png"},{"name":"军事","bookCount":14614,"monthlyCount":1094,"icon":"/icon/军事_.png"},{"name":"游戏","bookCount":79172,"monthlyCount":1904,"icon":"/icon/游戏_.png"},{"name":"竞技","bookCount":5551,"monthlyCount":243,"icon":"/icon/竞技_.png"},{"name":"科幻","bookCount":112636,"monthlyCount":1655,"icon":"/icon/科幻_.png"},{"name":"灵异","bookCount":32284,"monthlyCount":2495,"icon":"/icon/灵异_.png"},{"name":"同人","bookCount":36409,"monthlyCount":323,"icon":"/icon/同人_.png"},{"name":"轻小说","bookCount":4412,"monthlyCount":208,"icon":"/icon/轻小说_.png"}],"female":[{"name":"古代言情","bookCount":444379,"monthlyCount":9367,"icon":"/icon/古代言情_.png"},{"name":"现代言情","bookCount":561209,"monthlyCount":14301,"icon":"/icon/现代言情_.png"},{"name":"青春校园","bookCount":106020,"monthlyCount":2513,"icon":"/icon/青春校园_.png"},{"name":"纯爱","bookCount":130282,"monthlyCount":1048,"icon":"/icon/耽美_.png"},{"name":"玄幻奇幻","bookCount":129136,"monthlyCount":423,"icon":"/icon/玄幻奇幻_.png"},{"name":"武侠仙侠","bookCount":62908,"monthlyCount":1308,"icon":"/icon/武侠仙侠_.png"},{"name":"科幻","bookCount":9233,"monthlyCount":245,"icon":"/icon/科幻_.png"},{"name":"游戏竞技","bookCount":6275,"monthlyCount":138,"icon":"/icon/游戏竞技_.png"},{"name":"悬疑灵异","bookCount":14346,"monthlyCount":486,"icon":"/icon/悬疑灵异_.png"},{"name":"同人","bookCount":122541,"monthlyCount":146,"icon":"/icon/同人_.png"},{"name":"女尊","bookCount":20712,"monthlyCount":878,"icon":"/icon/女尊_.png"},{"name":"莉莉","bookCount":25478,"monthlyCount":34,"icon":"/icon/百合_.png"}],"picture":[{"name":"热血","bookCount":330,"monthlyCount":0,"icon":"/icon/热血_.png"},{"name":"魔幻","bookCount":331,"monthlyCount":0,"icon":"/icon/魔幻_.png"},{"name":"科幻","bookCount":64,"monthlyCount":0,"icon":"/icon/科幻_.png"},{"name":"恋爱","bookCount":557,"monthlyCount":0,"icon":"/icon/恋爱_.png"},{"name":"搞笑","bookCount":562,"monthlyCount":0,"icon":"/icon/搞笑_.png"},{"name":"悬疑","bookCount":172,"monthlyCount":0,"icon":"/icon/悬疑_.png"},{"name":"少儿","bookCount":2610,"monthlyCount":0,"icon":"/icon/少儿_.png"}],"press":[{"name":"传记名著","bookCount":2801,"monthlyCount":0,"icon":"/icon/传记名著_.png"},{"name":"出版小说","bookCount":5377,"monthlyCount":0,"icon":"/icon/出版小说_.png"},{"name":"人文社科","bookCount":15085,"monthlyCount":0,"icon":"/icon/人文社科_.png"},{"name":"生活时尚","bookCount":1304,"monthlyCount":0,"icon":"/icon/生活时尚_.png"},{"name":"经管理财","bookCount":4720,"monthlyCount":0,"icon":"/icon/经管理财_.png"},{"name":"青春言情","bookCount":3651,"monthlyCount":0,"icon":"/icon/青春言情_.png"},{"name":"外文原版","bookCount":686,"monthlyCount":0,"icon":"/icon/外文原版_.png"},{"name":"政治军事","bookCount":312,"monthlyCount":0,"icon":"/icon/政治军事_.png"},{"name":"成功励志","bookCount":5636,"monthlyCount":0,"icon":"/icon/成功励志_.png"},{"name":"育儿健康","bookCount":4874,"monthlyCount":0,"icon":"/icon/育儿健康_.png"}],"ok":true}
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
         * male : [{"name":"玄幻","bookCount":481179,"monthlyCount":13467,"icon":"/icon/玄幻_.png"},{"name":"奇幻","bookCount":43973,"monthlyCount":1393,"icon":"/icon/奇幻_.png"},{"name":"武侠","bookCount":39449,"monthlyCount":961,"icon":"/icon/武侠_.png"},{"name":"仙侠","bookCount":127023,"monthlyCount":5340,"icon":"/icon/仙侠_.png"},{"name":"都市","bookCount":346645,"monthlyCount":9063,"icon":"/icon/都市_.png"},{"name":"职场","bookCount":16103,"monthlyCount":665,"icon":"/icon/职场_.png"},{"name":"历史","bookCount":69034,"monthlyCount":2201,"icon":"/icon/历史_.png"},{"name":"军事","bookCount":14614,"monthlyCount":1094,"icon":"/icon/军事_.png"},{"name":"游戏","bookCount":79172,"monthlyCount":1904,"icon":"/icon/游戏_.png"},{"name":"竞技","bookCount":5551,"monthlyCount":243,"icon":"/icon/竞技_.png"},{"name":"科幻","bookCount":112636,"monthlyCount":1655,"icon":"/icon/科幻_.png"},{"name":"灵异","bookCount":32284,"monthlyCount":2495,"icon":"/icon/灵异_.png"},{"name":"同人","bookCount":36409,"monthlyCount":323,"icon":"/icon/同人_.png"},{"name":"轻小说","bookCount":4412,"monthlyCount":208,"icon":"/icon/轻小说_.png"}]
         * female : [{"name":"古代言情","bookCount":444379,"monthlyCount":9367,"icon":"/icon/古代言情_.png"},{"name":"现代言情","bookCount":561209,"monthlyCount":14301,"icon":"/icon/现代言情_.png"},{"name":"青春校园","bookCount":106020,"monthlyCount":2513,"icon":"/icon/青春校园_.png"},{"name":"纯爱","bookCount":130282,"monthlyCount":1048,"icon":"/icon/耽美_.png"},{"name":"玄幻奇幻","bookCount":129136,"monthlyCount":423,"icon":"/icon/玄幻奇幻_.png"},{"name":"武侠仙侠","bookCount":62908,"monthlyCount":1308,"icon":"/icon/武侠仙侠_.png"},{"name":"科幻","bookCount":9233,"monthlyCount":245,"icon":"/icon/科幻_.png"},{"name":"游戏竞技","bookCount":6275,"monthlyCount":138,"icon":"/icon/游戏竞技_.png"},{"name":"悬疑灵异","bookCount":14346,"monthlyCount":486,"icon":"/icon/悬疑灵异_.png"},{"name":"同人","bookCount":122541,"monthlyCount":146,"icon":"/icon/同人_.png"},{"name":"女尊","bookCount":20712,"monthlyCount":878,"icon":"/icon/女尊_.png"},{"name":"莉莉","bookCount":25478,"monthlyCount":34,"icon":"/icon/百合_.png"}]
         * picture : [{"name":"热血","bookCount":330,"monthlyCount":0,"icon":"/icon/热血_.png"},{"name":"魔幻","bookCount":331,"monthlyCount":0,"icon":"/icon/魔幻_.png"},{"name":"科幻","bookCount":64,"monthlyCount":0,"icon":"/icon/科幻_.png"},{"name":"恋爱","bookCount":557,"monthlyCount":0,"icon":"/icon/恋爱_.png"},{"name":"搞笑","bookCount":562,"monthlyCount":0,"icon":"/icon/搞笑_.png"},{"name":"悬疑","bookCount":172,"monthlyCount":0,"icon":"/icon/悬疑_.png"},{"name":"少儿","bookCount":2610,"monthlyCount":0,"icon":"/icon/少儿_.png"}]
         * press : [{"name":"传记名著","bookCount":2801,"monthlyCount":0,"icon":"/icon/传记名著_.png"},{"name":"出版小说","bookCount":5377,"monthlyCount":0,"icon":"/icon/出版小说_.png"},{"name":"人文社科","bookCount":15085,"monthlyCount":0,"icon":"/icon/人文社科_.png"},{"name":"生活时尚","bookCount":1304,"monthlyCount":0,"icon":"/icon/生活时尚_.png"},{"name":"经管理财","bookCount":4720,"monthlyCount":0,"icon":"/icon/经管理财_.png"},{"name":"青春言情","bookCount":3651,"monthlyCount":0,"icon":"/icon/青春言情_.png"},{"name":"外文原版","bookCount":686,"monthlyCount":0,"icon":"/icon/外文原版_.png"},{"name":"政治军事","bookCount":312,"monthlyCount":0,"icon":"/icon/政治军事_.png"},{"name":"成功励志","bookCount":5636,"monthlyCount":0,"icon":"/icon/成功励志_.png"},{"name":"育儿健康","bookCount":4874,"monthlyCount":0,"icon":"/icon/育儿健康_.png"}]
         * ok : true
         */

        private boolean ok;
        private List<MaleBean> male;
        private List<FemaleBean> female;
        private List<PictureBean> picture;
        private List<PressBean> press;

        public boolean isOk() {
            return ok;
        }

        public void setOk(boolean ok) {
            this.ok = ok;
        }

        public List<MaleBean> getMale() {
            return male;
        }

        public void setMale(List<MaleBean> male) {
            this.male = male;
        }

        public List<FemaleBean> getFemale() {
            return female;
        }

        public void setFemale(List<FemaleBean> female) {
            this.female = female;
        }

        public List<PictureBean> getPicture() {
            return picture;
        }

        public void setPicture(List<PictureBean> picture) {
            this.picture = picture;
        }

        public List<PressBean> getPress() {
            return press;
        }

        public void setPress(List<PressBean> press) {
            this.press = press;
        }

        public static class MaleBean {
            /**
             * name : 玄幻
             * bookCount : 481179
             * monthlyCount : 13467
             * icon : /icon/玄幻_.png
             */

            private String name;
            private int bookCount;
            private int monthlyCount;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBookCount() {
                return bookCount;
            }

            public void setBookCount(int bookCount) {
                this.bookCount = bookCount;
            }

            public int getMonthlyCount() {
                return monthlyCount;
            }

            public void setMonthlyCount(int monthlyCount) {
                this.monthlyCount = monthlyCount;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            @Override
            public String toString() {
                return "MaleBean{" +
                        "name='" + name + '\'' +
                        ", bookCount=" + bookCount +
                        ", monthlyCount=" + monthlyCount +
                        ", icon='" + icon + '\'' +
                        '}';
            }
        }

        public static class FemaleBean {
            /**
             * name : 古代言情
             * bookCount : 444379
             * monthlyCount : 9367
             * icon : /icon/古代言情_.png
             */

            private String name;
            private int bookCount;
            private int monthlyCount;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBookCount() {
                return bookCount;
            }

            public void setBookCount(int bookCount) {
                this.bookCount = bookCount;
            }

            public int getMonthlyCount() {
                return monthlyCount;
            }

            public void setMonthlyCount(int monthlyCount) {
                this.monthlyCount = monthlyCount;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            @Override
            public String toString() {
                return "FemaleBean{" +
                        "name='" + name + '\'' +
                        ", bookCount=" + bookCount +
                        ", monthlyCount=" + monthlyCount +
                        ", icon='" + icon + '\'' +
                        '}';
            }
        }

        public static class PictureBean {
            /**
             * name : 热血
             * bookCount : 330
             * monthlyCount : 0
             * icon : /icon/热血_.png
             */

            private String name;
            private int bookCount;
            private int monthlyCount;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBookCount() {
                return bookCount;
            }

            public void setBookCount(int bookCount) {
                this.bookCount = bookCount;
            }

            public int getMonthlyCount() {
                return monthlyCount;
            }

            public void setMonthlyCount(int monthlyCount) {
                this.monthlyCount = monthlyCount;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class PressBean {
            /**
             * name : 传记名著
             * bookCount : 2801
             * monthlyCount : 0
             * icon : /icon/传记名著_.png
             */

            private String name;
            private int bookCount;
            private int monthlyCount;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBookCount() {
                return bookCount;
            }

            public void setBookCount(int bookCount) {
                this.bookCount = bookCount;
            }

            public int getMonthlyCount() {
                return monthlyCount;
            }

            public void setMonthlyCount(int monthlyCount) {
                this.monthlyCount = monthlyCount;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
