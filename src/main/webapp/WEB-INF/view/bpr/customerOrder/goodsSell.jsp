<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品销售</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/customerOrder/goodsSell.jsp -->
<body>
	<div id="layout1">
		<div id="goodsDiv" position="center" title="商品列表">
			<div style="line-height: 24px;margin-left: 10px;margin-top: 5px;margin-bottom: 5px;">
				<span>名称：</span><input type="text" class="l-text"/>
				<span>助记码：</span><input type="text" class="l-text"/>
				<span>条形码：</span><input type="text" class="l-text"/>
				<input type="button" class="l-button" value="搜索"/>
				<input type="button" class="l-button" value="结账"/>
			</div>
			<div id="goodsMaingrid"></div>
		</div>
		<div id="customerDiv" position="right" title="客户信息">
			<div>
				<div style="line-height: 24px;margin-left: 10px;margin-top: 5px;margin-bottom: 5px;">
					<span>客户名称：</span><input type="text" class="l-text"/><br />
					<span>联系电话：</span><input type="text" class="l-text"/>
					<input type="button" class="l-button" value="搜索"/>
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
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customerOrder/goodsSell.js"></script>
</body>
</html>
