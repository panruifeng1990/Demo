package com.pan.hjms.mvp.base;

import com.pan.hjms.adapter.entity.ContentOperationDate;
import com.pan.hjms.adapter.entity.GridViewIndex;
import com.pan.hjms.adapter.entity.HomeBanner;
import com.pan.hjms.adapter.entity.MessageUnReadData;
import com.pan.hjms.adapter.entity.SellBuilding;

import java.util.List;

/**
 * package: com.easyandroid.sectionadapter.mvp.base.Module
 * author: gyc
 * description:
 * time: create at 2017/7/8 9:51
 */

public class Module {

    public interface View extends BaseView{
        void updateSellBuilding(int type, List<SellBuilding.DataBean.BannerBean> datas);
        void updateBanner(List<HomeBanner.DataBean.AdsBean> datas);
        void updateGrid(List<GridViewIndex> datas);
        void updateConsultSection(ContentOperationDate.DataBean data);
        void updateMessageNum(MessageUnReadData.DataBean data);
    }

    public interface Presenter extends BasePresenter{
        void loadData(int loadType);
    }
}
