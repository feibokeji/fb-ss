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
<!-- /bpr/customerPhoneOrder/phoneSell.jsp -->
<body>
	<div id="phoneSellMainLayout">
		<div id="phoneDiv" position="center" title="手机列表">
			<div style="line-height: 24px;margin-left: 10px;margin-top: 5px;margin-bottom: 5px;">
				<table style="line-height: 30px;">
					<tr>
						<td align="right">手机串号(IMEI)：</td>
						<td align="left"><input type="text" class="l-text" id="searchIMEI"/></td>
						<td align="right">品牌：</td>
						<td align="left"><input type="text" class="l-text" id="searchBrand"/></td>
						<td align="right">手机型号：</td>
						<td align="left"><input type="text" class="l-text" id="searchCphonemodelname"/></td>
						<td align="right">颜色：</td>
						<td align="left"><input type="text" class="l-text" id="searchCcolorname"/></td>
					</tr>
					<tr>
						<td><input type="button" class="l-button" value="搜索" onclick="searchPhoneOrder()"/></td>
						<td><input type="button" class="l-button" value="结账" onclick="settleAccounts()"/></td>
					</tr>
				</table>
			</div>
			<div id="phoneMaingrid"></div>
	    </div>
	    <div id="customerDiv" position="right" title="客户信息">
	    	<div>
				<div style="line-height: 24px;margin-left: 10px;margin-top: 5px;margin-bottom: 5px;">
					<span>客户名称：</span><input type="text" class="l-text" id="searchCustomerNameInput"/><br />
					<span>联系电话：</span><input type="text" class="l-text" id="searchCustomerContactnumberInput"/>
					<input type="button" class="l-button" value="搜索" onclick="searchCustomer()"/>
				</div>
				<div id="customerMaingrid"></div>
			</div>
		</div>
    </div>
  	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customerPhoneOrder/phoneSell.js"></script>
</body>
</html>