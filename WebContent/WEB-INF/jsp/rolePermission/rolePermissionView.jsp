<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户角色查看</title>
</head>
<body>
<div class="menu">
	<jsp:include page="../common/menu.jsp"></jsp:include>
</div>
<div class="content">
	<form:form action="save"  commandName="editData"  method="post">
		<table class="view">	
			<tr>
				<td>名称：</td>
				<td>
					${editData.name}
				</td>
				<td>编码：</td>
				<td>${editData.number}</td>
				<td>状态：</td>
				<td>${editData.enabled.display}</td>
			</tr>
			<tr>
					<td>用户：</td>
					<td>${editData.user.name}</td>

					<td>角色：</td>
					<td>${editData.role.name }</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td>
					${editData.createdTime }
				</td>
				<td>最后修改时间</td>
				<td>${editData.lastModifyTime}</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="button" onclick="window.close()" value="关闭" >
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>