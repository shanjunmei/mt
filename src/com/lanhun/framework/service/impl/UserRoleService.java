package com.lanhun.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IUserRoleDao;
import com.lanhun.framework.orm.po.UserRole;
import com.lanhun.framework.service.IUserRoleService;
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class UserRoleService extends BaseService<UserRole, String> implements IUserRoleService{

	@Resource
	private IUserRoleDao dao;
	@Override
	protected IUserRoleDao getDao() {
		return dao;
	}

	
}
