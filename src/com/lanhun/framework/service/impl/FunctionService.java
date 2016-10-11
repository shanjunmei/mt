package com.lanhun.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IFunctionDao;
import com.lanhun.framework.orm.po.Function;
import com.lanhun.framework.service.IFunctionService;
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class FunctionService extends BaseService<Function, String> implements IFunctionService{

	@Resource
	private IFunctionDao dao;
	@Override
	protected IFunctionDao getDao() {
		return dao;
	}

	
}
