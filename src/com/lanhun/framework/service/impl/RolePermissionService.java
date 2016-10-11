package com.lanhun.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IRolePermissionDao;
import com.lanhun.framework.orm.po.RolePermission;
import com.lanhun.framework.service.IRolePermissionService;
@Service
public class RolePermissionService extends BaseService<RolePermission, String> implements IRolePermissionService{

	@Resource
	private IRolePermissionDao dao;
	@Override
	protected IRolePermissionDao getDao() {
		return dao;
	}

	
}
