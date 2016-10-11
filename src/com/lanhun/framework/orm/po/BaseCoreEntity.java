package com.lanhun.framework.orm.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.lanhun.framework.utils.em.Status;

@MappedSuperclass
public abstract class BaseCoreEntity implements Serializable {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FID",unique=true,length=44)
	@GenericGenerator(name="systemUUID",strategy="org.hibernate.id.UUIDGenerator")
	@GeneratedValue(generator="systemUUID")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
