<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${_module_name}=》${_operate_name}</title>
<script type="text/javascript"
	src="<%=path%>/resources/js/select/select.js"></script>

<script type="text/javascript" src="<%=path%>/resources/js/jquery/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript">
	var path='<%=path%>';
</script>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/resources/css/jquery/ui-lightness/jquery-ui-1.9.2.custom.min.css">
</head>
<body>
	<div class="menu">
		<jsp:include page="../common/menu.jsp"></jsp:include>
	</div>
	<div class="content">
		<form:form action="save.do" commandName="editData" method="post">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>名称：</td>
					<td><form:input path="name"  readonly="${view_readonly}"/></td>
					<td>编码：</td>
					<td><form:input path="number" readonly="${view_readonly}"/></td>


					<td>角色：</td>
					<td><form:input path="role.name"
							onclick="openRoleSelect(path)" readonly="true" disabled="${view_readonly}"/> <form:hidden
							path="role.id" /></td>
							
					<td>模块功能：</td>
					<td><form:input path="moduleFunction.name"
							onclick="openUserSelect(path)" readonly="true" disabled="${view_readonly}"/> <form:hidden
							path="moduleFunction.id" /></td>		
				</tr>
				<tr>
					<td>启用：</td>
					<td><form:select path="enabled" items="${status}" 
							itemLabel="display" value="${enabled}" /></td>


					<td>创建时间</td>
					<td><form:input path="createdTime" class="Wdate"
							readonly="true" /></td>
					<td>最后修改时间</td>
					<td><form:input path="lastModifyTime" class="Wdate"
							readonly="true" /></td>

				</tr>
				<tr>
					<td colspan="2"><c:if test="${!view_readonly}"><input type="submit" value="保存"  ></c:if></td>

					<td colspan="2"><c:if test="${!view_readonly}"><input type="reset" value="重置" > </c:if><input
						type="button" value="测试" onclick="alert('删除？')"></td>

				</tr>
			</table>
		</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<!-- <div id="_objectSelect"></div> -->
</body>
</html>