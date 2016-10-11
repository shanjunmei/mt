package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IFunctionDao;
import com.lanhun.framework.orm.po.Function;

@Repository
public class FunctionDao extends BaseDao<Function, String> implements IFunctionDao {
	
}
