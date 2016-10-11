package com.lanhun.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.orm.po.Function;
import com.lanhun.framework.service.IFunctionService;

@Controller
@RequestMapping("/function")
public class FunctionController extends BaseController<Function, String>{
	
	@Resource
	private IFunctionService service;
	
	@Override
	protected IFunctionService getService() {
		return service;
	}

	@Override
	protected String getModuleName() {
		return "功能";
	}
}
