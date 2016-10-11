package com.lanhun.networkpromotion.orm.po.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.impl.BaseDao;
import com.lanhun.networkpromotion.orm.po.NewInfo;
import com.lanhun.networkpromotion.orm.po.dao.INewInfoDao;

@Repository
public class NewInfoDao extends BaseDao<NewInfo, String> implements INewInfoDao {
}
