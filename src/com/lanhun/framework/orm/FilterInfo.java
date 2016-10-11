package com.lanhun.framework.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lanhun.framework.controller.vo.CompareType;

public class FilterInfo implements Cloneable, Serializable {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PARSER_KEY = "#";
	
	private List<FilterItem> items;
	
	private String mask;

	public List<FilterItem> getItems() {
		return items;
	}

	public void setItems(List<FilterItem> items) {
		this.items = items;
	}

	
	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public FilterInfo() {
		items = new ArrayList<FilterItem>();
	}

	public void addItem(FilterItem item) {
		items.add(item);
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public void addAll(Collection<FilterItem> items) {
		this.items.addAll(items);
	}

	public void clear() {
		items.clear();
	}

	public void removeAll(Collection<FilterItem> items) {
		this.items.removeAll(items);
	}

	public String getHQL() {

		StringBuffer sb = new StringBuffer();

		if(mask==null||mask.trim().isEmpty()){
			if (items != null && items.size() > 0) {
				int len = items.size();
				for (int i = 0; i < len; i++) {
					sb.append(getFilterVal(items.get(i), i + 1)).append(" and ");
				}
				sb.setLength(sb.length() - 4);
				return sb.toString();
			}
		}else{
			String  masks = mask;
    		String[] arg = masks.split(PARSER_KEY);
    		int maskLength = arg.length-1;
    		if(items.size()!=maskLength){
    			throw new IndexOutOfBoundsException("过滤项与过滤表达式不匹配"+mask +" 过滤项:"+items.size());
    		}
    		for(int i=maskLength;i>0;i--){
    			masks = masks.replace(PARSER_KEY+(i-1), getFilterVal(items.get(i-1), i));
    		}
    		
    		//System.out.print(masks);//
    		return masks;
		}
		return "";
	}

	public Map<String, Object> getVals() {
		Map<String, Object> vals = new HashMap<String, Object>();

		if (items != null && items.size() > 0) {
			int len = items.size();
			for (int i = 0; i < len; i++) {
				if (items.get(i).getVal() != null) {
					if (!items.get(i).isSourceType()) {
						vals.put("val" + (i + 1), items.get(i).getVal());
					}

				}
				// revMap.put("val"+(i+1), filterItems.get(i).getVal());
			}
		}
		return vals;
	}

	private String getFilterVal(FilterItem filterItem, int index) {
		StringBuffer sb = new StringBuffer();
		if (filterItem.getVal() instanceof Collection) {
			sb.append(filterItem.getProperty()).append(" ")
					.append(filterItem.getCompareType().getSql()).append(" ")
					.append("(:val" + index).append(")  ");
		} else {
				if (filterItem.isSourceType()) {
					sb.append(filterItem.getProperty());//.append(" ").append(filterItem.getCompareType().getSql()).append(filterItem.getVal())

				} else {
					if (filterItem.getVal() == null) {
						sb.append(filterItem.getProperty()).append(" ")
								.append(filterItem.getCompareType().getSql())
								.append(" null ");
					}else{
						sb.append(filterItem.getProperty()).append(" ")
								.append(filterItem.getCompareType().getSql())
								.append(" :val" + index);
					}
				}

		}

		return sb.toString();

	}
	public static void main(String[] args) {
		FilterInfo filter=new FilterInfo();
		filter.addItem(new FilterItem("name", "jax"));
		filter.addItem(new FilterItem("number", "xxd"));
		filter.addItem(new FilterItem("createTime", "2014-10-30",CompareType.le));
		filter.addItem(new FilterItem("createTime", "2014-10-03",CompareType.ge));
		filter.addItem(new FilterItem("createTime is not null ", true));
		System.out.println(filter.getHQL());
		System.out.println(filter.getVals());
	}
}
