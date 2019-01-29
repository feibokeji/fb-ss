<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增功能模块</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/module/add.jsp -->
<body>
	<form id="addModuleForm" name="addModuleForm" method="post" action="${contextPath }/bpr/module/addSave">
		<input type="hidden" id="timeToken" name="timeToken" value="${timeToken }"/>
		<table class="add-table">
			<tr>
				<th width="11%">类别:&nbsp;</th>
				<td width="22%">
					&nbsp;
					<select id="ctype" name="ctype" class="i-text-120 validate[required,funcCall[checkType]]">
						<option value="BPR">BPR</option>
						<option value="SELL">SELL</option>
					</select>
				</td>
				<th width="11%">代码:&nbsp;</th>
				<td width="22%">&nbsp;<input type="text" id="ccode" name="ccode" class="i-text-120 validate[required,maxSize[30],custom[onlyLetterSp],funcCall[checkCode]]"/></td>
				<th width="11%">名称:&nbsp;</th>
				<td width="22%">&nbsp;<input type="text" id="cname" name="cname" class="i-text-120 validate[required,maxSize[20],funcCall[checkName]]"/></td>
			</tr>
			<tr>
				<th>父级代码:&nbsp;</th>
				<td>&nbsp;<input type="text" id="cparent" name="cparent" value="${parentModule == null ? '' : parentModule.ccode }" class="i-text-120 validate[funcCall[checkParentCode]]"/></td>
				<th>级别:&nbsp;</th>
				<td>&nbsp;<input type="text" id="ilevel" name="ilevel" value="${parentModule == null ? 1 : (parentModule.ilevel + 1)}" class="i-text-120 validate[required,funcCall[checkLevel]]"/></td>
				<th>序号:&nbsp;</th>
				<td>&nbsp;<input type="text" id="isort" name="isort" class="i-text-120 validate[required,custom[onlyNumberSp]]"/></td>
			</tr>
			<tr>
				<th>代码路径:&nbsp;</th>
				<td colspan="5">&nbsp;<input type="text" id="ccodepath" name="ccodepath" value="${parentModule == null ? '' : parentModule.ccodepath}" class="i-text-360 validate[required,funcCall[checkCodePath]]"/></td>
			</tr>
			<tr>
				<th>访问地址:&nbsp;</th>
				<td colspan="5">&nbsp;<input type="text" id="caddr" name="caddr" class="i-text-360"/></td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<input type="button" value="保存" class="l-button" onclick="submitModuleForm()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="关闭" class="l-button" onclick="closeDialog()"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var contextPath = '${contextPath}';
		var parentType = "${parentModule == null ? '' : parentModule.ctype}";
		var parentCode = "${parentModule == null ? '' : parentModule.ccode}";
		var parentCodePath = "${parentModule == null ? '' : parentModule.ccodepath}";
		var defaultLevel = ${parentModule == null ? 1 : (parentModule.ilevel + 1)};
		var msg = "${msg}";
	</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/module/add.js"></script>
</body>
</html>