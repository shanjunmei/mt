<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
<script type="text/javascript" src="<%=path%>/resources/js/select/select.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery-ui-1.9.2.custom.min.js"></script>

<script type="text/javascript">
	var path='<%=path%>';
</script>

<link rel="stylesheet" type="text/css"	href="<%=path%>/resources/css/jquery/ui-lightness/jquery-ui-1.9.2.custom.min.css">

</head>
<body>
<div class="menu">
	<jsp:include page="../common/menu.jsp"></jsp:include>
</div>
<div class="content">
	<form:form action="modify.do"  commandName="editData"  method="post">
		<form:hidden  path="id"  />
		<table>
				<tr>
					<td>标题：</td>
					<td><form:input path="title" /></td>
					<td>摘要：</td>
					<td><form:input path="summary" /></td>



					<td>类别：</td>
					<td><form:input path="category.name"
							onclick="openNewCategorySelect(path)" readonly="true" /> <form:hidden
							path="category.id" /></td>

					<td>信息来源：</td>
					<td><form:input path="source" /></td>



				</tr>
				<tr>

					<td>发布者：</td>
					<td><form:input path="publisher" /></td>

					<td>浏览量：</td>
					<td><form:input path="borrowCount" /></td>

					<td>创建时间</td>
					<td><form:input path="createdTime" class="Wdate"
							readonly="true" /></td>
					<td>最后修改时间</td>
					<td><form:input path="lastModifyTime" class="Wdate"
							readonly="true" /></td>

				</tr>
				<tr>
					<td>正文：</td>
				</tr>
				<tr>
					<td colspan="8"><form:textarea path="content" cols="150" rows="30" /></td>
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