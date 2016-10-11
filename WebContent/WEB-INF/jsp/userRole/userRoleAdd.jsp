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

<script type="text/javascript"
	src="<%=path%>/resources/js/jquery/jquery-ui-1.9.2.custom.min.js"></script>
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
			<div class="container">
				<div class="row">
					<div class="col-md-1">名称：</div>
					<div class="col-md-3">
						<form:input path="name" readonly="${view_readonly}" />
					</div>
					<div class="col-md-1"> 编码：</div>
					<div class="col-md-3">
						<form:input path="number" readonly="${view_readonly}" />
					</div>


					<div class="col-md-1">用户：</div>
					<div class="col-md-3">
						<form:input path="user.name" onclick="openUserSelect(path)"
							readonly="true" disabled="${view_readonly}" />
						<form:hidden path="user.id" />
					</div>

					<div class="col-md-1">角色：</div>
					<div class="col-md-3">
						<form:input path="role.name" onclick="openRoleSelect(path)"
							readonly="true" disabled="${view_readonly}" />
						<form:hidden path="role.id" />
					</div>
					<div class="col-md-1">启用：</div>
					<div class="col-md-3">
						<form:select path="enabled" items="${status}" itemLabel="display"
							value="${enabled}" />
					</div>


					<div class="col-md-1">创建时间</div>
					<div class="col-md-3">
						<form:input path="createdTime" class="Wdate" readonly="true" />
					</div>
					<div class="col-md-1">最后修改时间</div>
					<div class="col-md-3">
						<form:input path="lastModifyTime" class="Wdate" readonly="true" />
					</div>



				</div>
				<div class="actionPanel">
					<div class="">
						<c:if test="${!view_readonly}">
							<input type="submit" value="保存">
						</c:if>
					</div>

					<div class="">
						<c:if test="${!view_readonly}">
							<input type="reset" value="重置">
						</c:if>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
	<!-- <div id="_objectSelect"></div> -->
</body>
</html>