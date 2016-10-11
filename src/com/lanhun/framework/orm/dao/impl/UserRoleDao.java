package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IUserRoleDao;
import com.lanhun.framework.orm.po.UserRole;

@Repository
public class UserRoleDao extends BaseDao<UserRole, String> implements IUserRoleDao {}
