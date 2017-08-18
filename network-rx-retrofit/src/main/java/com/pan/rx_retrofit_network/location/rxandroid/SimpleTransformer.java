package com.pan.rx_retrofit_network.location.rxandroid;


import com.pan.rx_retrofit_network.location.APIException;
import com.pan.rx_retrofit_network.location.BaseResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @param <T>
 */
public class SimpleTransformer<T> implements ObservableTransformer<BaseResponse<T>, T> {
    private static final int Defautl_TIME_OUT = 5;
    private static final int DEFAUTL_RETRY = 5;

    @Override
    public Observable<T> apply(Observable<BaseResponse<T>> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .timeout(Defautl_TIME_OUT, TimeUnit.SECONDS)
                .retry(DEFAUTL_RETRY)
                .flatMap(new Function<BaseResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> apply(@NonNull BaseResponse<T> tBaseResponse) throws Exception {
                        return flatResponse(tBaseResponse);
                    }
                });
    }

    /**
     * 处理请求结果,BaseResponse
     *
     * @param response 请求结果
     * @return 过滤处理, 返回只有data的Observable
     */
    private Observable<T> flatResponse(final BaseResponse<T> response) {

        return  Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
                if (!observableEmitter.isDisposed()) {
                    if (response.isSuccess()) {//请求成功
                        observableEmitter.onNext(response.getData());
                    } else {//请求失败
                        observableEmitter.onError(new APIException(response.getResultCode(), response.getMsg()));
                        return;
                    }
                }
                if (!observableEmitter.isDisposed()) {
                    //请求完成
                    observableEmitter.onComplete();
                }
            }
        });
    }
}