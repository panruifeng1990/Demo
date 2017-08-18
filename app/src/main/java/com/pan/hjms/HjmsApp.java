package com.pan.hjms;

import android.app.Application;

import com.pan.rx_retrofit_network.location.retrofit.RetrofitUtil;

/**
 * Created by Lenovo on 2017/8/17.
 */

public class HjmsApp extends Application {
    private static final String BASE_URL = "http://ms.fangodata.com/";

    private static HjmsApp mApp;
    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
    }
    public static HjmsApp getSelf() {
        return mApp;
    }
    private void initRetrofit() {
        RetrofitUtil.init(BASE_URL, this);
    }
}