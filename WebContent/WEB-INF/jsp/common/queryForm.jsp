<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"	src="<%=path%>/resources/calendar/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"	href="<%=path%>/resources/css/default.css">
</head>
<body>
		<form:form id="pageListForm" action="list.html" commandName="baseQuery" method="get">
				<form:hidden value="${baseQuery.pager.currentPage}" path="pager.currentPage"/> 
   				<form:hidden id="_pageSize" value="${baseQuery.pager.pageSize}" path="pager.pageSize" /> 
				<dl class="queryPanel" >
					<c:forEach items="${baseQuery.items}" var="item" varStatus="index">
						<c:if test="${index.index%4==0 }">
							<dd class="ddbreak">${item.display}</dd>
						</c:if>
						<c:if test="${index.index%4!=0 }">
							<dd>${item.display}</dd>
						</c:if>
						
						<dd>
						
							<c:if test="${item.type=='String' or item.type=='Number'}">
								<input type="text" name="items[${index.index}].value" placeholder="${item.display}" value="${item.value}"/>
							</c:if>
							<c:if test="${item.type=='Date'}">
								<form:input path="items[${index.index}].value" placeholder="${item.display}"  class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false,readOnly:false,disabled:false})"/>
							</c:if>
							<c:if test="${item.type=='Enum'}">
								<form:select path="items[${index.index}].value" items="${item.enumRanges}" placeholder="${item.display}"   value="${item.value}" />
							</c:if>
							<c:if test="${item.type=='Boolean'}">
								<form:checkbox path="items[${index.index}].value" placeholder="${item.display}"  value="${item.value}"/>
							</c:if>
							<form:hidden path="items[${index.index}].name"  value="${item.name}"/>
							<form:hidden path="items[${index.index}].compareType"  value="${item.compareType}"/>
						 </dd>
					</c:forEach>
					
				</dl>
				<div >
					<input id="queryBtn" type="button" onclick="gotoPage(1)" value="查询"/>
					<input type="button" onclick="toList()" value="重置"/>
				</div>
			</form:form>
</body>