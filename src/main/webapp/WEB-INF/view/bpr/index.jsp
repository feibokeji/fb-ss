<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>飞博科技管理平台-首页</title>
<link type="image/x-icon" href="${contextPath}/common/images/favicon.ico" rel="shortcut icon" />
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- index.jsp -->
<body>
	<div id="pageloading"></div>
	<div id="topmenu" class="l-topmenu">
		<div class="l-topmenu-logo"><img src="${contextPath }/common/images/logo.png"></img>&nbsp;&nbsp;飞博科技管理平台</div>
		<div class="l-topmenu-welcome">
			<span class="space">[${sessionContainer.user.cname}]您好！欢迎来到飞博科技!</span>
			<a href="javascript:logout()" class="l-link2">退出</a>
		</div>
	</div>
	<div id="layout1" style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
		<div position="left" title="菜单" id="accordion1">
			<div title="基础信息" class="l-scroll">
				<ul class="m-ul">
					<li><t:module code="COMPANYVIEW"><a href="javascript:openPage('companyInfo','公司信息','http://www.baidu.com')">公司信息</a></t:module></li>
					<li><a href="javascript:openPage('userInfo','账户信息','http://www.baidu.com')">账户信息</a></li>
					<li><a href="javascript:openPage('updatePassword','修改密码','http://www.baidu.com')">修改密码</a></li>
				</ul>
			</div>
			<div title="系统管理" class="l-scroll">
				<ul class="m-ul">
					<li><a href="javascript:openPage('moduleInfo','功能模块','${contextPath }/bpr/module/list')">功能模块</a></li>
					<li><a href="javascript:openPage('moduleGroupInfo','功能模块组','http://www.baidu.com')">功能模块组</a></li>
					<li><a href="javascript:openPage('companyList','公司列表','http://www.baidu.com')">公司列表</a></li>
					<li><a href="javascript:openPage('userList','账户列表','http://www.baidu.com')">账户列表</a></li>
					<li><a href="javascript:openPage('logInfo','日志管理','http://www.baidu.com')">日志管理</a></li>
				</ul>
			</div>
			<div title="可爱雪门店" class="l-scroll">
				<ul class="m-ul">
					<li><a href="javascript:openPage('lovelysnowCategory','可爱雪-类别','${contextPath }/bpr/lovelysnow/category')">类别</a></li>
					<li><a href="javascript:openPage('lovelysnowMaterial','可爱雪-物料','${contextPath }/bpr/lovelysnow/material')">物料</a></li>
					<li><a href="javascript:openPage('lovelysnowProduct','可爱雪-产品','${contextPath }/bpr/lovelysnow/product')">产品</a></li>
					<li><a href="javascript:openPage('lovelysnowProcurement','可爱雪-物料采购','${contextPath }/bpr/lovelysnow/procurement')">物料采购</a></li>
				</ul>
			</div>
			<div title="可爱雪账务" class="l-scroll">
				<ul class="m-ul">
					<li><a href="javascript:openPage('lovelysnowAccounting','可爱雪-账务类型','${contextPath }/bpr/lovelysnow/accountType')">账务类型</a></li>
					<li><a href="javascript:openPage('lovelysnowDisbursement','可爱雪-支出单','${contextPath }/bpr/lovelysnow/lovelysnowDisbursement')">支出单</a></li>
					<li><a href="javascript:openPage('lovelysnowIncome','可爱雪-收入单','${contextPath }/bpr/lovelysnow/lovelysnowIncome')">收入单</a></li>
					<li><a href="javascript:openPage('lovelysnowBorrowing','可爱雪-借款单','${contextPath }/bpr/lovelysnow/lovelysnowBorrowing')">借款单</a></li>
					<li><a href="javascript:openPage('lovelysnowInvestment','可爱雪-投资单','${contextPath }/bpr/lovelysnow/lovelysnowInvestment')">投资单</a></li>
					<li><a href="javascript:openPage('lovelysnowLoss','可爱雪-报损单','${contextPath }/bpr/lovelysnow/lovelysnowLoss')">报损单</a></li>
				</ul>
			</div>
		</div>
		<div position="center" id="framecenter">
			<div tabid="home" title="我的主页" style="height: 300px">
				<iframe frameborder="0" name="home" id="home" src="${contextPath }/bpr/home"></iframe>
			</div>
		</div>
	</div>
	<div style="height: 32px; line-height: 32px; text-align: center;">Copyright © 2015-2017 内乡县城关镇飞博科技</div>
	<div style="display: none"></div>
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/main.js"></script>
</body>
</html>