package com.pan.hjms.adapter.entity;

import java.io.Serializable;

/**
 * 首页-GridView实体类
 * 
 * @author shiqiang {@link qiang_shi@bacic5i5j.com}
 * 
 * @Date 2015-06-17
 * @version
 * 
 */
public class GridViewIndex implements Serializable {
	private static final long serialVersionUID = 8714360240911797578L;
	/**
	 * 照片id
	 */
	private int imageId;
	/**
	 * 照片名称
	 */
	private String imageName;

	public GridViewIndex(int imageId, String imageName) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
	}

	public GridViewIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "GridViewIndex [imageId=" + imageId + ", imageName=" + imageName
				+ "]";
	}

}
