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
<!-- /bpr/counterPartsPhoneOrder/hasIn.jsp -->
<body>
	<form id="searchTable">
		<table class="search_table">
			<tr>
				<td>同行信息：</td>
				<td><input type="text" id="counterparts_combobox" class="l-text"/></td>
				<td>品牌信息：</td>
				<td><input type="text" id="brand_combobox" class="l-text"/></td>
				<td>手机型号：</td>
				<td><input type="text" id="cphonemodelname" class="l-text"/></td>
			</tr>
			<tr>
				<td>手机串号(IMEI)：</td>
				<td><input type="text" id="imei" class="l-text"/></td>
				<td>记录日期：</td>
				<td><input type="text" class="l-text" id="drecorddateStrMin"/></td>
				<td align="center">-</td>
				<td><input type="text" class="l-text" id="drecorddateStrMax"/></td>
				<td><input type="button" class="l-button" value="查询" onclick="searchOrder()"/></td>
			</tr>
		</table>
	</form>
	<div id="hasInToolBar"></div>
	<div id="hasInMainGrid"></div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/main.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/counterPartsPhoneOrder/hasIn.js"></script>
</body>
</html>