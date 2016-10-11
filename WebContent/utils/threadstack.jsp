<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Thread Stack</title>
</head>
<body>
	<%
		out.append("<table border='1'>");
		int threadCounts=0;
		for (Entry<Thread, StackTraceElement[]> e : Thread
				.getAllStackTraces().entrySet()) {
			threadCounts++;
			Thread key=	e.getKey();
			out.append("<tr>");
			out.append("\t<td>");
			out.append(key.getName()+ " threadid="+key.getId()+" prio="+key.getPriority()+ " java.lang.Thread.State : "+key.getState());
			out.append("</td>");

			out.append("\t<td><pre>");
			for (StackTraceElement s : e.getValue()) {
				out.append(s.getClassName());
				out.append(".");
				out.append(s.getMethodName());
				out.append("(");
				out.append(s.getFileName());
				out.append(":");
				out.append(String.valueOf(s.getLineNumber()));
				out.append(")\r\n");
			}
			out.append("</pre></td>");
			out.append("</tr>");
		}
		out.append("</table>");
		out.append("总线程数："+threadCounts);
	%>
</body>
</html>