package com.lanhun.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.orm.po.Module;
import com.lanhun.framework.service.IModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController extends BaseController<Module, String>{
	
	@Resource
	private IModuleService service;
	
	@Override
	protected IModuleService getService() {
		return service;
	}

	@Override
	protected String getModuleName() {
		return "模块";
	}
}
