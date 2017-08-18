package com.pan.hjms.adapter.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/8/17.
 */

public class SellBuilding extends BaseResult{

    /**
     * success : true
     * msg :
     * code : 0
     * page : null
     * data : {"banner":[{"id":2348,"name":"派拉蒙酒店大厦（运营）","url":"http://img.51moshou.com/images/banner/2016/08/22/57ba97662bbd4.jpeg","distance":null,"shipAgencyNum":0,"favorite":"1","commissionType":1,"commissionBegin":"1","commissionEnd":"1.5","commissionDisplay":"1","featureTag":null,"longitude":91.125493,"latitude":29.660081,"address":"拉萨市布达拉宫","customerTelType":"0","status":"process","cityId":"17","cityName":"拉萨市","processTime":"2016-08-22 13:24:49","isNew":"0","customerVisitEnable":"0","mechanismType":"0","trystCar":"0","bedroomSegment":null,"saleAreaSegment":null,"mechanismText":"","isHot":"1","isSpecialPrice":"0","districtName":"尼木县","plateName":"布阿达","dynamicMsg":null,"price":"15000元/平","priceLabel":"均价","priceValue":"15000元/平","agencyReportType":"0"},{"id":2376,"name":"证大大拇指广场(运营)","url":"http://img.51moshou.com/images/banner/2017/01/18/587f847f72289.jpeg","distance":null,"shipAgencyNum":0,"favorite":"1","commissionType":1,"commissionBegin":"1","commissionEnd":"1.5","commissionDisplay":"0","featureTag":null,"longitude":91.123396,"latitude":29.65329,"address":"布达拉宫","customerTelType":"1","status":"process","cityId":"17","cityName":"拉萨市","processTime":"2016-09-02 14:06:16","isNew":"0","customerVisitEnable":"1","mechanismType":"0","trystCar":"0","bedroomSegment":"2-3居","saleAreaSegment":"88-90平","mechanismText":"报备该楼盘，需要您填写客户到访信息","isHot":"1","isSpecialPrice":"0","districtName":"尼木县","plateName":"布阿达","dynamicMsg":"本月主推8#楼","price":"30000元/平","priceLabel":"均价","priceValue":"30000元/平","agencyReportType":"0"},{"id":2611,"name":"银亿东城(运营)","url":"http://img.51moshou.com/images/banner/2017/03/14/58c799a2cbe15.jpeg","distance":null,"shipAgencyNum":0,"favorite":"1","commissionType":0,"commissionBegin":"1.1","commissionEnd":"","commissionDisplay":"1","featureTag":null,"longitude":91.276763,"latitude":29.894737,"address":"拉萨市苏州路100号","customerTelType":"0","status":"process","cityId":"17","cityName":"拉萨市","processTime":"2016-08-19 17:15:09","isNew":"0","customerVisitEnable":"0","mechanismType":"0","trystCar":"0","bedroomSegment":"2-4居","saleAreaSegment":"75-146平","mechanismText":"","isHot":"1","isSpecialPrice":"0","districtName":"尼木县","plateName":"布阿达","dynamicMsg":"2017年8月1日 开盘","price":"18000元/平","priceLabel":"均价","priceValue":"18000元/平","agencyReportType":"0"},{"id":2583,"name":"新城保利天地(运营)","url":"http://img.51moshou.com/images/banner/2017/03/20/58cf85e78b81c.jpeg","distance":null,"shipAgencyNum":0,"favorite":"1","commissionType":0,"commissionBegin":"0.64","commissionEnd":"","commissionDisplay":"0","featureTag":null,"longitude":91.119319,"latitude":29.652092,"address":"拉萨市金珠东路3号","customerTelType":"1","status":"process","cityId":"17","cityName":"拉萨市","processTime":"2016-12-05 13:04:45","isNew":"0","customerVisitEnable":"0","mechanismType":"0","trystCar":"0","bedroomSegment":null,"saleAreaSegment":null,"mechanismText":"该楼盘要求必须全号报备客户","isHot":"1","isSpecialPrice":"0","districtName":"尼木县","plateName":"布阿达","dynamicMsg":null,"price":"17000元/平","priceLabel":"均价","priceValue":"17000元/平","agencyReportType":"0"},{"id":2589,"name":"恒大金碧天下(运营)","url":"http://img.51moshou.com/images/banner/2017/03/20/58cf860761b4b.png","distance":null,"shipAgencyNum":0,"favorite":"0","commissionType":0,"commissionBegin":"1.9","commissionEnd":"","commissionDisplay":"0","featureTag":null,"longitude":91.132137,"latitude":29.653257,"address":"拉萨市江苏路7号","customerTelType":"1","status":"process","cityId":"17","cityName":"拉萨市","processTime":"2016-10-14 16:30:35","isNew":"0","customerVisitEnable":"0","mechanismType":"0","trystCar":"0","bedroomSegment":null,"saleAreaSegment":null,"mechanismText":"该楼盘要求必须全号报备客户","isHot":"1","isSpecialPrice":"0","districtName":"尼木县","plateName":"布阿达","dynamicMsg":null,"price":"8000元/平","priceLabel":"均价","priceValue":"8000元/平","agencyReportType":"0"},{"id":2565,"name":"泰禾中央广场(运营)","url":"http://img.51moshou.com/images/banner/2017/03/20/58cf861b514cb.jpeg","distance":null,"shipAgencyNum":0,"favorite":"0","commissionType":0,"commissionBegin":"1.25","commissionEnd":"","commissionDisplay":"0","featureTag":null,"longitude":91.130839,"latitude":29.680501,"address":"拉萨市娘热北路234号","customerTelType":"1","status":"process","cityId":"17","cityName":"拉萨市","processTime":"2016-12-13 15:21:37","isNew":"0","customerVisitEnable":"0","mechanismType":"0","trystCar":"0","bedroomSegment":"2-3居","saleAreaSegment":"76-116平","mechanismText":"该楼盘要求必须全号报备客户","isHot":"1","isSpecialPrice":"0","districtName":"尼木县","plateName":"布阿达","dynamicMsg":"\u2026\u2026","price":"54000元/平","priceLabel":"均价","priceValue":"54000元/平","agencyReportType":"0"}]}
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

    public static class DataBean implements Serializable{
        private List<BannerBean> banner;

        public List<BannerBean> getBanner() {
            if (banner == null){
                banner = new ArrayList<BannerBean>();
            }
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class BannerBean {
            /**
             * id : 2348
             * name : 派拉蒙酒店大厦（运营）
             * url : http://img.51moshou.com/images/banner/2016/08/22/57ba97662bbd4.jpeg
             * distance : null
             * shipAgencyNum : 0
             * favorite : 1
             * commissionType : 1
             * commissionBegin : 1
             * commissionEnd : 1.5
             * commissionDisplay : 1
             * featureTag : null
             * longitude : 91.125493
             * latitude : 29.660081
             * address : 拉萨市布达拉宫
             * customerTelType : 0
             * status : process
             * cityId : 17
             * cityName : 拉萨市
             * processTime : 2016-08-22 13:24:49
             * isNew : 0
             * customerVisitEnable : 0
             * mechanismType : 0
             * trystCar : 0
             * bedroomSegment : null
             * saleAreaSegment : null
             * mechanismText :
             * isHot : 1
             * isSpecialPrice : 0
             * districtName : 尼木县
             * plateName : 布阿达
             * dynamicMsg : null
             * price : 15000元/平
             * priceLabel : 均价
             * priceValue : 15000元/平
             * agencyReportType : 0
             */

            private int id;
            private String name;
            private String url;
            private String distance;
            private int shipAgencyNum;
            private String favorite;
            private int commissionType;
            private String commissionBegin;
            private String commissionEnd;
            private String commissionDisplay;
            private String featureTag;
            private double longitude;
            private double latitude;
            private String address;
            private String customerTelType;
            private String status;
            private String cityId;
            private String cityName;
            private String processTime;
            private String isNew;
            private String customerVisitEnable;
            private String mechanismType;
            private String trystCar;
            private String bedroomSegment;
            private String saleAreaSegment;
            private String mechanismText;
            private String isHot;
            private String isSpecialPrice;
            private String districtName;
            private String plateName;
            private String dynamicMsg;
            private String price;
            private String priceLabel;
            private String priceValue;
            private String agencyReportType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getShipAgencyNum() {
                return shipAgencyNum;
            }

            public void setShipAgencyNum(int shipAgencyNum) {
                this.shipAgencyNum = shipAgencyNum;
            }

            public String getFavorite() {
                return favorite;
            }

            public void setFavorite(String favorite) {
                this.favorite = favorite;
            }

            public int getCommissionType() {
                return commissionType;
            }

            public void setCommissionType(int commissionType) {
                this.commissionType = commissionType;
            }

            public String getCommissionBegin() {
                return commissionBegin;
            }

            public void setCommissionBegin(String commissionBegin) {
                this.commissionBegin = commissionBegin;
            }

            public String getCommissionEnd() {
                return commissionEnd;
            }

            public void setCommissionEnd(String commissionEnd) {
                this.commissionEnd = commissionEnd;
            }

            public String getCommissionDisplay() {
                return commissionDisplay;
            }

            public void setCommissionDisplay(String commissionDisplay) {
                this.commissionDisplay = commissionDisplay;
            }

            public String getFeatureTag() {
                return featureTag;
            }

            public void setFeatureTag(String featureTag) {
                this.featureTag = featureTag;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCustomerTelType() {
                return customerTelType;
            }

            public void setCustomerTelType(String customerTelType) {
                this.customerTelType = customerTelType;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getProcessTime() {
                return processTime;
            }

            public void setProcessTime(String processTime) {
                this.processTime = processTime;
            }

            public String getIsNew() {
                return isNew;
            }

            public void setIsNew(String isNew) {
                this.isNew = isNew;
            }

            public String getCustomerVisitEnable() {
                return customerVisitEnable;
            }

            public void setCustomerVisitEnable(String customerVisitEnable) {
                this.customerVisitEnable = customerVisitEnable;
            }

            public String getMechanismType() {
                return mechanismType;
            }

            public void setMechanismType(String mechanismType) {
                this.mechanismType = mechanismType;
            }

            public String getTrystCar() {
                return trystCar;
            }

            public void setTrystCar(String trystCar) {
                this.trystCar = trystCar;
            }

            public String getBedroomSegment() {
                return bedroomSegment;
            }

            public void setBedroomSegment(String bedroomSegment) {
                this.bedroomSegment = bedroomSegment;
            }

            public String getSaleAreaSegment() {
                return saleAreaSegment;
            }

            public void setSaleAreaSegment(String saleAreaSegment) {
                this.saleAreaSegment = saleAreaSegment;
            }

            public String getMechanismText() {
                return mechanismText;
            }

            public void setMechanismText(String mechanismText) {
                this.mechanismText = mechanismText;
            }

            public String getIsHot() {
                return isHot;
            }

            public void setIsHot(String isHot) {
                this.isHot = isHot;
            }

            public String getIsSpecialPrice() {
                return isSpecialPrice;
            }

            public void setIsSpecialPrice(String isSpecialPrice) {
                this.isSpecialPrice = isSpecialPrice;
            }

            public String getDistrictName() {
                return districtName;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            public String getPlateName() {
                return plateName;
            }

            public void setPlateName(String plateName) {
                this.plateName = plateName;
            }

            public String getDynamicMsg() {
                return dynamicMsg;
            }

            public void setDynamicMsg(String dynamicMsg) {
                this.dynamicMsg = dynamicMsg;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPriceLabel() {
                return priceLabel;
            }

            public void setPriceLabel(String priceLabel) {
                this.priceLabel = priceLabel;
            }

            public String getPriceValue() {
                return priceValue;
            }

            public void setPriceValue(String priceValue) {
                this.priceValue = priceValue;
            }

            public String getAgencyReportType() {
                return agencyReportType;
            }

            public void setAgencyReportType(String agencyReportType) {
                this.agencyReportType = agencyReportType;
            }
        }
    }
}
