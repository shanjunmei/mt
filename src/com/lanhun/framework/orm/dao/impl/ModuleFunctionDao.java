package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IModuleFunctionDao;
import com.lanhun.framework.orm.po.ModuleFunction;

@Repository
public class ModuleFunctionDao extends BaseDao<ModuleFunction, String> implements IModuleFunctionDao {}
