package com.lanhun.framework.orm;

import com.lanhun.framework.controller.vo.CompareType;

public class FilterItem {
	
	private String property;
	private Object val;
	private CompareType compareType;
	private boolean sourceType;

	/**
	
	 * @param property  属性
	 * @param sourceType 原生sql
	 */
	public FilterItem(String property,boolean sourceType){
		this.property=property;
		this.sourceType=sourceType;
	}
	
	/**
	 * @param property 属性名
	 * @param val 属性值
	 */
	public FilterItem(String property,Object val){
		this(property, val, CompareType.eq);
	}
	
	/**
	 * @param property 属性名
	 * @param val 属性值
	 * @param compareType  比较类型
	 */
	public FilterItem(String property,Object val,CompareType compareType){
		this(property, val, compareType, false);
	}
	/**
	 * @param property
	 * @param val
	 * @param compareType 
	 * @param sourceType
	 */
	public FilterItem(String property,Object val,CompareType compareType,boolean sourceType){
		this.property=property;
		this.val=val;
		this.compareType=compareType;
		this.sourceType=sourceType;
	}
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}

	public CompareType getCompareType() {
		return compareType;
	}

	public void setCompareType(CompareType compareType) {
		this.compareType = compareType;
	}

	public boolean isSourceType() {
		return sourceType;
	}

	public void setSourceType(boolean sourceType) {
		this.sourceType = sourceType;
	}

}
