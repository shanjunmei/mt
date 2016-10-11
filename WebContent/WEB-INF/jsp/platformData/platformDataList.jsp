<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/resources/js/list.js"></script>
<title>${_module_name}=》${_operate_name}</title>
</head>
<body>
	<div class="menu">
		<jsp:include page="../common/menu.jsp"></jsp:include>
	</div>
	<div id="content" class="content">
		<div class="formQuery">
			<jsp:include page="../common/queryForm.jsp"></jsp:include>
		</div>
		<table class="pageList">
			<tr>
				<th>序号</th>
				<th>名称</th>
				<th>法人代表</th>
				<th>上线时间</th>
				<th>注册地址</th>
				<th>注册资本</th>
				<th>发布人</th>
				<th>浏览量</th>
				<th>创建时间</th>
				<th>最后修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${dataList}" var="_data" varStatus="st">
				<c:if test="${st.index%2 eq 0}">
					<tr class="obb" onclick="rowSelect(this)" ondblclick="view('${_data.id}')">
				</c:if>
				<c:if  test="${st.index%2 eq 1}">
					<tr class="even" onclick="rowSelect(this)" ondblclick="view('${_data.id}')">
				</c:if>
						<td>${(baseQuery.pager.currentPage-1)*baseQuery.pager.pageSize+st.index+1}</td>
						<td>${_data.name}</td>
						<td>${_data.legalRepresentative}</td>
						<td>${_data.onlineTime}</td>
						<td>${_data.registAddr}</td>
						<td>${_data.registCaptial}</td>
						<td>${_data.publisher}</td>
						<td>${_data.borrowCount}</td>
						
						<td><fmt:formatDate value="${_data.createdTime}"
								pattern="yyyy-MM-dd HH:mm" /></td>
						<td><fmt:formatDate value="${_data.lastModifyTime }"
								pattern="yyyy-MM-dd HH:mm" /></td>
						<td class="listOperation">
						<a href="#" onclick="edit('${_data.id}')">编辑</a>
						
						<a	href="#" onclick="deleteRow('${_data.id}')">删除</a>
						<a	href="#" onclick="view('${_data.id}')">查看</a></td>
					</tr>

					
			</c:forEach>
			
		</table>
		<div class="listFooter">
			<jsp:include page="../common/navigation.jsp"></jsp:include>
			<div class="actionPanel">
				<input type="button" value="新增" onclick="toAdd()"><input
					type="button" value="删除">
			</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>