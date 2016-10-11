package com.lanhun.framework.orm.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="t_operation_log")
public class OperationLog extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="FContent",length=255)
	private String content;
	
	@Column(name="FModule",length=80)
	private String module;
	
	@Column(name="FOpertion",length=80)
	private String operation;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	
	
}
