package com.lanhun.framework.controller.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.lanhun.framework.utils.em.EnumCode;
@SuppressWarnings("rawtypes")
public class QueryItem implements Serializable{

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Object value;
	private String display;
	private ItemDataType type;
	private CompareType compareType;
	private Class<?> enumClass;
	private Map<?,?> enumRanges;
	
	
	/**
	 * 默认空构造函数-必须有，以供反射初始化使用
	 */
	public QueryItem(){
		
	}
	
	public QueryItem(String name,Object value,String display){
		this(name, value, display, ItemDataType.String);
	}
	public QueryItem(String name,Object value,String display,CompareType compareType){
		this(name, value, display, ItemDataType.String,compareType);
	}
	
	public QueryItem(String name,Object value,String display,ItemDataType type){
		this(name, value, display, type, CompareType.eq);
		
	}
	public QueryItem(String name,Object value,String display,Class<?> enumClass){
		this(name,value,display,enumClass,false);
		
	}
	public QueryItem(String name,Object value,String display,Class<?> enumClass,boolean isRequired){
		this(name, value, display, ItemDataType.Enum, CompareType.eq);
		this.enumClass=enumClass;
		if (enumClass != null && enumClass.isEnum()) {
			if (EnumCode.class.isAssignableFrom(enumClass)) {
				EnumCode[] obs=	(EnumCode[])enumClass.getEnumConstants();
				if(obs!=null){
					Map<String,String> enumRanges=new LinkedHashMap<String,String>();
					if(!isRequired){
						enumRanges.put("", "------");
					}
					for (EnumCode e : obs) {
						enumRanges.put(e.getName(), e.getDisplay());
					}
					this.enumRanges=enumRanges;
				}
			}
		}
		
	}
	public QueryItem(String name,Object value,String display,Class<?> enumClass,Map<?,?> enumRanges){
		this(name, value, display, ItemDataType.Enum, CompareType.eq, enumClass, enumRanges);
	}
	public QueryItem(String name,Object value,String display,CompareType compareType,Class<?> enumClass,Map<?,?> enumRanges){
		this(name, value, display, ItemDataType.Enum, compareType, enumClass, enumRanges);
	}

	public QueryItem(String name,Object value,String display,ItemDataType type,CompareType compareType){
		this.name=name;
		this.value=value;
		this.display=display;
		this.type=type;
		this.compareType=compareType;
	}
	public QueryItem(String name,Object value,String display,ItemDataType type,CompareType compareType,Class<?> enumClass,Map<?,?> enumRanges){
		this.name=name;
		this.value=value;
		this.display=display;
		this.type=type;
		this.compareType=compareType;
		this.enumClass=enumClass;
		this.enumRanges=enumRanges;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public String getDisplay() {
		return display;
	}

	public ItemDataType getType() {
		return type;
	}

	public CompareType getCompareType() {
		return compareType;
	}

	
	public Class getEnumClass() {
		return enumClass;
	}

	public Map<?, ?> getEnumRanges() {
		return enumRanges;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(ItemDataType type) {
		this.type = type;
	}

	public void setCompareType(CompareType compareType) {
		this.compareType = compareType;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setEnumClass(Class<?> enumClass) {
		this.enumClass = enumClass;
	}

	public void setEnumRanges(Map<?, ?> enumRanges) {
		this.enumRanges = enumRanges;
	}

	
}
