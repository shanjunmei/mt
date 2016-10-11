package com.lanhun.framework.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.orm.po.UserRole;
import com.lanhun.framework.service.IUserRoleService;

@Controller
@RequestMapping("/userRole")
public class UserRoleController extends BaseController<UserRole, String> {

	@Resource
	private IUserRoleService service;

	@Override
	protected IUserRoleService getService() {
		return service;
	}

	@Override
	protected UserRole prepare4save(UserRole intance) {
		intance=super.prepare4save(intance);
		if(intance.getUser()!=null){
			if(StringUtils.isBlank(intance.getUser().getId())){
				intance.setUser(null);
			}else{
				intance.getUser().setLastModifyTime(new Date());
			}
		}
		if(intance.getRole()!=null){
			if(StringUtils.isBlank(intance.getRole().getId())){
				intance.setRole(null);
			}else{
				intance.getRole().setLastModifyTime(new Date());
			}
		}
		return intance;
	}

	@Override
	protected String getModuleName() {
		return "用户-角色";
	}
	
}
