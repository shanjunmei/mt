package com.lanhun.framework.utils;

import com.lanhun.framework.utils.em.ExceptionType;

public class Exception {
	private ExceptionType type;
	private String code;
	private String message;
	private Throwable throwable;
	
	public Exception(){
		
	}
	public Exception(String code,String message){
		this(null, code, message);
	}
	public Exception(ExceptionType type,String code,String message){
		this.type=type;
		this.code=code;
		this.message=message;
	}
	
	public ExceptionType getType() {
		return type;
	}
	public void setType(ExceptionType type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	
}
