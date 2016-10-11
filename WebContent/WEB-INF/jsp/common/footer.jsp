<%@page import="com.lanhun.framework.orm.po.User"%>
<%@page import="com.lanhun.framework.utils.SysContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%
	String basePath = request.getContextPath();
	User loginUser = SysContextUtils.getCurrentUser(session);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>footer</title>
</head>
<body>
	copyright
	<% if(loginUser!=null) {
		out.append("<a href="+basePath+"/user/logout.iv"+">登出</a>");
	}%>
	
</body>
</html>