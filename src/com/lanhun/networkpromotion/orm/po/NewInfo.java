package com.lanhun.networkpromotion.orm.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lanhun.framework.orm.po.BaseEntity;

@Entity
@Table(name = "t_new_info")
public class NewInfo extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	// 标题
	@Column(name = "FTitle")
	private String title;

	// 图片
	@Column(name = "FImage")
	private String image;

	// 摘要
	@Column(name = "FSummary")
	private String summary;

	// 资讯分类
	@JoinColumn(name = "FCategory")
	@OneToOne()
	private NewCategory category;

	// 正文
	@Column(name = "FContent")
	//@Lob
	private String content;

	// 信息来源
	@Column(name = "FSource")
	private String source;

	// 发布者
	@Column(name = "FPublisher")
	private String publisher;

	// 浏览量
	@Column(name = "FBorrowCount")
	private Integer borrowCount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public NewCategory getCategory() {
		return category;
	}

	public void setCategory(NewCategory category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getBorrowCount() {
		return borrowCount;
	}

	public void setBorrowCount(Integer borrowCount) {
		this.borrowCount = borrowCount;
	}

}
