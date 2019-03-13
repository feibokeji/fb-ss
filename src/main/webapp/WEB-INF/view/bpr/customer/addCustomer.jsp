<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增客户信息</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/customer/addCustomer.jsp -->
<body>
	<form id="addForm" name="addForm" method="post" action="${contextPath }/bpr/customer/addCustomerSave">
		<input type="hidden" id="addUcustomerTypeId" name="ucustomertypeid"/>
		<table class="add_update_table">
			<tr>
				<th><span style="color: red;">*</span>客户类型：</th>
				<td><input type="text" id="addCcustomerTypeName" name="ccustomertypename" class="l-text validate[required]"/></td>
				<th><span style="color:red;">*</span>客户名称：</th>
				<td><input type="text" id="addCname" name="cname" class="l-text validate[required,funcCall[ajaxCName]]]"/></td>
			</tr>
			<tr>
				<th><span style="color: red;">*</span>性别：</th>
				<td><input type="radio" name="isex" value="1" checked="checked"/>男<input type="radio" name="isex" value="0"/>女</td>
				<th>联系电话：</th>
				<td><input type="text" id="addCcontactnumber" name="ccontactnumber" class="l-text validate[custom[phone]]"/></td>
			</tr>
			<tr>
				<th>微信：</th>
				<td><input type="text" id="addCwechat" name="cwechat" class="l-text"/></td>
				<th>生日：</th>
				<td><input type="text" id="addDbirthday" name="dbirthday"/></td>
			</tr>
			<tr>
				<th>积分：</th>
				<td><input type="text" id="addIintegral" name="iintegral" class="l-text validate[custom[integer]]"/></td>
				<th><span style="color: red;">*</span>账期(天数)：</th>
				<td><input type="text" id="addIpaymentdays" name="ipaymentdays" class="l-text validate[required,custom[integer]]" value="0"/></td>
			</tr>
			<tr>
				<th>地址：</th>
				<td colspan="3"><textarea rows="2" cols="72" id="addCaddress" name="caddress" class="l-textarea"></textarea></td>
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
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customer/addCustomer.js"></script>
</body>
</html>