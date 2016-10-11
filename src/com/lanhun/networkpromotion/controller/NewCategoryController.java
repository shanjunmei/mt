package com.lanhun.networkpromotion.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.controller.vo.QueryForm;
import com.lanhun.networkpromotion.orm.po.NewCategory;
import com.lanhun.networkpromotion.service.INewCategoryService;

@Controller
@RequestMapping("/newCategory")
public class NewCategoryController extends PromotionBaseController<NewCategory, String> {

	@Resource
	private INewCategoryService service;

	@Override
	protected INewCategoryService getService() {
		return service;
	}

	@Override
	protected QueryForm getQueryForm() {
		QueryForm queryForm=super.getQueryForm();
		queryForm.removeItems("createdTime","lastModifyTime","enabled");
		return queryForm;
	}
	@Override
	protected String getModuleName() {
		return "资讯类别";
	}
}
