package com.lanhun.framework.utils.em;

public enum ExceptionType implements EnumCode<ExceptionType> {
	SQLException("sql异常",1),
	ServiceException("自定义异常",2);

	private String display;
	private int value;
	private ExceptionType(String display,int value){
		this.display=display;
		this.value=value;
	}
	
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
