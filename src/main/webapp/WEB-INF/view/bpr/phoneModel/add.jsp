<?xml version="1.0" encoding="UTF-8" ?>
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
<!-- /bpr/phoneModel/add.jsp -->
<body>
	<form id="addForm" name="addForm" method="post" action="${contextPath }/bpr/phoneModel/addSave">
		<input type="hidden" id="addUbrandid" name="ubrandid"/>
		<input type="hidden" id="addUwarrantyid" name="uwarrantyid"/>
		<input type="hidden" id="addPhoneModelColorIds" name="phoneModelColorIds"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color:red;">*</span>品牌：</th>
				<td><input type="text" id="addCbrandname" name="cbrandname" class="validate[required]"/></td>
				<th><span style="color: red;">*</span>名称：</th>
				<td><input type="text" id="addCname" name="cname" class="l-text validate[required,funcCall[ajaxCname]]"/></td>
			</tr>
			<tr>
				<th>运行内存(RAM)：</th>
				<td><input type="text" id="addCram" name="cram" class="l-text"/></td>
				<th>存储内存(ROM)：</th>
				<td><input type="text" id="addCrom" name="crom" class="l-text"/></td>
			</tr>
			<tr>
				<th>颜色：</th>
				<td colspan="3"><input type="text" id="addPhoneModelColor"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>进货价(元)：</th>
				<td><input type="text" id="addNcostprice" name="ncostprice" class="l-text validate[required,custom[number],funcCall[validateCostPrice]]"/></td>
				<th><span style="color: red;">*</span>销售价(元)：</th>
				<td><input type="text" id="addNretailprice" name="nretailprice" class="l-text validate[required,custom[number],funcCall[validateRetailPrice]]"/></td>
			</tr>
			<tr>
				<th>处理器(CPU)：</th>
				<td><input type="text" id="addCcpu" name="ccpu" class="l-text"/></td>
				<th>屏幕：</th>
				<td><input type="text" id="addCscreen" name="cscreen" class="l-text"/></td>
			</tr>
			<tr>
				<th>摄像头：</th>
				<td><input type="text" id="addCcamera" name="ccamera" class="l-text"/></td>
				<th>电池：</th>
				<td><input type="text" id="addCbattery" name="cbattery" class="l-text"/></td>
			</tr>
			<tr>
				<th>网络模式：</th>
				<td><input type="text" id="addCnetwork" name="cnetwork" class="l-text"/></td>
				<th><span style="color: red;">*</span>保修政策：</th>
				<td><input type="text" id="addWarranty" class="validate[required]"/></td>
			</tr>
			<tr>
				<th>亮点描述：</th>
				<td colspan="3"><textarea rows="2" cols="94" id="addChighlightdesc" name="chighlightdesc" class="l-textarea"></textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" class="l-button" value="关闭" onclick="closeDialog()"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="l-button" value="保存" onclick="submitForm()"/>
				</td>
			</tr>
		</table>
	</form>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/phoneModel/add.js"></script>
</body>
</html>