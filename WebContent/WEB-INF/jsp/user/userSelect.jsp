<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/selectinclude.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	var selectPath='<%=path%>'+'/${_entity}/';
</script>	
<title>用户选择列表</title>
</head>
<body>

	<div id="content" class="content">
		<div class="formQuery">
			<jsp:include page="../common/selectQueryForm.jsp"></jsp:include>
		</div>
		<table id="selectDataTable" class="pageList">
			<tr>
				<th>序号</th>
				<th>编码</th>
				<th>名称</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>最后修改时间</th>
			</tr>
			<c:forEach items="${dataList}" var="_data" varStatus="st">
				<c:if test="${st.index%2 eq 0}">
					<tr class="obb" id="${_data.id}" name="${_data.name}" onclick="rowSelect(this)" >
				</c:if>
				<c:if  test="${st.index%2 eq 1}">
					<tr class="even" id="${_data.id}" name="${_data.name}" onclick="rowSelect(this)">
				</c:if>
						<td>${(baseQuery.pager.currentPage-1)*baseQuery.pager.pageSize+st.index+1}</td>
						<td>${_data.number }</td>
						<td>${_data.name}</td>
						<td>${_data.enabled.display}</td>
						<td><fmt:formatDate value="${_data.createdTime}"
								pattern="yyyy-MM-dd HH:mm" /></td>
						<td><fmt:formatDate value="${_data.lastModifyTime }"
								pattern="yyyy-MM-dd HH:mm" /></td>
					</tr>

					
			</c:forEach>
			<tfoot>
				<tr>
					
					<td colspan="7">
						<table class="pageListFooter">
							<tr>
								<td><jsp:include page="../common/selectNavigation.jsp"></jsp:include></td>
							</tr>
						</table>
						
					</td>
				
					
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>