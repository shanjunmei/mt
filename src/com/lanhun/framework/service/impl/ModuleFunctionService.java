package com.lanhun.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IModuleFunctionDao;
import com.lanhun.framework.orm.po.ModuleFunction;
import com.lanhun.framework.service.IModuleFunctionService;

//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class ModuleFunctionService extends BaseService<ModuleFunction, String>
		implements IModuleFunctionService {

	@Resource
	private IModuleFunctionDao dao;

	@Override
	protected IModuleFunctionDao getDao() {
		return dao;
	}

}
