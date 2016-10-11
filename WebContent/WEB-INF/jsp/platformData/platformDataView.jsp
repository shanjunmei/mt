<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查看</title>
</head>
<body>
	<div class="menu">
		<jsp:include page="../common/menu.jsp"></jsp:include>
	</div>
	<div class="content">
		<form:form action="save" commandName="editData" method="post">
			<table class="view">
				<tr>
					<td>名称：</td>
					<td>${editData.name}</td>

					<td>Logo：</td>
					<td>${editData.logo}</td>

					<td>平台上线时间：</td>
					<td>${editData.onlineTime}</td>

					<td>法人代表：</td>
					<td>${editData.legalRepresentative}</td>


				</tr>
				<tr>

					<td>注册资本：</td>
					<td>${editData.registCaptial}</td>

					<td>发布人：</td>
					<td>${editData.publisher}</td>

					<td>浏览数量：</td>
					<td>${editData.borrowCount}</td>


					<td>注册地址：</td>
					<td>${editData.registAddr}</td>



				</tr>
				<tr>

					<td>平台简介：</td>
					<td colspan="7"><textarea rows="3" cols="138"
							readonly="readonly">${editData.plantformIntroduction}</textarea>
					</td>
				</tr>
				<tr>
					<td>正文：</td>

				</tr>
				<tr>
					<td colspan="8"><textarea rows="30" cols="150"
							readonly="readonly">${editData.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="8"><input type="button" onclick="window.close()"
						value="关闭">
				</tr>
			</table>
		</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>