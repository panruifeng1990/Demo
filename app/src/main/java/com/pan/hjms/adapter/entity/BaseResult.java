package com.pan.hjms.adapter.entity;

import java.io.Serializable;

/**
 * 
 * 接口通用字段父类，外层解析需继承
 * 
 * @author PengGuoHua {@link guohua_peng@bacic5i5j.com}
 * 
 * @Date 2015-05-20
 * @version
 */
public class BaseResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 685145794678572999L;
	/**
	 * 结果码 true成功，false失败
	 */
	public boolean success;
	/**
	 * 接口响应信息
	 */
	public String msg;
	/**
	 * 错误码 -1 通常提示性错误 -1000 用户没有登陆 -1001 用户不存在 -1002 用户账号或者密码错误 -1003 用户账号错误
	 * -1004 用户账号被锁定 -1005 用户没有被授权 -2000 客户端参数错误 -3000 服务器错误
	 */
	public int code;
	/**
	 * 如果没有为null
	 */
	public Page page;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
