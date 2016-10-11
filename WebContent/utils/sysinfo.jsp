<%@page import="com.lanhun.framework.utils.SystemPropertyUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8" session="false"
    pageEncoding="utf-8"%>
<%
	String info=	SystemPropertyUtils.getSystemProperties()+"\n"+SystemPropertyUtils.getMemoryInfo();
	info=info.replaceAll("\n", "<br/>");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css">
	body {
		background-color: black;
		color: white; 
	
		margin-left: auto;
		margin-right: auto;
	}
	
	body div {
		/*width:800px;
		height:600px;
		 margin:0px; */
		text-shadow:activeborder;
		margin-left: 50px;
		margin-right: 50px;
		margin-top: 20px;
		margin-bottom: 20px;
		overflow:auto;
		background-color: black;
		color: white;
		display: block;
		
	}
</style>
<title>System Information</title>
</head>
<body>
	<div>
	<h1>系统属性</h1>
	<%
		out.print(info);
	%>
	</div>
</body>
</html>