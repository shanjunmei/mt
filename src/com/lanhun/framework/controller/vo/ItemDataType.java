package com.lanhun.framework.controller.vo;

public enum ItemDataType {
	String("字符"), Date("日期"), Number("数字"), Boolean("布尔"), Enum("枚举");

	private String type;

	private ItemDataType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
