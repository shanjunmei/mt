package com.lanhun.networkpromotion.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanhun.framework.service.impl.BaseService;
import com.lanhun.networkpromotion.orm.po.PlatformArchives;
import com.lanhun.networkpromotion.orm.po.dao.IPlatformArchivesDao;
import com.lanhun.networkpromotion.service.IPlatformArchivesService;
@Service
public class PlatformArchivesService extends BaseService<PlatformArchives, String> implements IPlatformArchivesService{

	@Resource
	private IPlatformArchivesDao dao;
	@Override
	protected IPlatformArchivesDao getDao() {
		return dao;
	}

	
}
