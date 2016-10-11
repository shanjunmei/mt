package com.lanhun.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/xt")
public class TController {

	@RequestMapping(value = "ts")
	@ResponseBody
	public String ts() {
		System.out.println("哈哈");
		return "htllo";
	}

	// @RequestMapping(value="test",method = RequestMethod.GET)
	@RequestMapping
	@ResponseBody
	public void test() {
		System.out.println("fuck");
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public void te() {
		System.out.println("fuck");
	}

	@RequestMapping(value = "hello")
	public ModelAndView  hello() {
		System.out.println("fuck");
		ModelAndView view=new ModelAndView();
		view.setViewName("hello");
		return view;
	}
}
