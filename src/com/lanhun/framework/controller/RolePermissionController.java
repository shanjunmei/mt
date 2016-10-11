package com.lanhun.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.orm.po.RolePermission;
import com.lanhun.framework.service.IRolePermissionService;

@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController extends BaseController<RolePermission, String>{
	
	@Resource
	private IRolePermissionService service;
	
	@Override
	protected IRolePermissionService getService() {
		return service;
	}

	@Override
	protected String getModuleName() {
		return "角色权限";
	}
}
