package com.lanhun.framework.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IUserDao;
import com.lanhun.framework.orm.po.User;
import com.lanhun.framework.service.IUserService;
import com.lanhun.framework.utils.Md5;
import com.lanhun.framework.utils.em.Status;
@Service
public class UserService extends BaseService<User, String> implements IUserService{

	@Resource
	private IUserDao dao;
	@Override
	protected IUserDao getDao() {
		return dao;
	}
	@Override
	public User checkLogin(User user) {
		int count=0;
		if(StringUtils.isBlank(user.getPassword())){
			count=dao.countByProperty(new String[]{"number","enabled"},new Object[] {user.getNumber(),Status.E});
		}else{
			user.setPassword(Md5.getMD5(user.getPassword()));
			count=dao.countByProperty(new String[]{"number","password","enabled"},new Object[] {user.getNumber(),user.getPassword(),Status.E});
			 
		}
		
		if(count>0){
		  List<User> users=dao.find("from User where number=:val0", new String[]{user.getNumber()});
		  user=users.get(0);
		  return user;
		}
		return null;
	}

}
