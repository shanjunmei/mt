package com.lanhun.framework.orm.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_module")
public class Module extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="FShortName")
	private String shortName;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
}
