package com.lanhun.framework.orm.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.IUserDao;
import com.lanhun.framework.orm.po.User;

@Repository
public class UserDao extends BaseDao<User, String> implements IUserDao {}
