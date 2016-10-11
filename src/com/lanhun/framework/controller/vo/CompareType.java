package com.lanhun.framework.controller.vo;

import com.lanhun.framework.utils.em.EnumCode;

public enum CompareType implements EnumCode<CompareType>{
	eq("等于","=",1),
	ne("不等于","<>",2),
	gt("大于",">",3),
	ge("大于等于",">=",4),
	lt("小于","<",5),
	le("小于等于","<=",6),
	in("在里面","in",7),
	notin("不在里面","not in",8),
	right_like("like","like",9),
	left_like("like","like",10),
	like("like","like",11);

	private CompareType(String display,String sql,int value){
		this.display=display;
		this.sql=sql;
		this.value=value;
	}
	private String display;
	private String sql;
	private int value;
	
	@Override
	public String getDisplay() {
		
		return display;
	}

	@Override
	public String getName() {
		return name();
	}
	public String getSql(){
		return sql;
	}

	@Override
	public int getValue() {
		return value;
	}
	
}
