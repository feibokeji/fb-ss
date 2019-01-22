<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>客户信息</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/customer/list.jsp -->
<body>
	<div id="layout1">
		<div position="left" title="客户类型">
			<div id="customerTypeMaingrid"></div>
		</div>
		<div position="center" title="客户信息" style="overflow: scroll;">
			<form id="searchCustomerForm">
				<input type="hidden" id="searchCustomerTypeUid"/>
				<table class="search_table">
					<tr>
						<td>客户类型：</td>
						<td><input type="text" id="searchCustomerTypeCname" class="l-text" disabled="disabled"/></td>
						<td>客户名称：</td>
						<td><input type="text" id="searchCname" class="l-text"/></td>
						<td>性别：</td>
						<td>
							<select id="searchIsex" class="l-text">
								<option value="-1">-请选择-</option>
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</td>
						<td>联系电话：</td>
						<td><input type="text" id="searchCcontactnumber" class="l-text validate[custom[phone]]"/></td>
						<td>微信：</td>
						<td><input type="text" id="searchCwechat" class="l-text"/></td>
					</tr>
					<tr>
						<td>生日：</td>
						<td><input type="text" id="searchDbirthdayMin"/></td>
						<td align="center">-</td>
						<td><input type="text" id="searchDbirthdayMax"/></td>
						<td>积分：</td>
						<td><input type="text" id="iintegralMin" class="l-text validate[custom[integer]]"/></td>
						<td align="center">-</td>
						<td><input type="text" id="iintegralMax" class="l-text validate[custom[integer]]"/></td>
					</tr>
					<tr>
						<td>账期(天数)：</td>
						<td><input type="text" id="ipaymentdaysMin" class="l-text validate[custom[integer]]"/></td>
						<td align="center">-</td>
						<td><input type="text" id="ipaymentdaysMax" class="l-text validate[custom[integer]]"/></td>
						<td>记录日期：</td>
						<td><input type="text" id="drecorddateMin"/></td>
						<td align="center">-</td>
						<td><input type="text" id="drecorddateMax"/></td>
						<td colspan="2"><input type="button" class="l-button" value="查询" onclick="searchCustomer()"/></td>
					</tr>
				</table>
			</form>
			<div id="customerMaingrid"></div>
		</div>
	</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customer/list.js"></script>
</body>
</html>