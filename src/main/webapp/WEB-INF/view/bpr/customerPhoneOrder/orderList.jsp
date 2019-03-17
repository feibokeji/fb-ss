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
<!-- /bpr/customerPhoneOrder/orderList.jsp -->
<body>
	<div>
		<!-- 标题 -->
		<div style="margin: 0 auto;text-align: center;line-height: 40px;">
			<c:if test="${itype == 0 }"><h2>已销售手机单据</h2></c:if>
			<c:if test="${itype == 1 }"><h2>已退货手机单据</h2></c:if>
		</div>
		<!-- 查询条件 -->
		<table style="margin: 0 auto;line-height: 40px;">
			<tr>
				<td align="right">客户名称：</td>
				<td align="left"><input type="text" id="searchCustomerNameInput" class="l-text"/></td>
				<c:if test="${itype==1 }">
				<td align="right">&nbsp;单据状态：</td>
				<td align="left"><input type="text" id="searchStatusInput" class="l-text"/></td>
				</c:if>
				<td align="right">&nbsp;开始日期：</td>
				<td align="left"><input type="text" id="searchDrecorddateStrMin" class="l-text"/></td>
				<td align="right">&nbsp;截止日期：</td>
				<td align="left"><input type="text" id="searchDrecorddateStrMax" class="l-text"/></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input type="button" class="l-button"  value="查询" onclick="searchOrderList()"/></td>
			</tr>
		</table>
		<!-- 工具栏 -->
		<div id="orderListToolBar"></div>
		<!-- 单据列表 -->
		<div id="orderListGrid"></div>
	</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';itype = ${itype};</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customerPhoneOrder/orderList.js"></script>
</body>
</html>
