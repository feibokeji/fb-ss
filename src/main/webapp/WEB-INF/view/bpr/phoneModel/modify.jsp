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
<!-- /bpr/phoneModel/modify.jsp -->
<body>
	<form id="modifyForm" name="modifyForm" method="post" action="${contextPath }/bpr/phoneModel/modifySave">
		<input type="hidden" id="modifyUid" name="uid" value="${phoneModel.uid }"/>
		<input type="hidden" id="modifyUbrandid" name="ubrandid" value="${phoneModel.ubrandid }"/>
		<input type="hidden" id="modifyUwarrantyid" name="uwarrantyid" value="${phoneModel.uwarrantyid }"/>
		<input type="hidden" name="drecorddateStr" value="${phoneModel.drecorddate }"/>
		<input type="hidden" id="modifyPhoneModelColorIds" name="phoneModelColorIds"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color:red;">*</span>品牌：</th>
				<td><input type="text" id="modifyCbrandname" name="cbrandname" class="validate[required]" value="${phoneModel.cbrandname }"/></td>
				<th><span style="color: red;">*</span>名称：</th>
				<td><input type="text" id="modifyCname" name="cname" class="l-text validate[required,funcCall[ajaxCname]]" value="${phoneModel.cname }"/></td>
			</tr>
			<tr>
				<th>运行内存(RAM)：</th>
				<td><input type="text" id="modifyCram" name="cram" class="l-text" value="${phoneModel.cram }"/></td>
				<th>存储内存(ROM)：</th>
				<td><input type="text" id="modifyCrom" name="crom" class="l-text" value="${phoneModel.crom }"/></td>
			</tr>
			<tr>
				<th>颜色：</th>
				<td colspan="3"><input type="text" id="modifyPhoneModelColor"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>进货价(元)：</th>
				<td><input type="text" id="modifyNcostprice" name="ncostprice" class="l-text validate[required,custom[number],funcCall[validateCostPrice]]" value="${phoneModel.ncostprice }"/></td>
				<th><span style="color: red;">*</span>销售价(元)：</th>
				<td><input type="text" id="modifyNretailprice" name="nretailprice" class="l-text validate[required,custom[number],funcCall[validateRetailPrice]]" value="${phoneModel.nretailprice }"/></td>
			</tr>
			<tr>
				<th>处理器(CPU)：</th>
				<td><input type="text" id="modifyCcpu" name="ccpu" class="l-text" value="${phoneModel.ccpu }"/></td>
				<th>屏幕：</th>
				<td><input type="text" id="modifyCscreen" name="cscreen" class="l-text" value="${phoneModel.cscreen }"/></td>
			</tr>
			<tr>
				<th>摄像头：</th>
				<td><input type="text" id="modifyCcamera" name="ccamera" class="l-text" value="${phoneModel.ccamera }"/></td>
				<th>电池：</th>
				<td><input type="text" id="modifyCbattery" name="cbattery" class="l-text" value="${phoneModel.cbattery }"/></td>
			</tr>
			<tr>
				<th>网络模式：</th>
				<td><input type="text" id="modifyCnetwork" name="cnetwork" class="l-text" value="${phoneModel.cnetwork }"/></td>
				<th><span style="color: red;">*</span>保修政策：</th>
				<td><input type="text" id="modifyWarranty" class="validate[required]"/></td>
			</tr>
			<tr>
				<th>亮点描述：</th>
				<td colspan="3"><textarea rows="2" cols="94" id="modifyChighlightdesc" name="chighlightdesc" class="l-textarea">${phoneModel.chighlightdesc }</textarea></td>
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
	<script type="text/javascript">
		var contextPath = '${contextPath}';
		var oldCname = '${phoneModel.cname}';
		var oldCbrandname = '${phoneModel.cbrandname}';
		var oldIwarrantyday = '${phoneModel.iwarrantyday}';
	</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/phoneModel/modify.js"></script>
</body>
</html>