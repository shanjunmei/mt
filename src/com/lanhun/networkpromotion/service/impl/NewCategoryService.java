package com.lanhun.networkpromotion.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.service.impl.BaseService;
import com.lanhun.networkpromotion.orm.po.NewCategory;
import com.lanhun.networkpromotion.orm.po.dao.INewCategoryDao;
import com.lanhun.networkpromotion.service.INewCategoryService;
@Service
public class NewCategoryService extends BaseService<NewCategory, String> implements INewCategoryService{

	@Resource
	private INewCategoryDao dao;
	@Override
	protected INewCategoryDao getDao() {
		return dao;
	}

	
}
