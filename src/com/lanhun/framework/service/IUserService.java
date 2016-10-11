package com.lanhun.framework.service;

import com.lanhun.framework.orm.po.User;

public interface IUserService extends IBaseService<User, String> {

	User checkLogin(User user);
}
