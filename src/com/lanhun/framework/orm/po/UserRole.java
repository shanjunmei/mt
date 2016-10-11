package com.lanhun.framework.orm.po;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="t_user_role")
public class UserRole extends BaseEntity {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	@JoinColumn(name="user_id")
	@OneToOne()
	@Fetch(FetchMode.JOIN)
	private User user;
	
	@JoinColumn(name="role_id")
	@OneToOne()
	@Fetch(FetchMode.JOIN)
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
