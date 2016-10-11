package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IModuleDao;
import com.lanhun.framework.orm.po.Module;

@Repository
public class ModuleDao extends BaseDao<Module, String> implements IModuleDao {
	
}
