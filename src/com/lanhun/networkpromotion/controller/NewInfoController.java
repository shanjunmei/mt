package com.lanhun.networkpromotion.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhun.framework.controller.vo.CompareType;
import com.lanhun.framework.controller.vo.ItemDataType;
import com.lanhun.framework.controller.vo.QueryForm;
import com.lanhun.framework.controller.vo.QueryItem;
import com.lanhun.networkpromotion.orm.po.NewInfo;
import com.lanhun.networkpromotion.service.INewInfoService;

@Controller
@RequestMapping("/newInfo")
public class NewInfoController extends PromotionBaseController<NewInfo, String> {

	@Resource
	private INewInfoService service;

	@Override
	protected INewInfoService getService() {
		return service;
	}
	@Override
	protected QueryForm getQueryForm() {
		QueryForm queryForm=super.getQueryForm();
		queryForm.removeItems("createdTime","lastModifyTime","enabled","number");
		queryForm.getItems().add(new QueryItem("title", null, "标题",CompareType.like));
		queryForm.getItems().add(new QueryItem("summary", null, "摘要",CompareType.like));
		queryForm.getItems().add(new QueryItem("source", null, "信息来源",CompareType.like));
		queryForm.getItems().add(new QueryItem("publisher", null, "发布者",CompareType.like));
		queryForm.getItems().add(new QueryItem("category.name", null, "资讯类别",CompareType.like));
		queryForm.getItems().add(new QueryItem("borrowCount", null, "浏览次数",ItemDataType.Number));
		
		return queryForm;
	}

	@Override
	protected NewInfo prepare4save(NewInfo intance) {
		intance=super.prepare4save(intance);
		if(intance.getCategory()!=null){
			if(StringUtils.isEmpty(intance.getCategory().getId())){
				intance.setCategory(null);
			}else{
				intance.getCategory().setLastModifyTime(new Date());
			}
		}
		return intance;
	}
	@Override
	protected String getModuleName() {
		return "新闻资讯";
	}
}
