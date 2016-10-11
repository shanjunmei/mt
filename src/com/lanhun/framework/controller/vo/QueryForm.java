package com.lanhun.framework.controller.vo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.lanhun.framework.utils.page.Pager;

public class QueryForm implements Serializable{
	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	private List<QueryItem> items;
	private Pager pager;

	public List<QueryItem> getItems() {
		return items;
	}

	public void setItems(List<QueryItem> items) {
		this.items = items;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public void removeItem(String name){
		Iterator<QueryItem> it=items.iterator();
		while(it.hasNext()){
			QueryItem item=it.next();
			if(name.equals(item.getName())){
				it.remove();
			}
		}
	}
	public void removeItems(String... names){
		Iterator<QueryItem> it=items.iterator();
		while(it.hasNext()){
			QueryItem item=it.next();
			for (String name : names) {
				if(name.equals(item.getName())){
					it.remove();
				}
			}
			
		}
	}
			

}
