package com.lanhun.framework.orm.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.lanhun.framework.utils.em.Status;

@MappedSuperclass
public abstract class BaseEntity extends BaseCoreEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;



	@Column(name = "FNumber",length=80)
	private String number;

	@Column(name = "FName",length=80)
	private String name;
	
	@Column(name="FEnabled",length=50)
	@Enumerated(EnumType.STRING)
	private Status enabled;

	@Column(name = "FCreatedTime")
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@Version
	@Column(name = "FLastModifyTime")
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastModifyTime;
	
	@JoinColumn(name="FCreator")
	@OneToOne()
	@Fetch(FetchMode.JOIN)
	private User creator;
	
	@JoinColumn(name="FLastModifier")
	@OneToOne()
	@Fetch(FetchMode.JOIN)
	private User lastModifier;



	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public Status getEnabled() {
		return enabled;
	}

	public void setEnabled(Status enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}
	

}
