package com.lanhun.networkpromotion.orm.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lanhun.framework.orm.po.BaseEntity;

@Entity
@Table(name="t_platform_archives")
public class PlatformArchives extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	//logo
	@Column(name = "FLogUrl")
	private String logo;
	
	//平台上线时间
	@Column(name = "FOnlineTime")
	private String onlineTime;
	
	//法人代表
	@Column(name = "FLegalRepresentative")
	private String legalRepresentative;
	
	//注册地址
	@Column(name = "FRegistAddr")
	private String registAddr;
	
	//注册资本
	@Column(name = "FRegistCaptial")
	private String registCaptial;
	
	//发布时间
	@Column(name = "FPublishTime")
	private String publishTime;
	
	//发布人
	@Column(name = "FPublisher")
	private String publisher;
	
	//查看次数（浏览量）
	@Column(name = "FBorrowCount")
	private Integer borrowCount;
	
	//正文
	@Column(name = "FContent")
//	@Lob
	private String content;
	
	//平台简介
	@Column(name = "FPlantformIntroduction")
	private String plantformIntroduction;

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getRegistAddr() {
		return registAddr;
	}

	public void setRegistAddr(String registAddr) {
		this.registAddr = registAddr;
	}

	public String getRegistCaptial() {
		return registCaptial;
	}

	public void setRegistCaptial(String registCaptial) {
		this.registCaptial = registCaptial;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlantformIntroduction() {
		return plantformIntroduction;
	}

	public void setPlantformIntroduction(String plantformIntroduction) {
		this.plantformIntroduction = plantformIntroduction;
	}
	
	
}
