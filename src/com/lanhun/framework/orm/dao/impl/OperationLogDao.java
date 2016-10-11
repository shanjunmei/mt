package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IOperationLogDao;
import com.lanhun.framework.orm.po.OperationLog;

@Repository
public class OperationLogDao extends BaseDao<OperationLog, String> implements
		IOperationLogDao {
}
