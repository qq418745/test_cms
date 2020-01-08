package com.hjc.cms.bean.entity;

import java.io.Serializable;

/**
 * @program: hjc_cms
 * @description: 用于向页面传递信息的类
 * @author: Mr.liuchengming
 * @create: 2020-01-03 10:35
 **/

public class Result implements Serializable{
	
	private boolean success;
	private boolean flag;
	private String message;
	
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
