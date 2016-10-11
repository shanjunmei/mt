<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${_module_name}=》${_operate_name}</title>

<!-- ueditor -->
<script type="text/javascript" charset="utf-8" src="<%=path%>/resources/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"	src="<%=path%>/resources/ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- end ueditor -->
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
					<td>标号：</td>
					<td><form:input path="name" readonly="${view_readonly}" /></td>

					<td>标名：</td>
					<td><form:input path="name" readonly="${view_readonly}" /></td>

					<td>详情URL：</td>
					<td><form:input path="detailUrl" readonly="${view_readonly}" /></td>

					<td>借款金额：</td>
					<td><form:input path="amount" readonly="${view_readonly}" /></td>





				</tr>

				<tr>
					<td>年华利率：</td>
					<td><form:input path="apr" readonly="${view_readonly}" /></td>


					<td>借款期限：</td>
					<td><form:input path="limit" readonly="${view_readonly}" /></td>

					<td>还款方式：</td>
					<td><form:input path="repayType" readonly="${view_readonly}" /></td>


					<td>已投金额：</td>
					<td><form:input path="accountYes" readonly="${view_readonly}" /></td>

				</tr>
				<tr>

					<td>起投金额：</td>
					<td><form:input path="accountMin" readonly="${view_readonly}" /></td>



					<td>发标人用户名：</td>
					<td><form:input path="username" readonly="${view_readonly}" /></td>


					<td>添加时间：</td>
					<td><form:input path="addTime" readonly="${view_readonly}" /></td>


					<td>初审时间：</td>
					<td><form:input path="verifyTime" readonly="${view_readonly}" /></td>


				</tr>
				<tr>
					<td>审核通过时间：</td>
					<td><form:input path="passedTime" readonly="${view_readonly}" /></td>


					<td>标类型：</td>
					<td><form:input path="bidType" readonly="${view_readonly}" /></td>


					<td>标状态：</td>
					<td><form:input path="status" readonly="${view_readonly}" /></td>


					<td>奖励：</td>
					<td><form:input path="reward" readonly="${view_readonly}" /></td>

				</tr>
				<tr>
					<td>是否抵押：</td>
					<td><form:input path="isMortgage" readonly="${view_readonly}" /></td>


					<td>是否担保：</td>
					<td><form:input path="isGuarantee" readonly="${view_readonly}" /></td>


					<td>是否秒标：</td>
					<td><form:input path="isSecBid" readonly="${view_readonly}" /></td>


					<td>是否债权转让：</td>
					<td><form:input path="isAssignOfDebt"
							readonly="${view_readonly}" /></td>


				</tr>

				<tr>
					<td colspan="4"><c:if test="${!view_readonly}">
							<input type="submit" value="保存">
						</c:if></td>

					<td colspan="4"><c:if test="${!view_readonly}">
							<input type="reset" value="重置">
						</c:if></td>

				</tr>
			</table>
		</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>