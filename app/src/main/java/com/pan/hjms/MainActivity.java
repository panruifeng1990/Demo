package com.pan.hjms;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.pan.hjms.adapter.entity.ContentOperationDate;
import com.pan.hjms.adapter.entity.GridViewIndex;
import com.pan.hjms.adapter.entity.HomeBanner;
import com.pan.hjms.adapter.entity.MessageUnReadData;
import com.pan.hjms.adapter.entity.SellBuilding;
import com.pan.hjms.mvp.base.Module;
import com.pan.hjms.mvp.presenter.TestPresenter;
import com.pan.rx_retrofit_network.SharePreferenceUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout
        .OnRefreshListener, Module.View{

    @BindView(R.id.swip_root)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rv)
    RecyclerView rv;
    TestPresenter mPresenter;
    private SharePreferenceUtil sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sp = new SharePreferenceUtil(this,"headerInfo");
        sp.setString("token","5b751447c91f4023b043bd0e23909f02");
        sp.setString("cityName","北京");
        mPresenter = new TestPresenter(this);
        mPresenter.loadData(1);

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorMsg) {

    }


    @Override
    public void updateSellBuilding(int type, List<SellBuilding.DataBean.BannerBean> datas) {

    }

    @Override
    public void updateBanner(List<HomeBanner.DataBean.AdsBean> datas) {

    }

    @Override
    public void updateGrid(List<GridViewIndex> datas) {

    }

    @Override
    public void updateConsultSection(ContentOperationDate.DataBean data) {

    }

    @Override
    public void updateMessageNum(MessageUnReadData.DataBean data) {

    }
}
