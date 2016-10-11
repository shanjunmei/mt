package com.lanhun.framework.orm.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_role_permission")
public class RolePermission extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="role_id")
	@OneToOne()
	private Role role;
	
	@JoinColumn(name="permission_id")
	@OneToOne
	private ModuleFunction moduleFunction;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ModuleFunction getModuleFunction() {
		return moduleFunction;
	}

	public void setModuleFunction(ModuleFunction moduleFunction) {
		this.moduleFunction = moduleFunction;
	}


}
