package com.lanhun.networkpromotion.orm.po.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.impl.BaseDao;
import com.lanhun.networkpromotion.orm.po.PlatformArchives;
import com.lanhun.networkpromotion.orm.po.dao.IPlatformArchivesDao;

@Repository
public class PlatformArchivesDao extends BaseDao<PlatformArchives, String>
		implements IPlatformArchivesDao {
}
