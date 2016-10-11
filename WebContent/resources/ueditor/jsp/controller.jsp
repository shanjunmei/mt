<%@page import="com.lanhun.framework.utils.SysContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	//String basePath=request.getContextPath();
	if(SysContextUtils.hasLogin(session)){
		String rootPath =application.getRealPath( "/" );
		String res= new ActionEnter( request, rootPath ).exec() ;
		//System.out.println(res);
		out.write(res);
	}
	
	
%>