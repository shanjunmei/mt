package com.lanhun.framework.utils.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage = 1; // 当前页号
	private int pageSize = 15; // 每一分页包含的记录数
	private int totalSize; // 总记录数
	private int totalPage; // 总分页数

	private boolean hasFirst; // 是否有第一页
	private boolean hasPrevious; // 是否有前页
	private boolean hasNext; // 是否有后一页
	private boolean hasLast; // 是否有最后一页

	private List<?> records = new ArrayList<Object>();
	
	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<?> records) {
		this.records = records;
	}

	/**
	 * Initialize Pager
	 * 
	 * @param totalRows
	 *            total record rows
	 * @param pageSize
	 *            total record is hold by every page
	 */
	public void init(int totalSize, int pageSize) {
		this.totalSize = totalSize;
		if (pageSize > 0) {
			this.pageSize = pageSize;
			this.totalPage = ((totalSize + pageSize) - 1) / pageSize;
		}
		currentPage = 1;
		refresh(); // 刷新当前页面信息
	}

	// 刷新当前页面信息
	public void refresh() {
		if (totalPage <= 1) {
			hasFirst = false;
			hasLast = false;
			hasPrevious = false;
			hasNext = false;
		} else if (currentPage == 1) {
			hasFirst = false;
			hasLast = true;
			hasPrevious = false;
			hasNext = true;
		} else if (currentPage == totalPage) {
			hasFirst = true;
			hasLast = false;
			hasPrevious = true;
			hasNext = false;
		} else {
			hasFirst = true;
			hasLast = true;
			hasPrevious = true;
			hasNext = true;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		refresh();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		refresh();
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isHasFirst() {
		return hasFirst;
	}

	public boolean isHasPrevious() {
		return hasPrevious;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public boolean isHasLast() {
		return hasLast;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
