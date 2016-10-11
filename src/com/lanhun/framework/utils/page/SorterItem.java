package com.lanhun.framework.utils.page;
public class SorterItem {
	  private String property;
	  private SortType sortType;
	  
	   public SorterItem(String name)
	   {
	    this(name, SortType.ASCEND);
	   }
	   public SorterItem(String name,SortType sortType)
	   {
		   this.property = name;
		   this.sortType = sortType;
	   }
	   
	   
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public SortType getSortType() {
		return sortType;
	}
	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}
	   
	public String toHQL(){
		return property+" "+sortType.getDisplay();
	}
	   
	   
}