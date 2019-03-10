<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查看单据明细页面</title>
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
			<c:if test="${order.itype == 0 }"><h2>已销售商品单据明细</h2></c:if>
			<c:if test="${order.itype == 1 }"><h2>已退货商品单据明细</h2></c:if>
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
				<th width="80px">类别</th>
				<th width="80px">品牌</th>
				<th width="140px">名称</th>
				<th width="200px">全称</th>
				<th width="80px">单位</th>
				<th width="80px">价格(元)</th>
				<th width="80px">数量</th>
				<th width="80px">金额(元)</th>
			</tr>
			<c:set var="totalQuantity" value="0.00"></c:set>
			<c:set var="totalNamount" value="0.00"></c:set>
			<c:forEach items="${orderDetailList }" var="detail">
			<c:set var="totalQuantity" value="${totalQuantity+detail.nquantity }"></c:set>
			<c:set var="totalNamount" value="${totalNamount+detail.namount }"></c:set>
			<tr>
				<td>${detail.isort }</td>
				<td align="left">${detail.ccategoryname }</td>
				<td align="left">${detail.cbrandname }</td>
				<td align="left">${detail.cothergoodsname }</td>
				<td align="left">${detail.cothergoodsfullname }</td>
				<td align="left">${detail.cunitname }</td>
				<td align="left">${detail.nprice }</td>
				<td align="left">${detail.nquantity }</td>
				<td align="left">${detail.namount }</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="right">合计：</td>
				<td align="left">${totalQuantity }</td>
				<td align="left">${totalNamount }</td>
			</tr>
		</table>
		<!-- 应收应付信息 -->
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
	</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customerOrder/view.js"></script>
</body>
</html>
