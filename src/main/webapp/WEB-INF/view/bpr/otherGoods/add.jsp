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
<!-- /bpr/otherGoods/add.jsp -->
<body>
	<form id="addForm" name="addForm" method="post" action="${contextPath }/bpr/otherGoods/addSave">
		<input type="hidden" id="addUcategoryid" name="ucategoryid"/>
		<input type="hidden" id="addUbrandid" name="ubrandid"/>
		<input type="hidden" id="addUunitid" name="uunitid"/>
		<input type="hidden" id="addUwarrantyid" name="uwarrantyid"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color: red;">*</span>类别：</th>
				<td><input type="text" id="addCcategoryname" name="ccategoryname" class="validate[required]"/></td>
				<th><span style="color:red;">*</span>品牌：</th>
				<td><input type="text" id="addCbrandname" name="cbrandname" class="validate[required]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>编号：</th>
				<td><input type="text" id="addCno" name="cno" class="l-text validate[required,funcCall[ajaxCno]]"/></td>
				<th>条形码：</th>
				<td><input type="text" id="addCbarcode" name="cbarcode" class="l-text validate[funcCall[ajaxCbarcode]]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>名称：</th>
				<td><input type="text" id="addCname" name="cname" class="l-text validate[required,funcCall[ajaxCname]]"/></td>
				<th>全称：</th>
				<td><input type="text" id="addCfullname" name="cfullname" class="l-text validate[funcCall[ajaxCfullname]]"/></td>
			</tr>
			<tr>
				<th>助记码：</th>
				<td><input type="text" id="addCmnemoniccode" name="cmnemoniccode" class="l-text"/></td>
				<th>规格：</th>
				<td><input type="text" id="addCspecifications" name="cspecifications" class="l-text"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>单位：</th>
				<td><input type="text" id="addCunitname" name="cunitname" class="validate[required]"/></td>
				<th><span style="color: red;">*</span>进货价(元)：</th>
				<td><input type="text" id="addNcostprice" name="ncostprice" class="l-text validate[required,custom[number],funcCall[validateCostPrice]]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>销售价(元)：</th>
				<td><input type="text" id="addNretailprice" name="nretailprice" class="l-text validate[required,custom[number],funcCall[validateRetailPrice]]"/></td>
				<th><span style="color: red;">*</span>保修政策：</th>
				<td><input type="text" id="addWarranty" class="validate[required]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>积分：</th>
				<td><input type="text" id="addIintegral" name="iintegral" class="l-text validate[required,custom[integer]]"/></td>
				<th></th>
				<td></td>
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
	<script type="text/javascript" src="${contextPath}/common/js/base/ChinesePY.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/otherGoods/add.js"></script>
</body>
</html>