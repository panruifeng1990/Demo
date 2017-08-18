package com.pan.rx_retrofit_network.location.rxandroid;


import android.util.Log;

import com.pan.rx_retrofit_network.location.APIException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.ObservableEmitter;
import retrofit2.adapter.rxjava2.HttpException;

/**
 * @author jlanglang  2016/11/14 17:32
 * @版本 2.0
 * @Change
 */
public abstract class SimpleEmitter<T> implements ObservableEmitter<T> {

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        String errormsg;
        if (e instanceof APIException) {
            APIException exception = (APIException) e;
            errormsg = exception.message;
        } else if (e instanceof UnknownHostException) {
            errormsg = "请打开网络";
        } else if (e instanceof SocketTimeoutException) {
            errormsg = "请求超时";
        } else if (e instanceof ConnectException) {
            errormsg = "连接失败";
        } else if (e instanceof HttpException) {
            errormsg = "请求超时";
        } else {
            errormsg = "请求失败";
        }
        errorMessage(errormsg);
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        if (t != null) {
            call(t);
        } else {
            errorMessage("连接失败");
        }
    }

    public void errorMessage(String errormsg) {
        Log.e("prf","errormsg = " + errormsg);

    }

    public abstract void call(T t);
}
