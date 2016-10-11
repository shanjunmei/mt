<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8" session="false"
    pageEncoding="utf-8"%>
<%
	String appPath=application.getRealPath("/");
	String requestPath=request.getServletPath();
	File file=new File(application.getRealPath(requestPath)).getParentFile();
	File[] files=file.listFiles();
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
<title>Utils Index</title>
</head>
<body>
	<div>
	<h1>File List</h1>
		<h2>当前你求请的JSP文件的物理路径：<%=application.getRealPath(request.getServletPath())%></h2><BR> 
	<%
		for(File f:files){
			out.println("<a target='_blank' href='"+f.getName()+"'>"+f.getName()+"</a><br/>");
		}
	%>
		
	</div>
</body>
</html>