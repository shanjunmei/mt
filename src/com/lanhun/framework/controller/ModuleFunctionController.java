package com.lanhun.framework.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.orm.po.ModuleFunction;
import com.lanhun.framework.service.IModuleFunctionService;

@Controller
@RequestMapping("/moduleFunction")
public class ModuleFunctionController extends BaseController<ModuleFunction, String> {

	@Resource
	private IModuleFunctionService service;

	@Override
	protected IModuleFunctionService getService() {
		return service;
	}

	@Override
	protected ModuleFunction prepare4save(ModuleFunction intance) {
		intance=super.prepare4save(intance);
		if(intance.getModule()!=null){
			if(StringUtils.isBlank(intance.getModule().getId())){
				intance.setModule(null);
			}
		}
		if(intance.getFunction()!=null){
			if(StringUtils.isBlank(intance.getFunction().getId())){
				intance.setFunction(null);
			}
		}
		return intance;
	}

	@Override
	protected String getModuleName() {
		return "模块-功能";
	}
	
}
