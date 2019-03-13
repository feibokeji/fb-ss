<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改客户信息</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/customer/modifyCustomer.jsp -->
<body>
	<form id="modifyForm" name="modifyForm" method="post" action="${contextPath }/bpr/customer/modifyCustomerSave">
		<input type="hidden" name="uid" value="${customer.uid }"/>
		<input type="hidden" id="ucustomertypeid" name="ucustomertypeid" value="${customer.ucustomertypeid }"/>
		<input type="hidden" name="uuserid" value="${customer.uuserid }"/>
		<input type="hidden" name="udeptid" value="${customer.udeptid }"/>
		<input type="hidden" name="drecorddateStr" value="${customer.drecorddate }"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color: red;">*</span>客户类型：</th>
				<td><input type="text" id="modifyCcustomerTypeName" name="ccustomertypename" class="l-text" value="${customer.ccustomertypename }"/></td>
				<th><span style="color:red;">*</span>客户名称：</th>
				<td><input type="text" id="modifyCname" name="cname" class="l-text validate[required,funcCall[ajaxCName]]" value="${customer.cname }"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>性别：</th>
				<td><input type="radio" name="isex" value="1"/>男<input type="radio" name="isex" value="0"/>女</td>
				<th>联系电话：</th>
				<td><input type="text" id="modifyCcontactnumber" name="ccontactnumber" class="l-text validate[custom[phone]]" value="${customer.ccontactnumber }"/></td>
			</tr>
			<tr>
				<th>微信：</th>
				<td><input type="text" id="modifyCwechat" name="cwechat" class="l-text" value="${customer.cwechat }"/></td>
				<th>生日：</th>
				<td><input type="text" id="modifyDbirthdayStr" name="dbirthdayStr" value="${customer.dbirthdayStr }"/></td>
			</tr>
			<tr>
				<th>积分：</th>
				<td><input type="text" id="modifyIintegral" name="iintegral" class="l-text validate[custom[integer]]" value="${customer.iintegral }"/></td>
				<th><span style="color: red;">*</span>账期(天数)：</th>
				<td><input type="text" id="modifyIpaymentdays" name="ipaymentdays" class="l-text validate[required,custom[integer]]" value="${customer.ipaymentdays }"/></td>
			</tr>
			<tr>
				<th>地址：</th>
				<td colspan="3"><textarea rows="2" cols="72" id="modifyCaddress" name="caddress" class="l-textarea">${customer.caddress }</textarea></td>
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
	<script type="text/javascript">var contextPath = '${contextPath}';var oldCname = '${customer.cname}';var oldIsex = ${customer.isex};var oldCustomerTypeName = '${customer.ccustomertypename}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customer/modifyCustomer.js"></script>
</body>
</html>