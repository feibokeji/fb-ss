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
<!-- /bpr/supplier/financial/goods/receivable.jsp -->
<body>
	<div>
		<!-- 标题 -->
		<div style="margin: 0 auto;text-align: center;line-height: 40px;">
			<c:if test="${ctype eq 'AR' }"><h2>供应商-商品类-应收款项</h2></c:if>
			<c:if test="${ctype eq 'AP' }"><h2>供应商-商品类-应付款项</h2></c:if>
		</div>
		<!-- 查询条件 -->
		<table style="margin: 0 auto;line-height: 40px;">
			<tr>
				<td align="right">&nbsp;供应商：</td>
				<td align="left"><input type="text" class="l-text" id="searchSupplierInput"/></td>
				<td align="right">&nbsp;单据编号：</td>
				<td align="left"><input type="text" class="l-text" id="searchOrderNoInput"/></td>
				<td align="right">&nbsp;状态：</td>
				<td align="left"><input type="text" class="l-text" id="searchIstatusInput"/></td>
				<td align="right">&nbsp;开始日期：</td>
				<td align="left"><input type="text" class="l-text" id="searchDrecorddateStrMinInput" /></td>
				<td align="right">&nbsp;截止日期：</td>
				<td align="left"><input type="text" class="l-text" id="searchDrecorddateStrMaxInput"/></td>
				<td>&nbsp;&nbsp;</td>
				<td><input type="button" class="l-button"  value="查询" onclick="search()"/></td>
			</tr>
		</table>
		<!-- 工具栏 -->
		<div id="receivableToolBar"></div>
		<!-- 列表 -->
		<div id="receivableGrid"></div>
	</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';var ctype = '${ctype}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/supplier/financial/goods/receivable.js"></script>
</body>
</html>
