package com.lanhun.networkpromotion.utils.em;

import com.lanhun.framework.utils.em.EnumCode;

public enum RepayType implements EnumCode<RepayType>{
	;

	
	private RepayType(String display,int value){
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
