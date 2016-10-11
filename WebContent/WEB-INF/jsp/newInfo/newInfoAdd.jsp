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


<!-- ueditor -->
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/resources/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/resources/ueditor/ueditor.all.min.js">
	
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
					<td>标题：</td>
					<td><form:input path="title" readonly='${view_readonly}'/></td>
					<td>摘要：</td>
					<td><form:input path="summary" readonly='${view_readonly}'/></td>



					<td>类别：</td>
					<td><form:input path="category.name"
							onclick="openNewCategorySelect(path)" readonly="true" disabled="${view_readonly}"/> <form:hidden
							path="category.id" /></td>

					<td>信息来源：</td>
					<td><form:input path="source" readonly='${view_readonly}'/></td>



				</tr>
				<tr>

					<td>发布者：</td>
					<td><form:input path="publisher" readonly='${view_readonly}'/></td>

					<td>浏览量：</td>
					<td><form:input path="borrowCount" readonly='${view_readonly}'/></td>

					<td>创建时间</td>
					<td><form:input path="createdTime" class="Wdate"
							readonly="true" /></td>
					<td>最后修改时间</td>
					<td><form:input path="lastModifyTime" class="Wdate"
							readonly="true" /></td>

				</tr>
				<tr >
					<td >正文：</td>
				</tr>
			
				<tr>
					<td colspan="8"><div>
							<script id="editor" type="text/plain" name="content" readonly='${view_readonly}'
								style="width: 1024px; height: 500px;"></script>
							<script type="text/javascript">
								var ue = UE.getEditor('editor');
								ue.ready(function(){
									ue.setContent('${editData.content}');
								});
								
							</script>
						</div></td>
				</tr>
				<tr>
					<td colspan="4"><c:if test="${!view_readonly}"><input type="submit" value="保存"  ></c:if></td>

					<td colspan="4"><c:if test="${!view_readonly}"><input type="reset" value="重置" ></c:if></td>

				</tr>
			</table>
		</form:form>
	</div>
	<div class="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>