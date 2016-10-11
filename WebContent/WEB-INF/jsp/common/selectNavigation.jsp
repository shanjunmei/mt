<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>footer</title>
</head>
<script type="text/javascript">
<!--
	/* function keydown(e){
		
		console.log(e);
		console.log(e.keyCode);
	}
	document.onkeydown=keydown; */
	
	function IsNumber(page){
		if(page){
			return !isNaN(page);
		}
		return false;
	}
	function gotoPage(page) {
		
		if (page == "0")
			 page = $("#pageInput").val(); 
		if (page == "") {
			alert("请输入页数");
			return false;
		}
		if (!IsNumber(page)) {
			alert("请输入正确的页数");
			return false;
		}
		 $("input[name='pager.currentPage']").val(page); 

	
		var form = "pageListForm";
		var act=$('#'+form).attr('action');
		act=selectPath+act;
		console.log(act);
		//$('#'+form).attr('action',act);
		$("#content").load(act, $("#" + form).serialize(), function() {
        	 $("#content").fadeIn("slow");
        });
		return false;
	}
	function selectPageSize(o) {
		//o.selected=true;
		console.log(o);
		//alert(o.value);
		$("#_pageSize").val(o.value);
		
		gotoPage(1);
		/* var form = "pageListForm";
		$("#" + form).submit(); */
		return false;
	}
	
	document.onkeydown=keyDo;
	function keyDo(e) {
		//console.log(e);
		// 兼容FF和IE和Opera    
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (code == 13) {
			//回车执行查询
			$("#queryBtn").click();
		}
	}
//-->
</script>


<div class="pagination" style="margin-top: 10px">
		 
		<c:if test="${(baseQuery.pager.currentPage)<=1}">
			<span class="prev-disabled"><b> </b> 上一页</span>
		</c:if>
		<c:if test="${(baseQuery.pager.currentPage)>1}">
			<a 
				onclick="javascript:return gotoPage('${baseQuery.pager.currentPage==1?1:baseQuery.pager.currentPage-1}');"
				href="javascript:void(0);"><span class="prev"><b> </b> 上一页</span></a>
		</c:if>

		<c:if test="${(baseQuery.pager.currentPage-4)>=1}">
			<c:if test="${(baseQuery.pager.currentPage-4)==1}">
				<a onclick="javascript:return gotoPage('1');"
					href="javascript:void(0);"><span>1</span></a>
			</c:if>
			<c:if test="${(baseQuery.pager.currentPage-4)!=1}">
				<a onclick="javascript:return gotoPage('1');"
					href="javascript:void(0);"><span>1</span></a>
				<span>...</span>
			</c:if>
		</c:if>


		<c:forEach items="${links}" var="size"
			varStatus="sta">
			<c:if test="${baseQuery.pager.totalPage>=7}">
				<c:if
					test='${((baseQuery.pager.currentPage+size)<=(baseQuery.pager.totalPage)) && ((baseQuery.pager.currentPage+size)>0)}'>
					<c:if test="${size==0}">
						<span class="current">${baseQuery.pager.currentPage}</span>
					</c:if>
					<c:if test="${size!=0}">
						<a
							onclick="javascript:return gotoPage('${baseQuery.pager.currentPage+size}');"
							href="javascript:void(0);"><span>${baseQuery.pager.currentPage+size}</span></a>
					</c:if>
				</c:if>
				<!-- 
				 		 -->
			</c:if>
			<c:if test="${baseQuery.pager.totalPage<7}">
				<c:if
					test='${((baseQuery.pager.currentPage+size)<=(baseQuery.pager.totalPage)) && ((baseQuery.pager.currentPage+size)>0)}'>
					<c:if test="${size==0}">
						<span class="current">${baseQuery.pager.currentPage}</span>
					</c:if>
					<c:if  test="${size!=0}">
						<a
							onclick="javascript:return gotoPage('${baseQuery.pager.currentPage+size}');"
							href="javascript:void(0);"><span>${baseQuery.pager.currentPage+size}</span></a>
					</c:if>
				</c:if>
			</c:if>
		</c:forEach>

		<c:if test="${(baseQuery.pager.currentPage+4)<=baseQuery.pager.totalPage}">
			<c:if test="${(baseQuery.pager.currentPage+4)==baseQuery.pager.totalPage}">
				<a
					onclick="javascript:return gotoPage('${baseQuery.pager.totalPage}');"
					href="javascript:void(0);"><span>${baseQuery.pager.totalPage}</span></a>
			</c:if>
			<c:if test="${(baseQuery.pager.currentPage+4)!=baseQuery.pager.totalPage}">
				<span>...</span>
				<a
					onclick="javascript:return gotoPage('${baseQuery.pager.totalPage}');"
					href="javascript:void(0);"><span>${baseQuery.pager.totalPage}</span></a>
			</c:if>
		</c:if>

		<c:if
			test="${((baseQuery.pager.currentPage)>=baseQuery.pager.totalPage)||((baseQuery.pager.currentPage==0)&&(baseQuery.pager.totalPage==1))}">
			<span  class="next-disabled">下一页 <b> </b></span>
		</c:if>
		<c:if test="${!((baseQuery.pager.currentPage)>=baseQuery.pager.totalPage)||((baseQuery.pager.currentPage==0)&&(baseQuery.pager.totalPage==1))}">
			<a
				onclick="javascript:return gotoPage('${((baseQuery.pager.currentPage)==(baseQuery.pager.totalPage))?(baseQuery.pager.currentPage):(baseQuery.pager.currentPage+1)}');"
				href="javascript:void(0);"><span class="next">下一页 <b> </b></span></a>
		</c:if>

		<span>跳到</span>
		<input id=pageInput size="2" maxLength="10" value="${baseQuery.pager.currentPage}" />
		/${baseQuery.pager.totalPage} 页
		
		<a class=pagenation onclick="javascript:return gotoPage('0');" href="javascript:void(0);"><span>确定</span></a>
		共：${baseQuery.pager.totalSize} 记录
		
		<select id="_pageSizeSelect" onchange="selectPageSize(this)" >
			<option value="10">10</option>
			<option value="15">15</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="50">50</option>
			<option value="100">100</option>
			<option value="500">500</option>
			<option value="1000">1000</option>
		</select>
	
</div>
<script type="text/javascript">
	$('#_pageSizeSelect').val('${baseQuery.pager.pageSize}');
</script>