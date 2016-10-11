package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IRolePermissionDao;
import com.lanhun.framework.orm.po.RolePermission;

@Repository
public class RolePermissionDao extends BaseDao<RolePermission, String> implements IRolePermissionDao {}
