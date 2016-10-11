package com.lanhun.framework.utils.annotation;

import com.lanhun.framework.utils.em.EnumCode;

public enum PermissionType implements EnumCode<PermissionType> {
	REQUIRED("必须", 1),
	NONE("无", 2), 
	OPTIONAL("可选", 3)
	;
	private String display;
	private int value;

	private PermissionType(String display, int value) {
		this.display = display;
		this.value = value;
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
