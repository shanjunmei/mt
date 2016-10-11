package com.lanhun.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IRoleDao;
import com.lanhun.framework.orm.po.Role;
import com.lanhun.framework.service.IRoleService;
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class RoleService extends BaseService<Role, String> implements IRoleService{

	@Resource
	private IRoleDao dao;
	@Override
	protected IRoleDao getDao() {
		return dao;
	}

	
}
