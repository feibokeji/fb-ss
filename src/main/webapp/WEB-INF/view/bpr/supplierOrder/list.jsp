<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<!-- /bpr/supplierOrder/list.jsp -->
<body>
	<div class="l-clear"></div>
	<form id="searchTable">
		<input type="hidden" id="searchUsupplierid"/>
		<input type="hidden" id="searchItype"/>
		<input type="hidden" id="searchIstatus"/>
		<table class="search_table">
			<tr>
				<td>供应商名称：</td>
				<td><input type="text" class="l-text" id="searchCsuppliername"/></td>
				<td>单据编号：</td>
				<td><input type="text" class="l-text" id="searchCno"/></td>
				<td>单据类型：</td>
				<td><input type="text" class="l-text" id="searchItypeStr"/></td>
				<td>单据状态：</td>
				<td><input type="text" class="l-text" id="searchIstatusStr"/></td>
			</tr>
			<tr>
				<td>记录日期：</td>
				<td><input type="text" class="l-text" id="searchDrecorddateStrMin"/></td>
				<td align="center">-</td>
				<td><input type="text" class="l-text" id="searchDrecorddateStrMax"/></td>
				<td><input type="button" class="l-button" value="查询" onclick="searchSupplierOrder()"/></td>
			</tr>
		</table>
	</form>
    <div id="maingrid"></div>
  	<div style="display:none;"></div>
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
	<script type="text/javascript" src="${contextPath}/common/js/bpr/supplierOrder/list.js"></script>
</body>
</html>