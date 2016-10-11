package com.lanhun.framework.utils.em;

public enum Status implements EnumCode<Status>{
	E("启用",1),
	D("禁用",2);
	private String display;
	private int value;
	private Status(String display,int value){
		this.display=display;
		this.value=value;
	}
	public String getDisplay() {
		return display;
	}
	@Override
	public String getName() {
		return name();
	}
	@Override
	public int getValue() {
		return value;
	}
	

}
