package com.lanhun.framework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lanhun.framework.orm.po.User;
import com.lanhun.framework.service.IUserService;
import com.lanhun.framework.utils.Md5;
import com.lanhun.framework.utils.SysContextUtils;
import com.lanhun.framework.utils.annotation.Permission;
import com.lanhun.framework.utils.annotation.PermissionType;
import com.lanhun.framework.utils.em.RequestSuffixType;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User, String> {

	@Resource
	private IUserService service;

	@Override
	protected IUserService getService() {
		return service;
	}

	
	@Override
	protected User prepare4save(User intance) {
		intance=super.prepare4save(intance);
		if(StringUtils.isNotBlank(intance.getPassword())){
			intance.setPassword(Md5.getMD5(intance.getPassword()));
		}
		return  intance;
	}


	@Permission(type=PermissionType.NONE)
	@RequestMapping(value={"login.{ext}"})
	public Object login(User user,@PathVariable("ext") String ext,HttpSession session) {
		ModelAndView view=new ModelAndView();
		user =service.checkLogin(user);
		view.addObject("user", null);
		if(user==null){
			if(RequestSuffixType.iv.name().equals(ext)){
				view.addObject("code", "2");
				view.addObject("msg", "fail");
			}else{
				view.setViewName("redirect:/index.jsp");
			}
		}else{
			session.setAttribute("CURRENT_lOGIN_USER", user);
			if(RequestSuffixType.iv.name().equals(ext)){
				view.addObject("code", "1");
				view.addObject("msg", "success");
				view.addObject("toView", "/main");
			}else{
				view.setViewName("/main");
			}
		}
		return view;
	}
	@RequestMapping(value={"logout.{ext}"})
	public Object logout(@PathVariable("ext") String ext) {
		ModelAndView view=new ModelAndView();
		User user =getCurrentUser();
		if(user!=null){
			SysContextUtils.logout();
			if(RequestSuffixType.iv.name().equals(ext)){
				view.addObject("code", "1");
				view.addObject("msg", "success");
			}
		}
		view.setViewName("redirect:/index.jsp");
		return view;
	}
	@RequestMapping(value={"/main.{ext}"})
	public Object toMainView(@PathVariable("ext") String ext){
		ModelAndView view=new ModelAndView();
		view.setViewName("_main");
		return view;
	}
	@Override
	protected String getModuleName() {
		return "用户";
	}
	
}
