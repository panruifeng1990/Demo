package com.pan.hjms.adapter.entity;

import java.io.Serializable;

/** 
 *	未读消息数量
 */
public class MessageUnReadData implements Serializable{


	/**
	 * success : true
	 * msg : 未读消息数
	 * code : 0
	 * page : null
	 * data : {"unreadCnt":5}
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
		/**
		 * unreadCnt : 5
		 */

		private int unreadCnt;

		public int getUnreadCnt() {
			return unreadCnt;
		}

		public void setUnreadCnt(int unreadCnt) {
			this.unreadCnt = unreadCnt;
		}
	}
}
