package com.lanhun.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.orm.po.Role;
import com.lanhun.framework.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role, String>{
	
	@Resource
	private IRoleService service;
	
	@Override
	protected IRoleService getService() {
		return service;
	}

	@Override
	protected String getModuleName() {
		return "角色";
	}
}
