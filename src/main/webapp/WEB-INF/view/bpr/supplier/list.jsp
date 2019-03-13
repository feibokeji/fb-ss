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
<!-- /bpr/supplier/list.jsp -->
<body>
	<form id="searchTable">
		<table class="search_table">
			<tr>
				<td>供应商名称：</td>
				<td><input type="text" class="l-text" id="searchCname"/></td>
				<td>固定电话：</td>
				<td><input type="text" class="l-text" id="searchCfixedtelephone"/></td>
				<td>联系人：</td>
				<td><input type="text" class="l-text" id="searchClinkman"/></td>
				<td>联系电话：</td>
				<td><input type="text" class="l-text validate[custom[phone]]" id="searchCcontactnumber"/></td>
			</tr>
			<tr>
				<td>微信：</td>
				<td><input type="text" class="l-text" id="searchCwechat"/></td>
				<td>银&nbsp;行&nbsp;卡&nbsp;&nbsp;号：</td>
				<td><input type="text" class="l-text" id="searchCbandcardnumber"/></td>
				<td>账期(天数)：</td>
				<td><input type="text" class="l-text validate[custom[integer]]" id="searchIpaymentdaysMin"/></td>
				<td align="center">-</td>
				<td><input type="text" class="l-text validate[custom[integer]]" id="searchIpaymentdaysMax"/></td>
			</tr>
			<tr>
				<td>记录日期：</td>
				<td><input type="text" class="l-text" id="searchDrecorddateMin"/></td>
				<td align="center">-</td>
				<td><input type="text" class="l-text" id="searchDrecorddateMax"/></td>
				<td><input type="button" class="l-button" value="查询" onclick="searchSupplier()"/></td>
			</tr>
		</table>
	</form>
	<div id="supplierToolBar"></div>
    <div id="maingrid"></div>
  	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/supplier/list.js"></script>
</body>
</html>