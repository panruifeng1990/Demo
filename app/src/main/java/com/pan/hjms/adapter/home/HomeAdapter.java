package com.pan.hjms.adapter.home;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.easytools.tools.DisplayUtil;
import com.pan.hjms.R;
import com.pan.hjms.adapter.SectionedRecyclerViewAdapter;
import com.pan.hjms.adapter.entity.SellBuilding;
import com.pan.hjms.holder.home.FooterHolder;
import com.pan.hjms.holder.home.TestSectionBodyHolder;
import com.pan.hjms.holder.home.TestSectionFooterHolder;
import com.pan.hjms.holder.home.TestSectionHeaderHolder;
import com.pan.hjms.util.ListUtil;

import java.util.List;


/**
 * package: com.easyandroid.sectionadapter.HomeAdapter
 * author: gyc
 * description:
 * time: create at 2017/7/8 2:59
 */

public class HomeAdapter extends SectionedRecyclerViewAdapter<RecyclerView.ViewHolder,
        TestSectionHeaderHolder, TestSectionBodyHolder,
        TestSectionFooterHolder, FooterHolder> {
    private List<SellBuilding.DataBean.BannerBean> mDatas;
    private Context mContext;
    private LayoutInflater mInflater;

    public HomeAdapter(List<SellBuilding.DataBean.BannerBean> mDatas, Context mContext) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<SellBuilding.DataBean.BannerBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    public List<SellBuilding.DataBean.BannerBean> getData() {
        return mDatas;
    }

    public void addMoreData(List<SellBuilding.DataBean.BannerBean> newDatas) {
        mDatas.addAll(newDatas);
        notifyDataSetChanged();
    }

    @Override
    protected boolean hasHeader() {
        return false;
    }

    @Override
    protected int getSectionCount() {
        return ListUtil.isEmpty(mDatas) ? 0 : mDatas.size();
    }

    @Override
    protected int getItemCountForSection(int section) {
//        return ListUtil.isEmpty(mDatas.get(section).getEPicture()) ? 0 : mDatas.get(section)
//                .getEPicture().size();
        return 0;

    }

    @Override
    protected boolean hasFooterInSection(int section) {
        return true;
    }

    @Override
    protected TestSectionHeaderHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int
            viewType) {
//        return new TestSectionHeaderHolder(mInflater.inflate(R.layout
//                .item_section_header, parent, false));
        return null;
    }


    @Override
    protected TestSectionFooterHolder onCreateSectionFooterViewHolder(ViewGroup parent, int
            viewType) {
//        return new TestSectionFooterHolder(mInflater.inflate(R.layout
//                .item_section_footer, parent, false));
        return null;

    }

    @Override
    protected TestSectionBodyHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
//        return new TestSectionBodyHolder(mInflater.inflate(R.layout.item_section_body,
//                parent, false));
        return null;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected FooterHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
//        return new FooterHolder(mInflater.inflate(R.layout.layout_footer, parent, false));
        return null;
    }


    @Override
    protected void onBindSectionHeaderViewHolder(TestSectionHeaderHolder holder, int section) {
//        Glide.with(mContext).load(mDatas.get(section).getPicture()).into(holder.imgHead);
//        holder.tvNike.setText(mDatas.get(section).getUserName());
//        holder.tvDate.setText(mDatas.get(section).getTime());
//        holder.tvEvaluate.setText(mDatas.get(section).getContent());
    }

    @Override
    protected void onBindItemViewHolder(TestSectionBodyHolder holder, int section, int position) {
//        int screenWidth = DisplayUtil.getScreenWidthPixels((Activity) mContext);
//        int imgWidth = (screenWidth - DisplayUtil.dp2px(mContext, 55 + 30)) / 3;
//        ViewGroup.MarginLayoutParams params = null;
//        if (holder.llRoot.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
//            params = (ViewGroup.MarginLayoutParams) holder.llRoot.getLayoutParams();
//        } else {
//            params = new ViewGroup.MarginLayoutParams(holder.llRoot.getLayoutParams());
//        }
//        params.width = imgWidth;
//        params.height = imgWidth;
//
//        //这里左右边距不相同，左边距与评论文字相同，加上头像的大小，为55dp，左边距为55dp，右边距为10dp，图片间距为10dp
//        if (position % 3 == 0) {
//            params.leftMargin = DisplayUtil.dp2px(mContext, 55);
//        } else if (position % 3 == 1) {
//            params.leftMargin = DisplayUtil.dp2px(mContext, 35);
//        } else {
//            params.leftMargin = DisplayUtil.dp2px(mContext, 14);
//        }
//        params.bottomMargin = DisplayUtil.dp2px(mContext, 8);
//        holder.llRoot.setLayoutParams(params);
//        Glide.with(mContext).load(mDatas.get(section).getEPicture().get(position)).into(holder
//                .imgEvaluate);
    }

    @Override
    protected void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected void onBindSectionFooterViewHolder(TestSectionFooterHolder holder, int section) {
//        holder.tvLookNum.setText(mContext.getString(R.string.item_section_footer, mDatas.get
//                (section).getBrowser()));
    }

    @Override
    protected void onBindFooterOtherViewHolder(FooterHolder holder) {

    }

}
