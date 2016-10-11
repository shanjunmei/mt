package com.lanhun.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IModuleDao;
import com.lanhun.framework.orm.po.Module;
import com.lanhun.framework.service.IModuleService;
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class ModuleService extends BaseService<Module, String> implements IModuleService{

	@Resource
	private IModuleDao dao;
	@Override
	protected IModuleDao getDao() {
		return dao;
	}

	
}
