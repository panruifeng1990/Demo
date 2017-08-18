package com.pan.hjms.mvp.presenter;


import android.util.Log;

import com.pan.hjms.Apn;
import com.pan.hjms.adapter.entity.SellBuilding;
import com.pan.hjms.api.ApiService;
import com.pan.hjms.mvp.base.Module;
import com.pan.rx_retrofit_network.location.retrofit.RetrofitUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * package: com.easyandroid.sectionadapter.mvp.presenter.TestPresenter
 * author: gyc
 * description:
 * time: create at 2017/7/8 9:53
 */

public class TestPresenter implements Module.Presenter{

    private Module.View view;
    private Retrofit retrofit;
    private Retrofit retrofit1;
    private ApiService apiService;
    private ApiService apiService1;
    private HashMap<String,String> map;
    private HashMap<String,String> heardMap;
    public TestPresenter(Module.View view) {
        this.view = view;
        retrofit= RetrofitUtil.getInstance();
        retrofit1= RetrofitUtil.getInstance();
        apiService = retrofit.create(ApiService.class);
        apiService1 = retrofit.create(ApiService.class);
        map = new HashMap<>();
        heardMap = new HashMap<>();
    }

    @Override
    public void loadData(int loadType) {
        map.put("cityId","17");
//        Apn.addHeads(heardMap);
        Observable<SellBuilding> observable = apiService.postGetBanner(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SellBuilding>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SellBuilding sellBuilding) {
                        Log.d("prf",sellBuilding.getData().getBanner().toString());
                        Log.d("prf",sellBuilding.getData().getBanner().get(0).toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("prf",e.toString());
                    }


                    @Override
                    public void onComplete() {

                    }
                });
Observable<SellBuilding> observable1= apiService1.postGetBanner(map);
        observable1.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SellBuilding>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SellBuilding sellBuilding) {
                        Log.d("prf1",sellBuilding.getData().getBanner().toString());
                        Log.d("prf1",sellBuilding.getData().getBanner().get(0).toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("prf",e.toString());
                    }


                    @Override
                    public void onComplete() {

                    }
                });

        List<SellBuilding.DataBean.BannerBean> datas = new ArrayList<>();
        if(view!=null){
//            view.updateSellBuilding(loadType, datas);
        }
    }
}
