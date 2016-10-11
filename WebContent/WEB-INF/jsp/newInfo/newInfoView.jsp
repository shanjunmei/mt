<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp" %>

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
	<form:form action="save" commandName="editData"  method="post">
		<table class="view">	
			<tr>
					<td>标题：</td>
					<td>${editData.title}</td>
					<td>摘要：</td>
					<td>${editData.summary}</td>



					<td>类别：</td>
					<td>${editData.category.name}</td>

					<td>信息来源：</td>
					<td>${editData.source}</td>



				</tr>
				<tr>

					<td>发布者：</td>
					<td>${editData.publisher}</td>

					<td>浏览量：</td>
					<td>${editData.borrowCount}</td>

					<td>创建时间</td>
					<td>${editData.createdTime}</td>
					<td>最后修改时间</td>
					<td>${editData.lastModifyTime}</td>

				</tr>
				<tr>
					<td>正文：</td>
				</tr>
				<tr>
					<td colspan="8"><form:textarea path="content" cols="150" rows="30" readonly="true"/></td>
				</tr>
				<tr>
					<td colspan="8">
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