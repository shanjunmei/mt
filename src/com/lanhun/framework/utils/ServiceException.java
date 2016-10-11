package com.lanhun.framework.utils;

public class ServiceException extends RuntimeException{

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	
	public String getCode() {
		return code;
	}

	public ServiceException(String msg){
		super(msg);
	}
	
	public ServiceException(String msg,Throwable e){
		super(msg,e);
	}
	public ServiceException(String code,String msg){
		super(msg);
		this.code=code;
	}
	public ServiceException(String code,String msg,Throwable e){
		super(msg,e);
		this.code=code;
	}
}
