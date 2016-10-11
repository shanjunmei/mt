<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
</head>
<body>
	<div class="menu">
		<jsp:include page="../common/menu.jsp"></jsp:include>
	</div>
	<div class="content">
		<form:form action="modify.do" commandName="editData" method="post">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>名称：</td>
					<td><form:input path="name" /></td>

					<td>Logo：</td>
					<td><form:input path="logo" /></td>

					<td>平台上线时间：</td>
					<td><form:input path="onlineTime" /></td>

					<td>法人代表：</td>
					<td><form:input path="legalRepresentative" /></td>


				</tr>
				<tr>


					<td>注册资本：</td>
					<td><form:input path="registCaptial" /></td>

					<td>发布人：</td>
					<td><form:input path="publisher" /></td>

					<td>浏览数量：</td>
					<td><form:input path="borrowCount" /></td>

					<td>注册地址：</td>
					<td><form:input path="registAddr" /></td>


				</tr>
				<tr>
					<td>平台简介：</td>
					<td colspan="7"><form:textarea path="plantformIntroduction"
							cols="138" rows="3" /></td>

				</tr>
				<tr>
					<td>正文：</td>
				</tr>
				<tr>
					<td colspan="8"><form:textarea path="content" cols="150"
							rows="30" /></td>
				</tr>
				<tr>
					<td colspan="4"><input type="submit" value="保存"></td>

					<td colspan="4"><input type="reset" value="重置"></td>

				</tr>
			</table>
		</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>