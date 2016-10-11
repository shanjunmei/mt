package com.lanhun.networkpromotion.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.controller.vo.CompareType;
import com.lanhun.framework.controller.vo.ItemDataType;
import com.lanhun.framework.controller.vo.QueryForm;
import com.lanhun.framework.controller.vo.QueryItem;
import com.lanhun.networkpromotion.orm.po.PlatformData;
import com.lanhun.networkpromotion.service.IPlatformDataService;

@Controller
@RequestMapping("/platformData")
public class PlatformDataController extends PromotionBaseController<PlatformData, String> {

	@Resource
	private IPlatformDataService service;

	@Override
	protected IPlatformDataService getService() {
		return service;
	}
	@Override
	protected QueryForm getQueryForm() {
		QueryForm queryForm=super.getQueryForm();
		queryForm.removeItems("createdTime","lastModifyTime","enabled","number");
		queryForm.getItems().add(new QueryItem("legalRepresentative", null, "法人代表",CompareType.like));
		queryForm.getItems().add(new QueryItem("registAddr", null, "注册地址",CompareType.like));
		queryForm.getItems().add(new QueryItem("registCaptial", null, "注册资本",CompareType.like));
		queryForm.getItems().add(new QueryItem("publisher", null, "发布人",CompareType.like));
		queryForm.getItems().add(new QueryItem("borrowCount", null, "浏览量",ItemDataType.Number));
		queryForm.getItems().add(new QueryItem("onlineTime", null, "上线时间",CompareType.like));
		return queryForm;
	}
	@Override
	protected String getModuleName() {
		return "平台数据";
	}

}
