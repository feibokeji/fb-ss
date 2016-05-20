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
			<a href="javascript:f_User_Info()" class="l-link2">账户信息</a>
			<a href="javascript:f_Mode_Password()" class="l-link2">修改密码</a>
			<a href="javascript:logout()" class="l-link2">退出</a>
		</div>
	</div>
	<div id="modifyPasswordDiv" style="display:none;">
		<input type="hidden" id="uid" value="${sessionContainer.user.uid }"/>
		新&nbsp;&nbsp;密&nbsp;码:<input type="password" id="password1"/><br/><br/>
		确认密码:<input type="password" id="password2"/>
	</div>
	<div id="layout1" style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
		<div position="left" title="菜单" id="accordion1">
			<t:module code="SYSTEMMANAGEMENT">
			<div title="系统管理" class="l-scroll">
				<ul class="m-ul">
					<t:module code="SYSTEMMODULE">
					<li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('moduleInfo','功能模块','${contextPath }/bpr/module/list')">功能模块</a></li>
					</t:module>
					<t:module code="SYSTEMMODULEGROUP">
					<li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('moduleGroupInfo','功能模块组','${contextPath }/bpr/moduleGroup/list')">功能模块组</a></li>
					</t:module>
					<t:module code="SYSTEMUSER"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('userList','账户列表','${contextPath }/bpr/user/list')">账户列表</a></li></t:module>
					<t:module code="SYSTEMROLE"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('roleList','角色列表','${contextPath }/bpr/role/list')">角色列表</a></li></t:module>
					<t:module code="SYSTEMLOG"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('logInfo','日志管理','${contextPath }/bpr/log/list')">日志管理</a></li></t:module>
				</ul>
			</div>
			</t:module>
			<t:module code="LOVELYSTORES">
			<div title="可爱雪门店" class="l-scroll">
				<ul class="m-ul">
					<t:module code="LOVELYSTORESCATEGORY"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowCategory','可爱雪-类别','${contextPath }/bpr/lovelysnow/category')">类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</a></li></t:module>
					<t:module code="LOVELYSTORESMATERAIL"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowMaterial','可爱雪-物料','${contextPath }/bpr/lovelysnow/material')">物&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;料</a></li></t:module>
					<t:module code="LOVELYSTORESPROCUREMENT"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowProcurement','可爱雪-物料入库','${contextPath }/bpr/lovelysnow/procurement?type=add')">物料入库</a></li></t:module>
					<t:module code="LOVELYSTORESMATERIALCHECK"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowMaterialCheck','可爱雪-物料盘点','${contextPath }/bpr/lovelysnow/materialCheck?type=add')">物料盘点</a></li></t:module>
					<t:module code="LOVELYSTORESMATERIALINVENTORY"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowMaterialInventory','可爱雪-物料库存','${contextPath }/bpr/lovelysnow/materialInventory')">物料库存</a></li></t:module>
					<t:module code="LOVELYSTORESPRODUCT"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowProduct','可爱雪-产品','${contextPath }/bpr/lovelysnow/product')">产&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;品</a></li></t:module>
					<t:module code="LOVELYSTORESPRODUCTSELL"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowProductSell','可爱雪-产品销售','${contextPath }/bpr/lovelysnow/productSell')">产品销售</a></li></t:module>
				</ul>
			</div>
			</t:module>
			<t:module code="LOVELYACCOUNTINGD">
			<div title="可爱雪账务" class="l-scroll">
				<ul class="m-ul">
					<t:module code="LOVELYSTORESACCOUNT"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowAccount','可爱雪-现金账户','${contextPath }/bpr/lovelysnow/account')">现金账户</a></li></t:module>
					<t:module code="LOVELYSTORESTYPE"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowAccountType','可爱雪-账务类型','${contextPath }/bpr/lovelysnow/accountType')">账务类型</a></li></t:module>
					<t:module code="LOVELYSTORESDISBURSEMENT"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowDisbursement','可爱雪-支出单','${contextPath }/bpr/lovelysnow/accountOrder?ctype=支出')">支出单</a></li></t:module>
					<t:module code="LOVELYSTORESINCOME"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowIncome','可爱雪-收入单','${contextPath }/bpr/lovelysnow/accountOrder?ctype=收入')">收入单</a></li></t:module>
					<t:module code="LOVELYSTORESINVESTMENT"><li><img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('lovelysnowInvestment','可爱雪-投资单','${contextPath }/bpr/lovelysnow/accountOrder?ctype=投资')">投资单</a></li></t:module>
				</ul>
			</div>
			</t:module>
			<t:module code="LOVELYREPORT">
			<div title="可爱雪报表" class="l-scroll">
				<ul class="m-ul">
				</ul>
			</div>
			</t:module>
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