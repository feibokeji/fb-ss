<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden">
<head>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/paymentMethod/modify.jsp -->
<body>
	<form id="modifyForm" name="modifyForm" method="post" action="${contextPath }/bpr/paymentMethod/modifySave">
		<input type="hidden" name="uid" value="${paymentMethod.uid }"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color: red;">*</span>名称：</th>
				<td><input type="text" id="modifyCname" name="cname" class="l-text validate[required,funcCall[ajaxCname]]" value="${paymentMethod.cname }"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>代码：</th>
				<td><input type="text" id="modifyCcode" name="ccode" class="l-text validate[required,funcCall[ajaxCcode]]" value="${paymentMethod.ccode }"/></td>
			</tr>
			<tr>
				<th>描述：</th>
				<td><textarea rows="2" cols="72" id="modifyCdesc" name="cdesc" class="l-textarea">${paymentMethod.cdesc }</textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" class="l-button" value="关闭" onclick="closeDialog()"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="l-button" value="保存" onclick="submitForm()"/>
				</td>
			</tr>
		</table>
	</form>
  	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';var oldCname = '${paymentMethod.cname}';var oldCcode = '${paymentMethod.ccode}'</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/paymentMethod/modify.js"></script>
</body>
</html>