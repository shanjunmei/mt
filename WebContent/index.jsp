<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1"> -->
<title>欢迎</title>
<style type="text/css">
html {
	width: 100%;
	height: 100%;
	overflow-x: hidden;
	overflow-y: hidden;
}

body {
	text-align: center;
	background: url('resources/img/login.jpg') center fixed;
	background-size: 100% 100%;
	width: 100%;
	height: 100%;
}

#top {
	-webkit-filter: opacity(0.6);
	position: absolute;;
	top: 0px;
	/* left:-130px;; */
	text-align: left;
	width: 100%;
	height: 50px;
	background: #e4e4e4;
}

#Layer1 {
	position: relative;
	width: 570px;
	height: 430px;
	z-index: 1;
}

#Layer1_1 {
	width: 540px;
	height: 120px;
	z-index: 1;
	background: #ffffff;
	-webkit-filter: opacity(0.8);
}

#Layer2 {
	position: absolute;
	width: 360px;
	height: 120px;
	z-index: 1;
	
	margin-top:4px;
}

#name {
	background-image: url("resources/img/User.png");
	background-repeat: no-repeat;
	padding-left: 36px;
}

#password {
	background-image: url("resources/img/psd.png");
	background-repeat: no-repeat;
	padding-left: 36px;
}

#Layer3 {
	position: absolute;
	width: 360px;
	height: 71px;
	z-index: 1;
	left: 0px;
	top: 52px;
	margin-top:6px;
}

#Layer4 {
	position: absolute;
	width: 161px;
	z-index: 1;
	left: 365px;
	top: -50px;
	text-align: center;
}

#Layer4 div {
	margin-top:0px;
	height: 100x; 
	line-height:100px;
	text-align:center;
	font-size: 45px;
	color: white;
	background: #3786D5;
}

#Layer4 div:HOVER {
	cursor: pointer;
	background: #3766D5;
}

input {
	height: 50px;
	width: 300px;
	font-size: 30px;
}

#title {
	position: relative;
	top: 0px;
	color: white;
	font-size: 80px;
	font-family: 黑体;
}

#ctitle {
	position: relative;
	top: -15px;
	color: white;
	font-size: 30px;
	font-family: 黑体;
}

#footer {
	width: 100%;
	position: absolute;
	bottom:0; 
	text-align: center;
	font-size: 14px;
	font-family: 黑体;
	color: white;
}
</style>
<script type="text/javascript"
	src="<%=path%>/resources/js/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	//禁止滚动条
	/* $(document.body).css({
		"overflow-x" : "hidden",
		"overflow-y" : "hidden"
	}); */

	function doLogin() {
		var requrl = $("form")[0];
		//console.log($(requrl).serialize());
		var ret = $.ajax({
			type : "post",
			data : $(requrl).serialize(),
			url : requrl.action,
			async : false
		});

		var rv = ret.responseText;
		rv = eval("(" + rv + ")");
		if (rv.code == 1) {
			window.location.href = 'user/main.html';
		} else {
			alert("用户名或密码错误");
		}
	}
</script>
</head>
<body>
	<form action="user/login.iv" method="post" onsubmit="return false">
		<div id="top">
			<img style="margin-top: 7px;" alt="" src="resources/img/logo.png">
		</div>
		<div id="Layer1">
			<div id="title">主标题</div>
			<div id="ctitle">次标题</div>
			<div id="Layer1_1">
				<label></label> <label></label>
				<div id="Layer2">
					<input id="name" placeholder="姓名" type="text" name="number"
						style="border: 1px solid; color: #e4e4e4;" />
					<div id="Layer3">
						<input id="password" placeholder="密码" type="password"
							name="password" style="border: 1px solid; color: #e4e4e4;" />
						<div id="Layer4" onclick="doLogin()">
							<div >登录</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<span> CopyRigth 2015 深圳市XXX技有限公司 </span>
		</div>
	</form>
</body>
<script type="text/javascript">
	var main = document.getElementById("Layer1");
	var wid = document.body.offsetWidth;//screen.availWidth;
	var hei = document.body.offsetHeight;//screen.availHeight;
	var lw = wid - main.offsetWidth;
	var lh = hei - main.offsetHeight;
	main.style.position = "absolute";
	main.style.left = lw / 2 + "px";
	main.style.top = (lh / 2 + 39) + "px";

	document.onkeydown = keyDo;

	function keyDo(e) {
		//console.log(e);
		// 兼容FF和IE和Opera    
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (code == 13) {
			//回车执行查询
			$("#Layer4").click();
		}
	}
</script>
</html>