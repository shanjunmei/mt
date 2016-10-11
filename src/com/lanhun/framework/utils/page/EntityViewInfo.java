package com.lanhun.framework.utils.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.lanhun.framework.controller.vo.CompareType;
import com.lanhun.framework.orm.FilterInfo;
import com.lanhun.framework.orm.FilterItem;

public class EntityViewInfo  implements Cloneable, Serializable {
		/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 3704547738829752322L;
	
		private FilterInfo filter;
		private List<SorterItem> sorts;
		private List<String> selector;
		private int rowCount;
		private String entityClassName;
		private int first;
		private int pageSize=Integer.MAX_VALUE;
		//private boolean appendSelectors;
		
		public void addFitlerItem(FilterItem filterItem){
			if(this.filter==null){
				this.filter = new FilterInfo();
			}
			if(filterItem!=null){
				this.filter.addItem(filterItem);
			}
			
		}
		
		public void addFitlerItems(List<FilterItem> filters){
			if(filter==null){
				filter = new FilterInfo();
			}
			if(filters!=null && filters.size()>0){
				filter.addAll(filters);
			}
		}
		
		  public EntityViewInfo()
		  {
		    //this.topCount = 0;
			  this.first=0;
		    filter = new FilterInfo();
		    sorts = new ArrayList<SorterItem>(2);
		    selector = new ArrayList<String>();
		   // this.appendSelectors = false;
		  }
		  
		  
		  
		  
		
		/*  public int getTopCount() {
			return topCount;
		}

		public void setTopCount(int topCount) {
			this.topCount = topCount;
		}*/

		public String getEntityClassName() {
			return entityClassName;
		}

		public void setEntityClassName(String entityClassName) {
			this.entityClassName = entityClassName;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}

		public List<String> getSelector() {
			return selector;
		}

		public void setSelector(List<String> selector) {
			this.selector = selector;
		}

		public FilterInfo getFilter() {
			return filter;
		}

		public void setFilter(FilterInfo filter) {
			this.filter = filter;
		}

		public List<SorterItem> getSorts() {
			return sorts;
		}

		public void setSorts(List<SorterItem> sorts) {
			this.sorts = sorts;
		}
		
		
		public int getRowCount() {
			return rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public String getHQL()
		  {
			StringBuilder buff=new StringBuilder();
		    List<String> selectItemCol = getSelector();
		    FilterInfo filter = getFilter();
		    List<SorterItem> sorterItemCol = getSorts();

		    boolean flag = false;
		    if (selectItemCol.size() > 0)
		    {
		      buff.append("SELECT ");
		      boolean selectFlag = false;
		      for (int i = 0; i < selectItemCol.size(); ++i)
		      {
		        String selectItem = selectItemCol.get(i);
		        if (StringUtils.isEmpty(selectItem))
		        {
		          continue;
		        }


		        if (selectFlag)
		        {
		          buff.append(", ");
		        }
		        buff.append(selectItem);
		        selectFlag = true;
		      }

		      flag = true;
		    }

		    if(this.entityClassName!=null){
		    	buff.append(" from ").append(this.entityClassName).append(" ");
		    }
		    
		    
		    if ((filter != null) && (filter.getItems().size() != 0))
		    {
		      if (flag)
		      {
		        buff.append(" WHERE ");
		      }
		      else {
		        buff.append("WHERE ");
		        flag = true;
		      }
		      buff.append(filter.getHQL());
		    }

		    if (sorterItemCol.size() <= 0)
		      return buff.toString();
		    if (flag)
		    {
		      buff.append(" ORDER BY ");
		    }
		    else {
		      buff.append("ORDER BY ");
		    }

		    for (int i = 0; i < sorterItemCol.size(); ++i)
		    {
		      if (i != 0)
		      {
		        buff.append(", ");
		      }
		      buff.append(sorterItemCol.get(i).toHQL());
		    }
		    return buff.toString();
		  }

		
		public static void main(String[] args){
			EntityViewInfo view= new EntityViewInfo();
			FilterInfo  filter = new FilterInfo();
			filter.addItem(new FilterItem("id", "-1"));
			filter.addItem(new FilterItem("createTime is not null", true));
			filter.addItem(new FilterItem("number", "aa%",CompareType.like));
			filter.addItem(new FilterItem("lastModifyTime",new Date()));
			//filter.setMaskString("#0 and (#2 or #1)");
		//	FilterInfo  filter2 = new FilterInfo();
			filter.addItem(new FilterItem("name", "nnnn",CompareType.ne));
			filter.addItem(new FilterItem("number2", "aa"));
			
			view.selector.add("name");
			view.selector.add("number");
			view.entityClassName="User";
			//filter2.setMaskString("#1 or #0");
		/*	try {
				filter.mergeFilter(filter2, "and");
			} catch (InvalidCodeException e) {
				e.printStackTrace();
			}*/
			view.setFilter(filter);
		/**	view.getFilter().add(new FilterItem("id", "-1"));
			view.getFilter().add(new FilterItem("number", "aa%",CompareTypeEnum.LIKE));
			view.getFilter().add(new FilterItem("1","1",CompareTypeEnum.EQUALS));
			view.getFilter().add(new FilterItem("id", "-1"));*/
			String sb = view.getHQL();
			System.out.println(sb);
			System.out.println(view.getFilter().getVals());
			
		}
}