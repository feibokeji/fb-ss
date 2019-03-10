<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>飞博科技管理平台-首页</title>
<link type="image/x-icon" href="${contextPath}/common/images/favicon.ico" rel="shortcut icon" />
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
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
			<span style="color: white;">|</span><a href="javascript:f_User_Info()" class="l-link2">账户信息</a><span style="color: white;">|</span>
			<a href="javascript:f_Mode_Password()" class="l-link2">修改密码</a><span style="color: white;">|</span>
			<a href="javascript:logout()" class="l-link2">退出</a><span style="color: white;">|</span>
			<!-- <a href="javascript:launchFullScreen()">全屏</a>
			<a href="javascript:exitFullScreen()">退出全屏</a> -->
		</div>
	</div>
	<div id="modifyPasswordDiv" style="display:none;">
		<input type="hidden" id="uid" value="${sessionContainer.user.uid }"/>
		新&nbsp;&nbsp;密&nbsp;码:<input type="password" id="password1"/><br/><br/>
		确认密码:<input type="password" id="password2"/>
	</div>
	<div id="layout1" style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
		<div position="left" title="菜单" id="accordion1">
			<!-- 2019/1/15 基本档案菜单 -->
			<div title="基本档案" class="l-scroll">
				<ul class="m-ul">
					<!-- 品牌信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('brandList','品牌信息','${contextPath }/bpr/brand/list')">品牌信息</a>
					</li>
					<!-- 单位信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('unitList','单位信息','${contextPath }/bpr/unit/list')">单位信息</a>
					</li>
					<!-- 颜色信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('colorList','颜色信息','${contextPath }/bpr/color/list')">颜色信息</a>
					</li>
					<!-- 付款方式 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('paymentMethodList','付款方式','${contextPath }/bpr/paymentMethod/list')">付款方式</a>
					</li>
					<!-- 保修政策 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('warrantyList','保修政策','${contextPath }/bpr/warranty/list')">保修政策</a>
					</li>
				</ul>
			</div>
			<!-- 2019/1/23 商品档案菜单 -->
			<div title="商品档案" class="l-scroll">
				<ul class="m-ul">
					<!-- 商品类别 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('otherGoodsCategory','商品类别','${contextPath }/bpr/lovelysnow/category')">商品类别</a>
					</li>
					<!-- 商品信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('otherGoodsList','商品信息','${contextPath }/bpr/otherGoods/list')">商品信息</a>
					</li>
					<!-- 手机型号 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('phoneModelList','手机型号','${contextPath }/bpr/phoneModel/list')">手机型号</a>
					</li>
				</ul>
			</div>
			<!-- 2019/1/24 -->
			<div title="供应商管理" class="l-scroll">
				<ul class="m-ul">
					<!-- 供应商信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierList','供应商信息','${contextPath }/bpr/supplier/list')">供应商信息</a>
					</li>
					<!-- 商品入库 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierOrder0','商品入库单','${contextPath }/bpr/supplierOrder/add?itype=0')">商品入库单</a>
					</li>
					<!-- 商品退库 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierOrder1','商品退库单','${contextPath }/bpr/supplierOrder/add?itype=1')">商品退库单</a>
					</li>
					<!-- 商品报损 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierOrder2','商品报损单','${contextPath }/bpr/supplierOrder/add?itype=2')">商品报损单</a>
					</li>
					<!-- 商品报损 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierOrderList','商品单据管理','${contextPath }/bpr/supplierOrder/list')">商品单据管理</a>
					</li>
					<!-- 手机入库 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierPhoneOrder0','手机入库单','${contextPath }/bpr/supplierPhoneOrder/add?itype=0')">手机入库单</a>
					</li>
					<!-- 手机库存 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('supplierPhoneOrder','手机库存管理','${contextPath }/bpr/supplierPhoneOrder/list')">手机库存管理</a>
					</li>
				</ul>
			</div>
			<div title="同行管理" class="l-scroll">
				<ul class="m-ul">
					<!-- 同行信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('counterPartsList','同行信息管理','${contextPath }/bpr/counterParts/list')">同行信息管理</a>
					</li>
					<!-- 手机调出 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('counterPartsPhoneOrderOut','手机调出管理','${contextPath }/bpr/counterPartsPhoneOrder/outOrder')">手机调出管理</a>
					</li>
					<!-- 调出手机信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('hasOutPhoneOrder','调出手机信息','${contextPath }/bpr/counterPartsPhoneOrder/hasOut')">调出手机信息</a>
					</li>
					<!-- 调入手机信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('hasInPhoneOrder','调入手机信息','${contextPath }/bpr/counterPartsPhoneOrder/hasIn')">调入手机信息</a>
					</li>
				</ul>
			</div>
			<div title="客户管理" class="l-scroll">
				<ul class="m-ul">
					<!-- 客户信息 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('customerList','客户信息','${contextPath }/bpr/customer/list')">客户信息</a>
					</li>
					<!-- 商品销售 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('customerOrderSell','商品销售','${contextPath }/bpr/customerOrder/goodsSell')">商品销售</a>
					</li>
					<!-- 已售商品 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('customerOrder0','已售商品','${contextPath }/bpr/customerOrder/orderList?itype=0')">已售商品</a>
					</li>
					<!-- 已退商品 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('customerOrder1','已退商品','${contextPath }/bpr/customerOrder/orderList?itype=1')">已退商品</a>
					</li>
					<!-- 手机销售 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('customerPhoneOrderSell','手机销售','${contextPath }/bpr/customerPhoneOrder/phoneSell')">手机销售</a>
					</li>
					<!-- 已售手机 -->
					<li>
						<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />&nbsp;<a href="javascript:openPage('customerPhoneOrder2','已售手机','${contextPath }/bpr/customer/list')">已售手机</a>
					</li>
				</ul>
			</div>
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
			<%-- <t:module code="LOVELYSTORES">
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
					<t:module code="LOVELYREPORTSTORES">
						<li>
							<img src="${contextPath }/common/images/demo-spindown-closed.gif" alt="" />
							&nbsp;
							<a href="javascript:openPage('lovelysnowReportAccount','可爱雪-账务报表','${contextPath }/bpr/report/account')">账务报表</a>
						</li>
					</t:module>
				</ul>
			</div>
			</t:module> --%>
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