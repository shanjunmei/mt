package com.lanhun.networkpromotion.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.service.impl.BaseService;
import com.lanhun.networkpromotion.orm.po.NewInfo;
import com.lanhun.networkpromotion.orm.po.dao.INewInfoDao;
import com.lanhun.networkpromotion.service.INewInfoService;
@Service
public class NewInfoService extends BaseService<NewInfo, String> implements INewInfoService{

	@Resource
	private INewInfoDao dao;
	@Override
	protected INewInfoDao getDao() {
		return dao;
	}

	
}
