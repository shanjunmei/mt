package com.lanhun.framework.utils;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.lanhun.framework.utils.em.ExceptionType;

public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver{

	private Logger logger= LoggerFactory.getLogger(HandlerExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, java.lang.Exception ex) {
		
		Throwable root= ExceptionUtils.getRootCause(ex);
		Exception exception=new Exception();
		if(root==null){
			if(ex instanceof ServiceException){
				exception.setMessage(ex.getMessage());
				exception.setType(ExceptionType.ServiceException);
			}else{
				exception.setMessage(ex.getMessage());
			}
			
		}
		else if(root instanceof SQLException){
			int errorCode=((SQLException) root).getErrorCode();
			String message=root.getMessage();
			String state=((SQLException) root).getSQLState();
			exception.setCode(errorCode+"");
			exception.setType(ExceptionType.SQLException);
			//exception.setThrowable(ex);
			if(errorCode==1451){
				message="删除失败，数据被引用";
			}
			exception.setMessage(message);
			logger.info("SQLException code : "+ errorCode+" ,state : "+state);
		}
		logger.debug(ex.getMessage(), ex.getCause());
		if(handler instanceof HandlerMethod){
			String bean=((HandlerMethod) handler).getBean().getClass().getSimpleName();
			String method=((HandlerMethod) handler).getMethod().getName();
			logger.warn(bean+"."+method+" : "+ ex.getMessage());
		}else{
			logger.warn(handler.toString()+" : "+ ex.getMessage());
		}
		
		
		//RedirectView rv=new RedirectView("/exception/handler.html",true);
		MappingJackson2JsonView jsonView=new MappingJackson2JsonView(); 
		ModelAndView view=new ModelAndView(jsonView,"ex",exception);
	//	view.setViewName("redirect:exception/handler.html");
		return view;
	}

}
