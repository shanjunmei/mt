package com.lanhun.framework.utils.page;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lanhun.framework.controller.vo.CompareType;
import com.lanhun.framework.controller.vo.ItemDataType;
import com.lanhun.framework.controller.vo.QueryItem;
import com.lanhun.framework.orm.FilterItem;
import com.lanhun.framework.utils.DateUtils;

@SuppressWarnings({"rawtypes","unchecked"})
public class Query2FilterUtils {
	private final static Logger logger=LoggerFactory.getLogger(Query2FilterUtils.class);
	public static final  FilterItem getObject2FilterItem(QueryItem item){
		return getObject2FilterItem(item,false);
}
	/**
	 * 
	 * @author michael
	 * @date: 2013年10月10日
	 * @param item
	 * @param date2Next true在日期做小于或小于等于是将日期加1天并设为0点0分
	 * @return 
	 * @exception 
	 * @description:
	 */
	
	public static final  FilterItem getObject2FilterItem(QueryItem item,boolean date2Next){
		if(ItemDataType.String.equals(item.getType()) ){
			if(item.getValue()==null){
				return null;
			}
			if(item.getValue() instanceof String && StringUtils.isEmpty((String)item.getValue())){
					return null;
			}else if(item.getValue() instanceof  Collection && ((Collection)item.getValue()).size()==0 ){
				return null;
			}
			if(CompareType.like.equals(item.getCompareType())){
				return new FilterItem(item.getName(), "%"+item.getValue().toString()+"%",CompareType.like);
			}else if(CompareType.left_like.equals(item.getCompareType())){
				return new FilterItem(item.getName(), item.getValue().toString()+"%",CompareType.like);
			}else if(CompareType.right_like.equals(item.getCompareType())){
				return new FilterItem(item.getName(), "%"+item.getValue().toString(),CompareType.like);
			}else if(CompareType.eq.equals(item.getCompareType())){
				return new FilterItem(item.getName(), item.getValue().toString());
			}else if(CompareType.ne.equals(item.getCompareType())){
				return new FilterItem(item.getName(), item.getValue().toString(),CompareType.ne);
			}else if(CompareType.in.equals(item.getCompareType())){
				return new FilterItem(item.getName(), item.getValue().toString(),CompareType.in);
			}else if(CompareType.notin.equals(item.getCompareType())){
				return new FilterItem(item.getName(), item.getValue().toString(),CompareType.notin);
			}
		}else if(ItemDataType.Date.equals(item.getType()) && item.getValue()!=null&&item.getValue().toString().trim().length()>0){
			//item.setValue(DateUtils.parse(item.getValue()));
			if(CompareType.eq.equals(item.getCompareType())){
				return new FilterItem(item.getName(), DateUtils.parse(item.getValue()));
			}else if(CompareType.ne.equals(item.getCompareType())){
				return new FilterItem(item.getName(), DateUtils.parse(item.getValue()),CompareType.ne);
			}else if(CompareType.gt.equals(item.getCompareType())){
				return new FilterItem(item.getName(), DateUtils.parse(item.getValue()),CompareType.gt);
			}else if(CompareType.ge.equals(item.getCompareType())){
				return new FilterItem(item.getName(), DateUtils.parse(item.getValue()),CompareType.ge);
			}else if(CompareType.lt.equals(item.getCompareType())){
				if(date2Next){
					return new FilterItem(item.getName(), getNextDate(DateUtils.parse(item.getValue())),CompareType.lt);
				}else{
					return new FilterItem(item.getName(), DateUtils.parse(item.getValue()),CompareType.lt);
				}
			}else if(CompareType.le.equals(item.getCompareType())){
				if(date2Next){
					return new FilterItem(item.getName(), getNextDate(DateUtils.parse(item.getValue())),CompareType.lt);
				}else{
					return new FilterItem(item.getName(), DateUtils.parse(item.getValue()),CompareType.le);
				}
			}
		}else if(ItemDataType.Enum.equals(item.getType()) &&item.getValue()!=null){
			if(item.getEnumClass()!=null){
				try{
					Object v=Enum.valueOf(item.getEnumClass(),(String)item.getValue());
					return new FilterItem(item.getName(), v);
				}catch(Exception e){
					logger.debug(e.getMessage());
				}
			}
		}else if(ItemDataType.Boolean.equals(item.getType())){
			if(item.getDisplay().equals("true")){
				item.setValue(true);
			}
			return new FilterItem(item.getName(), item.getValue());
		}else if(ItemDataType.Number.equals(item.getType())){
			if(item.getValue()==null||StringUtils.isBlank(item.getValue().toString())){
				return null;
			}
			return new FilterItem(item.getName(), Integer.valueOf(item.getValue().toString()));
		}
		return null;
	}
	
	private static  Object getNextDate(Object val){
		if(val instanceof Date){
			return DateUtils.getNextDay(DateUtils.getDayBegin((Date)val) );
		}
		return val;
		
	}
	
}
