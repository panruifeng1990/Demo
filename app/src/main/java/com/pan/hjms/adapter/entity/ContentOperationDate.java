package com.pan.hjms.adapter.entity;


/**
 * 首页内容运营bean类
 */
public class ContentOperationDate extends BaseResult {

    /**
     * page : null
     * data : {"recd_project":{"imgUrl":"http://img.51moshou.com/images/apprecd/2017/03/15/58c8a41ead16f.jpeg","id":35,"title":"我爱新房特惠周","isSkipUrl":"2","type":"RECD_PROJECT","skipUrl":"http://mp.weixin.qq.com/s/ygpyrM6NKu9KNH8zL1kB9g"},"recd_agency":{},"recd_news":{"imgUrl":"http://img.51moshou.com/images/operate/2017/05/22/59223fb17afdf.jpeg","id":162,"title":"楼市\u201c限售\u201d超30城 调控收紧","isSkipUrl":"1","type":"RECD_NEWS","skipUrl":""},"recd_features":{"imgUrl":"http://img.51moshou.com/images/appnewfeatures/2017/04/13/58eeea1a9ec21.jpeg","id":13,"title":"新功能：楼盘信息变更早知道！","isSkipUrl":null,"type":"RECD_FEATURES","skipUrl":""}}
     */

    private DataBean data;

    public DataBean getData() {
        if (data == null){
            data = new DataBean();
        }
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * recd_project : {"imgUrl":"http://img.51moshou.com/images/apprecd/2017/03/15/58c8a41ead16f.jpeg","id":35,"title":"我爱新房特惠周","isSkipUrl":"2","type":"RECD_PROJECT","skipUrl":"http://mp.weixin.qq.com/s/ygpyrM6NKu9KNH8zL1kB9g"}
         * recd_agency : {}
         * recd_news : {"imgUrl":"http://img.51moshou.com/images/operate/2017/05/22/59223fb17afdf.jpeg","id":162,"title":"楼市\u201c限售\u201d超30城 调控收紧","isSkipUrl":"1","type":"RECD_NEWS","skipUrl":""}
         * recd_features : {"imgUrl":"http://img.51moshou.com/images/appnewfeatures/2017/04/13/58eeea1a9ec21.jpeg","id":13,"title":"新功能：楼盘信息变更早知道！","isSkipUrl":null,"type":"RECD_FEATURES","skipUrl":""}
         */

        private RecdProjectBean recd_project;
        private RecdProjectBean recd_agency;
        private RecdProjectBean recd_news;
        private RecdProjectBean recd_features;

        public RecdProjectBean getRecd_project() {
            return recd_project;
        }

        public void setRecd_project(RecdProjectBean recd_project) {
            this.recd_project = recd_project;
        }

        public RecdProjectBean getRecd_agency() {
            return recd_agency;
        }

        public void setRecd_agency(RecdProjectBean recd_agency) {
            this.recd_agency = recd_agency;
        }

        public RecdProjectBean getRecd_news() {
            return recd_news;
        }

        public void setRecd_news(RecdProjectBean recd_news) {
            this.recd_news = recd_news;
        }

        public RecdProjectBean getRecd_features() {
            return recd_features;
        }

        public void setRecd_features(RecdProjectBean recd_features) {
            this.recd_features = recd_features;
        }

        public static class RecdProjectBean {
            /**
             * imgUrl : http://img.51moshou.com/images/apprecd/2017/03/15/58c8a41ead16f.jpeg
             * id : 35
             * title : 我爱新房特惠周
             * isSkipUrl : 2
             * type : RECD_PROJECT
             * skipUrl : http://mp.weixin.qq.com/s/ygpyrM6NKu9KNH8zL1kB9g
             */

            private String imgUrl;
            private int id;
            private String title;
            private String isSkipUrl;
            private String type;
            private String skipUrl;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIsSkipUrl() {
                return isSkipUrl;
            }

            public void setIsSkipUrl(String isSkipUrl) {
                this.isSkipUrl = isSkipUrl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSkipUrl() {
                return skipUrl;
            }

            public void setSkipUrl(String skipUrl) {
                this.skipUrl = skipUrl;
            }
        }

    }
}
