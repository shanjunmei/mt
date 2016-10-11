package com.lanhun.framework.utils.em;

public enum RequestSuffixType implements EnumCode<RequestSuffixType>{
	iv("iv(json)",1);

	private RequestSuffixType(String  display,int value){
		this.display=display;
		this.value=value;
	}
	private String display;
	private int value;
	@Override
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
