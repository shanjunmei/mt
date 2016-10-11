package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IRoleDao;
import com.lanhun.framework.orm.po.Role;

@Repository
public class RoleDao extends BaseDao<Role, String> implements IRoleDao {}
