package com.pan.hjms.adapter.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 首页广告
 * @author shiqiang
 *
 */
public class HomeBanner extends BaseResult {

	/**
	 * success : true
	 * msg :
	 * code : 0
	 * page : null
	 * data : {"ads":[{"id":581,"areaId":17,"estateId":null,"sequence":1,"imgUrl":"http://img.51moshou.com/images/advert/2017/05/23/5923f3f7d630d.jpeg","redirectUrl":"https://join.diandianjia.com/page/63","type":"HOMEPAGE","creator":40250,"createTime":"2017-05-23 16:34:02","updater":40250,"updateTime":"2017-05-23 16:34:02","delFlag":"0","description":null},{"id":361,"areaId":17,"estateId":null,"sequence":2,"imgUrl":"http://img.51moshou.com/images/advert/2017/03/29/58db21a7e5b8e.jpeg","redirectUrl":"http://apipub.51moshou.com/ask/question/index?askid=4","type":"HOMEPAGE","creator":40250,"createTime":"2016-10-10 21:09:51","updater":39852,"updateTime":"2017-03-29 11:01:15","delFlag":"0","description":null},{"id":400,"areaId":17,"estateId":null,"sequence":3,"imgUrl":"http://img.51moshou.com/images/advert/2017/01/19/5880222e2a20e.jpeg","redirectUrl":"http://u.liveapp.cn/1232629","type":"HOMEPAGE","creator":39852,"createTime":"2016-11-02 15:45:54","updater":40250,"updateTime":"2017-01-19 10:19:59","delFlag":"0","description":null},{"id":501,"areaId":17,"estateId":null,"sequence":3333,"imgUrl":"http://img.51moshou.com/images/advert/2017/05/05/590bf110156dc.jpeg","redirectUrl":"http://apipub.51moshou.com/ask/question/index?askid=5","type":"HOMEPAGE","creator":39852,"createTime":"2017-03-23 18:00:26","updater":39852,"updateTime":"2017-05-09 15:52:20","delFlag":"0","description":null}]}
	 */
	private DataBean data;


	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		private List<AdsBean> ads;

		public List<AdsBean> getAds() {
			return ads;
		}

		public void setAds(List<AdsBean> ads) {
			this.ads = ads;
		}

		public static class AdsBean {
			/**
			 * id : 581
			 * areaId : 17
			 * estateId : null
			 * sequence : 1
			 * imgUrl : http://img.51moshou.com/images/advert/2017/05/23/5923f3f7d630d.jpeg
			 * redirectUrl : https://join.diandianjia.com/page/63
			 * type : HOMEPAGE
			 * creator : 40250
			 * createTime : 2017-05-23 16:34:02
			 * updater : 40250
			 * updateTime : 2017-05-23 16:34:02
			 * delFlag : 0
			 * description : null
			 */

			private int id;
			private int areaId;
			private String estateId;
			private int sequence;
			private String imgUrl;
			private String redirectUrl;
			private String type;
			private int creator;
			private String createTime;
			private int updater;
			private String updateTime;
			private String delFlag;
			private String description;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getAreaId() {
				return areaId;
			}

			public void setAreaId(int areaId) {
				this.areaId = areaId;
			}

			public String getEstateId() {
				return estateId;
			}

			public void setEstateId(String estateId) {
				this.estateId = estateId;
			}

			public int getSequence() {
				return sequence;
			}

			public void setSequence(int sequence) {
				this.sequence = sequence;
			}

			public String getImgUrl() {
				return imgUrl;
			}

			public void setImgUrl(String imgUrl) {
				this.imgUrl = imgUrl;
			}

			public String getRedirectUrl() {
				return redirectUrl;
			}

			public void setRedirectUrl(String redirectUrl) {
				this.redirectUrl = redirectUrl;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public int getCreator() {
				return creator;
			}

			public void setCreator(int creator) {
				this.creator = creator;
			}

			public String getCreateTime() {
				return createTime;
			}

			public void setCreateTime(String createTime) {
				this.createTime = createTime;
			}

			public int getUpdater() {
				return updater;
			}

			public void setUpdater(int updater) {
				this.updater = updater;
			}

			public String getUpdateTime() {
				return updateTime;
			}

			public void setUpdateTime(String updateTime) {
				this.updateTime = updateTime;
			}

			public String getDelFlag() {
				return delFlag;
			}

			public void setDelFlag(String delFlag) {
				this.delFlag = delFlag;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}
		}
	}
}
