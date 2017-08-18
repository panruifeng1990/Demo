package com.pan.hjms.adapter.entity;

import java.io.Serializable;

public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 请求页数，从1开始
	 */
	private int pageNo;
	/**
	 * 每页条数，默认10
	 */
	private int pageSize;
	/**
	 * 数据总条数
	 */
	private int totalCount;
	/**
	 * 总页数
	 */
	private int pageCount;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	//判断当前列表是否有下一页
	public int hasNextPage(){
		if((pageCount-pageNo)>0){
			return 1;
		}
		return 0;
		
	}
	

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", pageCount=" + pageCount
				+ "]";
	}

}
