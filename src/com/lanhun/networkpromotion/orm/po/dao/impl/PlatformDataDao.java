package com.lanhun.networkpromotion.orm.po.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.impl.BaseDao;
import com.lanhun.networkpromotion.orm.po.PlatformData;
import com.lanhun.networkpromotion.orm.po.dao.IPlatformDataDao;

@Repository
public class PlatformDataDao extends BaseDao<PlatformData, String>
		implements IPlatformDataDao {
}
