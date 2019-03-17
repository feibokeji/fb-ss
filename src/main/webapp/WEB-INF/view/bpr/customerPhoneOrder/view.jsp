<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>客户手机单据详细页面</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/customerPhoneOrder/view.jsp -->
<body>
	<div>
		<!-- 标题 -->
		<div style="margin: 0 auto;line-height: 40px;text-align: center;">
			<c:if test="${order.itype == 0 }"><h2>已销售手机单据明细</h2></c:if>
			<c:if test="${order.itype == 1 }"><h2>已退货手机单据明细</h2></c:if>
		</div>
		<!-- 头部 -->
		<table class="listTable">
			<tr>
				<td align="right">单据编号：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.cno }</td>
				<td align="right">客户名称：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.ccustomername }</td>
				<td align="right">单据类型：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.itypeStr }</td>
				<td align="right">单据状态：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.istatusStr }</td>
				<td align="right">操作员：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.cusername }</td>
				<td align="right">记录日期：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.drecorddateStr }</td>
				<td align="right">更新日期：</td>
				<td align="left" style="border-bottom: 1px solid #000000;">${order.dupdatedateStr }</td>
			</tr>
		</table>
		<!-- 明细 -->
		<table class="listTable" style="margin-top: 5px;">
			<tr>
				<th width="30px">序号</th>
				<th width="80px">品牌</th>
				<th width="100px">型号</th>
				<th width="60px">颜色</th>
				<th width="100px">串号(IMEI)</th>
				<th width="50px">价格(元)</th>
				<th width="50px">折扣</th>
				<th width="50px">金额(元)</th>
				<th width="50px">运行内存</th>
				<th width="50px">存储内存</th>
				<th width="80px">处理器</th>
				<th width="80px">摄像头</th>
				<th width="80px">屏幕</th>
				<th width="80px">电池</th>
			</tr>
			<c:set var="totalNamount" value="0.00"></c:set>
			<c:forEach items="${orderDetailList }" var="detail">
			<c:set var="totalNamount" value="${totalNamount+detail.namount }"></c:set>
			<tr>
				<td>${detail.isort }</td>
				<td align="left">${detail.cbrandname }</td>
				<td align="left">${detail.cphonemodelname }</td>
				<td align="left">${detail.ccolorname }</td>
				<td align="left">${detail.imei }</td>
				<td align="left">${detail.nprice }</td>
				<td align="left">${detail.ndiscount }</td>
				<td align="left">${detail.namount }</td>
				<td align="left">${detail.cram }</td>
				<td align="left">${detail.crom }</td>
				<td align="left">${detail.ccpu }</td>
				<td align="left">${detail.ccamera }</td>
				<td align="left">${detail.cscreen }</td>
				<td align="left">${detail.cbattery }</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="right">合计：</td>
				<td align="left">${totalNamount }</td>
				<td align="left"></td>
				<td align="left"></td>
				<td align="left"></td>
				<td align="left"></td>
				<td align="left"></td>
				<td align="left"></td>
			</tr>
		</table>
		<!-- 应收应付信息 -->
		<div style="margin: 0 auto;width: 99%;margin-top: 5px;">
			<h2>
				<c:if test="${order.itype eq 0 }">应收信息</c:if>
	    		<c:if test="${order.itype eq 1 }">应付信息</c:if>
			</h2>
		</div>
		<table class="listTable" style="margin-top: 5px;">
			<tr>
				<th width="30px">序号</th>
				<th width="80px">客户信息</th>
				<th width="140px">单据编号</th>
				<th width="80px">操作员</th>
				<th width="80px">类型</th>
				<th width="80px">原始金额(元)</th>
				<th width="80px">折扣</th>
				<th width="80px">折后金额(元)</th>
				<th width="80px">状态</th>
				<th width="140px">记录日期</th>
				<th width="140px">更新日期</th>
			</tr>
			<c:set var="totalReceivableNamount" value="0.00"></c:set>
			<c:forEach items="${orderReceivableList }" var="receivable" varStatus="i">
			<c:set var="totalReceivableNamount" value="${totalReceivableNamount+receivable.namount }"></c:set>
			<tr>
				<td>${i.index+1 }</td>
				<td align="left">${receivable.ccustomername }</td>
				<td align="left">${receivable.corderno }</td>
				<td align="left">${receivable.cusername }</td>
				<td align="left">${receivable.ctypeStr }</td>
				<td align="left">${receivable.nactualamount }</td>
				<td align="left">${receivable.ndiscount }</td>
				<td align="left">${receivable.namount }</td>
				<td align="left">${receivable.istatusStr }</td>
				<td align="left">${receivable.drecorddateStr }</td>
				<td align="left">${receivable.dupdatedateStr }</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="right">合计：</td>
				<td align="left">${totalReceivableNamount }</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<!-- 实收实付信息 -->
		<div style="margin: 0 auto;width: 99%;margin-top: 5px;">
			<h2>
				<c:if test="${order.itype eq 0 }">实收信息</c:if>
	    		<c:if test="${order.itype eq 1 }">实付信息</c:if>
			</h2>
		</div>
		<table class="listTable" style="margin-top: 5px;">
			<tr>
				<th width="30px">序号</th>
				<th width="140px">单据编号</th>
				<c:if test="${order.itype == 0 }"><th width="80px">收款方式</th></c:if>
				<c:if test="${order.itype == 1 }"><th width="80px">付款方式</th></c:if>
				<th width="80px">操作员</th>
				<th width="80px">类型</th>
				<th width="80px">金额(元)</th>
				<th width="80px">状态</th>
				<th width="140px">记录日期</th>
				<th width="140px">更新日期</th>
			</tr>
			<c:set var="totalReceiptsNamount" value="0.00"></c:set>
			<c:forEach items="${orderReceiptsList }" var="receipts" varStatus="i">
			<c:set var="totalReceiptsNamount" value="${totalReceiptsNamount + receipts.namount }"></c:set>
			<tr>
				<td>${i.index+1 }</td>
				<td align="left">${receipts.corderno }</td>
				<td align="left">${receipts.cpaymentmethodname }</td>
				<td align="left">${receipts.cusername }</td>
				<td align="left">${receipts.ctypeStr }</td>
				<td align="left">${receipts.namount }</td>
				<td align="left">${receipts.istatusStr }</td>
				<td align="left">${receipts.drecorddateStr }</td>
				<td align="left">${receipts.dupdatedateStr }</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">合计：</td>
				<td align="left">${totalReceiptsNamount }</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<!-- 功能按钮 -->
		<div style="margin-top: 20px;margin-bottom: 20px;text-align: center;">
			<!-- 超过7天不予退货且不为退货单据 -->
			<c:if test="${dayDiff < 7 && order.itype eq 0}">
			<input type="button" class="l-button" value="退货" onclick="returnPhone()"/>
			</c:if>
			<input type="button" class="l-button" value="关闭" onclick="closeViewPage()"/>
		</div>
	</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';var uorderid = '${order.uid}';var istatus = ${order.istatus};var cno = '${order.cno}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customerPhoneOrder/view.js"></script>
</body>
</html>
