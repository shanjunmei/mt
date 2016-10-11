package com.lanhun.framework.orm.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_module_function")
public class ModuleFunction extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="module_id")
	@OneToOne()
	private Module module;
	
	@JoinColumn(name="function_id")
	@OneToOne()
	private Function function;

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
	
	
}
