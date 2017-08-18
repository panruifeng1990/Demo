package com.pan.hjms.api;

import com.pan.hjms.adapter.entity.ContentOperationDate;
import com.pan.hjms.adapter.entity.HomeBanner;
import com.pan.hjms.adapter.entity.MessageUnReadData;
import com.pan.hjms.adapter.entity.SellBuilding;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 2017/6/27.
 */

public interface ApiService {

//    @FormUrlEncoded
//    @POST("dologin")
//    Observable<LoginBean> postLogin(@Field("principal") String principal, @Field("password") String password, @Field("validepassword") String validepassword);
//    @FormUrlEncoded
//    @POST("dologin")
//    Observable<LoginBean> postLogi1(@FieldMap Map<String, String> fields);

    /**获取资讯版块数据**/
    @Headers("token:0669182e86df43fca79b80b27a3e7799")
    @FormUrlEncoded
    @POST("api/contentOperate/getContentOperateList")
    Observable<ContentOperationDate> postContentOperateList(@FieldMap Map<String, String> fields);

    /**获取聊天消息未读数**/
    @POST("api/sys_msg/unreadcnt")
    Observable<MessageUnReadData> postUnreadcnt();

    /**获取首页广告**/
    @FormUrlEncoded
    @POST("api/agency/estate/getAds")
    Observable<HomeBanner> postGetAds(@FieldMap Map<String, String> fields);

    /**获取热销楼盘**/
//    @Headers("token:5b751447c91f4023b043bd0e23909f02")
//    @HeaderMap
    @FormUrlEncoded
    @POST("api/agency/estate/getBanner")
    Observable<SellBuilding> postGetBanner(/*@HeaderMap Map<String,String> map,*/@FieldMap Map<String, String> fields);
    /**获取推荐楼盘**/
    @FormUrlEncoded
    @POST("api/agency/estate/findRecommendEstate")
    Observable<ContentOperationDate> postFindRecommendEstate(@FieldMap Map<String, String> fields);

}
