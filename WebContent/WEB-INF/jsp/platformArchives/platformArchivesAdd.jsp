<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${_module_name}=》${_operate_name}</title>

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
					<td>名称：</td>
					<td><form:input path="name" readonly="${view_readonly}" /></td>

					<td>Logo：</td>
					<td>
						<div>
							<script id="logoUp" type="text/plain" name="logo"
								readonly='${view_readonly}'></script>
							<script type="text/javascript">
								var _editor = UE.getEditor('logoUp');

								_editor
										.ready(function() {
											_editor.hide();
											_editor.addListener(
													'beforeInsertImage',
													function(t, arg) {
														//将地址赋值给相应的input
														$("#logo").attr(
																"value",
																arg[0].src);
														//图片预览
														$("#preview").attr(
																"src",
																arg[0].src);
													})
											//侦听文件上传
											_editor
													.addListener(
															'afterUpfile',
															function(t, arg) {
																$("#file")
																		.attr(
																				"value",
																				_editor.options.filePath
																						+ arg[0].url);
																_editor
																		.setContent('${editData.logo}');
															})
										});
								//弹出图片上传的对话框
								function upImage() {
									var myImage = _editor
											.getDialog("insertimage");
									myImage.open();
								}
							</script>
						</div> <form:input path="logo" readonly="${view_readonly}" onclick="upImage()" title="点击上传图片" style="background:url(/mt/resources/ueditor/themes/default/images/arrow_up.png) no-repeat right center;cursor:pointer;" /></td>

					<td>平台上线时间：</td>
					<td><form:input path="onlineTime" readonly="${view_readonly}" /></td>

					<td>法人代表：</td>
					<td><form:input path="legalRepresentative"
							readonly="${view_readonly}" /></td>

				</tr>
				<tr>


					<td>注册资本：</td>
					<td><form:input path="registCaptial"
							readonly="${view_readonly}" /></td>

					<td>发布人：</td>
					<td><form:input path="publisher" readonly="${view_readonly}" /></td>

					<td>浏览数量：</td>
					<td><form:input path="borrowCount" readonly="${view_readonly}" /></td>


					<td>注册地址：</td>
					<td><form:input path="registAddr" readonly="${view_readonly}" /></td>



				</tr>

				<tr>
					<td>平台简介：</td>
					<td colspan="7"><form:textarea path="plantformIntroduction" readonly="${view_readonly}"
							cols="138" rows="3" /></td>

				</tr>
				<!-- <tr>
					<td>图片：</td>
					<td colspan="7"><input type="file" value="选择文件" > </td>

				</tr> -->
				<tr>
					<td>正文：</td>
				</tr>
				<tr>
					<td colspan="8"><div>
							<script id="editor" type="text/plain" name="content"
								readonly='${view_readonly}'
								style="width: 1024px; height: 350px;"></script>
							<script type="text/javascript">
								var ue = UE.getEditor('editor');
								ue.ready(function() {
									ue.setContent('${editData.content}');
								});
							</script>
						</div></td>
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