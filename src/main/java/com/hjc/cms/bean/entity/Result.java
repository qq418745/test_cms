package com.hjc.cms.bean.entity;

import java.io.Serializable;

/**
 * hjc_cms
 * info：用于向页面传递信息的类
 * Mr.liuchengming
 * 2020-01-03 10:35
 **/

public class Result implements Serializable{
	
	private boolean success;
	private boolean flag;
	private String message;
	private Object info;

	public Object getInfo() {
		return info;
	}

	public Result setInfo(Object info) {
		this.info = info;
		return this;
	}



	public Result(boolean success, String message) {
		super();
		this.success=success;
		this.flag = success;
		this.message = message;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
