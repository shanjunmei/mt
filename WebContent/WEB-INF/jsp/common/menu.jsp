<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--可无视-->
<link href="<%=path %>/resources/menu/css/global.css" rel="stylesheet">

<!--必要样式-->
<link type="text/css" href="<%=path %>/resources/menu/css/style.css" rel="stylesheet">
<link href="<%=path %>/resources/menu/css/component.css" rel="stylesheet" type="text/css" />

<%-- <script type="text/javascript" src="<%=path %>/resources/menu/js/jquery.js"></script> --%>
<script type="text/javascript" src="<%=path %>/resources/menu/js/modernizr.custom.js"></script>
<script type="text/javascript" src="<%=path %>/resources/menu/js/jquery.dlmenu.js"></script>
</head>
<body>

	<header class="header">
	<a href="<%=path %>/user/main.html" class="logo"><img src="<%=path %>/resources/menu/images/logo.png" alt="嘉华旅游" title="嘉华旅游"></a>
	<a href="<%=path %>/user/main.html" class="search"><span>目的地搜索</span></a>
	<a href="<%=path %>/user/logout.html" class="user-icon"><span>用户中心</span></a>
	<div id="dl-menu" class="dl-menuwrapper">
		<button id="dl-menu-button">Open Menu</button>
		<ul class="dl-menu">
			<li><a href="<%=path %>/user/main.html">首页</a></li>
			<li><a href="<%=path%>/role/list.html">角色列表</a></li>
			<li><a href="<%=path%>/user/list.html">用户列表</a></li>
			<li><a href="<%=path%>/userRole/list.html">用户角色列表</a></li>
			<li><a href="<%=path%>/module/list.html">模块列表</a></li>
			<li><a href="<%=path%>/moduleFunction/list.html">模块功能列表</a></li>
			<li><a href="<%=path%>/rolePermission/list.html">角色权限列表</a></li>
			<li>
				<a href="Line">自由行</a>
				<ul class="dl-submenu">
					<li class="dl-back"><a href="#">返回上一级</a></li>
					<li><a href="http://sc.chinaz.com/">线路</a></li>
					<li><a href="http://sc.chinaz.com/">签证</a></li>
					<li><a href="http://sc.chinaz.com/">门票</a></li>
				</ul>
			</li>
			
		</ul>
	</div>
</header>

<script type="text/javascript">
$(function(){
	$( '#dl-menu' ).dlmenu();
});
</script>

</body>
</html>