package com.lanhun.networkpromotion.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.service.impl.BaseService;
import com.lanhun.networkpromotion.orm.po.PlatformData;
import com.lanhun.networkpromotion.orm.po.dao.IPlatformDataDao;
import com.lanhun.networkpromotion.service.IPlatformDataService;
@Service
public class PlatformDataService extends BaseService<PlatformData, String> implements IPlatformDataService{

	@Resource
	private IPlatformDataDao dao;
	@Override
	protected IPlatformDataDao getDao() {
		return dao;
	}

	
}
