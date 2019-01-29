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
<!-- /bpr/otherGoods/modify.jsp -->
<body>
	<form id="modifyForm" name="modifyForm" method="post" action="${contextPath }/bpr/otherGoods/modifySave">
		<input type="hidden" name="uid" value="${otherGoods.uid }"/>
		<input type="hidden" id="modifyUcategoryid" name="ucategoryid" value="${otherGoods.ucategoryid }"/>
		<input type="hidden" id="modifyUbrandid" name="ubrandid" value="${otherGoods.ubrandid }"/>
		<input type="hidden" id="modifyUunitid" name="uunitid" value="${otherGoods.uunitid }"/>
		<input type="hidden" id="modifyUwarrantyid" name="uwarrantyid" value="${otherGoods.uwarrantyid }"/>
		<input type="hidden" name="uuserid" value="${otherGoods.uuserid }"/>
		<input type="hidden" name="udeptid" value="${otherGoods.udeptid }"/>
		<input type="hidden" name="drecorddateStr" value="${otherGoods.drecorddate }"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color: red;">*</span>类别：</th>
				<td><input type="text" id="modifyCcategoryname" name="ccategoryname" class="validate[required]"/></td>
				<th><span style="color:red;">*</span>品牌：</th>
				<td><input type="text" id="modifyCbrandname" name="cbrandname" class="validate[required]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>编号：</th>
				<td><input type="text" id="modifyCno" name="cno" class="l-text validate[required,funcCall[ajaxCno]]" value="${otherGoods.cno }"/></td>
				<th>条形码：</th>
				<td><input type="text" id="modifyCbarcode" name="cbarcode" class="l-text validate[funcCall[ajaxCbarcode]]" value="${otherGoods.cbarcode }"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>名称：</th>
				<td><input type="text" id="modifyCname" name="cname" class="l-text validate[required,funcCall[ajaxCname]]" value="${otherGoods.cname }"/></td>
				<th>全称：</th>
				<td><input type="text" id="modifyCfullname" name="cfullname" class="l-text validate[funcCall[ajaxCfullname]]" value="${otherGoods.cfullname }"/></td>
			</tr>
			<tr>
				<th>助记码：</th>
				<td><input type="text" id="modifyCmnemoniccode" name="cmnemoniccode" class="l-text" value="${otherGoods.cmnemoniccode }"/></td>
				<th>规格：</th>
				<td><input type="text" id="modifyCspecifications" name="cspecifications" class="l-text" value="${otherGoods.cspecifications }"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>单位：</th>
				<td><input type="text" id="modifyCunitname" name="cunitname" class="validate[required]"/></td>
				<th><span style="color: red;">*</span>进货价(元)：</th>
				<td><input type="text" id="modifyNcostprice" name="ncostprice" class="l-text validate[required,custom[number],funcCall[validateCostPrice]]" value="${otherGoods.ncostprice }"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>销售价(元)：</th>
				<td><input type="text" id="modifyNretailprice" name="nretailprice" class="l-text validate[required,custom[number],funcCall[validateRetailPrice]]" value="${otherGoods.nretailprice }"/></td>
				<th><span style="color: red;">*</span>保修政策：</th>
				<td><input type="text" id="modifyWarranty" class="validate[required]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>积分：</th>
				<td><input type="text" id="modifyIintegral" name="iintegral" class="l-text validate[required,custom[integer]]" value="${otherGoods.iintegral }"/></td>
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
	<script type="text/javascript">
		var contextPath = '${contextPath}';
		var oldCno = '${otherGoods.cno}';
		var oldCbarcode = '${otherGoods.cbarcode }';
		var oldCname = '${otherGoods.cname}';
		var oldCfullname = '${otherGoods.cfullname }';
		var oldCcategoryname = '${otherGoods.ccategoryname}';
		var oldCbrandname = '${otherGoods.cbrandname}';
		var oldCunitname = '${otherGoods.cunitname}';
		var oldIwarrantyday = '${otherGoods.iwarrantyday}';
	</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/ChinesePY.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/otherGoods/modify.js"></script>
</body>
</html>