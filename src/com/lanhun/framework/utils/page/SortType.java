package com.lanhun.framework.utils.page;

import com.lanhun.framework.utils.em.EnumCode;

public enum SortType implements EnumCode<SortType> {
	ASCEND(1,"ASC",1),
	DESCEND(2,"DESC",2);

	private int index;
	private String display;
	private int value;
	
	private SortType(int index,String display,int value){
		this.index =index;
		this.display =display;
		this.value=value;
	}
	
	public int getIndex(){
		return index;
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