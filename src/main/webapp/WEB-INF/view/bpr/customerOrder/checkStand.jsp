<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品结账</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/customerOrder/checkStand.jsp -->
<body style="background-color:#EFF5FE;">
	<form id="checkStandForm" method="post" action="${contextPath }/bpr/customerOrder/saveCustomerOrder">
		<div style="height: 300px;overflow: auto;border-bottom:2px dashed #e1e1e1;background-color: #ffffff;">
			<table id="checkStandTable" class="checkStandTable">
				<tr>
					<th width="30px">序号</th>
					<th width="60px">类别</th>
					<th width="60px">品牌</th>
					<th>名称</th>
					<th>全称</th>
					<th width="30px">单位</th>
					<th width="50px">价格(元)</th>
					<th width="50px">库存量</th>
					<th width="50px">销售量</th>
					<th width="50px">金额(元)</th>
					<th width="60px"></th>
				</tr>
				<c:forEach items="${goodsList }" var="goods" varStatus="i">
				<tr>
					<td>
						${i.index+1 }
						<input type="hidden" name="orderDetailList[${i.index+1 }].uothergoodsid" value="${goods.uid }"/>
						<input type="hidden" id="orderDetailList_${i.index+1 }_nprice" name="orderDetailList[${i.index+1 }].nprice" value="${goods.nretailprice }"/>
						<input type="hidden" id="orderDetailList_${i.index+1 }_inventoryQuantity" value="${goods.inventoryQuantity }"/>
						<input type="hidden" id="orderDetailList_${i.index+1 }_nquantity" name="orderDetailList[${i.index+1 }].nquantity" value="1"/>
						<input type="hidden" id="orderDetailList_${i.index+1 }_namount" name="orderDetailList[${i.index+1 }].namount" value="${goods.nretailprice }"/>
					</td>
					<td>${goods.ccategoryname }</td>
					<td>${goods.cbrandname }</td>
					<td>${goods.cname }</td>
					<td>${goods.cfullname }</td>
					<td>${goods.cunitname }</td>
					<td align="right">${goods.nretailprice }</td>
					<td align="right">${goods.inventoryQuantity }</td>
					<td align="right"><span id="orderDetailList_${i.index+1 }_nquantity_span">1</span></td>
					<td align="right"><span id="orderDetailList_${i.index+1 }_namount_span">${goods.nretailprice }</span></td>
					<td>
						<img src="${contextPath }/common/liger/skins/icons/add.gif" style="cursor: pointer;" onclick="add(this,${i.index+1})"/>
						<img src="${contextPath }/common/liger/skins/icons/delete.gif" style="cursor: pointer;" onclick="subtraction(this,${i.index+1})"/>
						<img src="${contextPath }/common/liger/skins/icons/candle.gif" style="cursor: pointer;" onclick="del(this,${i.index+1})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<table style="margin:0 auto;font-size: 20px;font-weight: bold;width: 99%;height: 120px;">
			<tr>
				<td align="right">商品数量：</td>
				<td align="left" style="border-right: 2px dashed #ffffff;"><input type="text" id="goodsQuantityInput" class="l-text" style="text-align: right;width: 85px;height: 28px;" value="${quantity }" readonly="readonly"/></td>
				<td align="right">原始金额(元)：</td>
				<td align="left" style="border-right: 2px dashed #ffffff;"><input type="text" id="orderReceivable_nactualamount" name="orderReceivable.nactualamount" class="l-text" style="text-align: right;width: 85px;height: 28px;" value="${namount }" readonly="readonly"/></td>
				<td align="right">收款方式：</td>
				<td align="left">
					<select id="orderReceipts_upaymentmethodid" name="orderReceipts.upaymentmethodid" class="l-select" style="width: 85px;height: 28px;">
						<c:forEach items="${paymentMethodList }" var="paymentMethod">
						<option value="${paymentMethod.uid }">${paymentMethod.cname }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">整单折扣：</td>
				<td align="left" style="border-right: 2px dashed #ffffff;"><input type="text" id="orderReceivable_ndiscount" name="orderReceivable.ndiscount" class="l-text" style="text-align: right;width: 85px;" value="1.00"/></td>
				<td></td>
				<td style="border-right: 2px dashed #ffffff;"></td>
			</tr>
			<tr>
				<td align="right">客户信息：<input type="hidden" id="ucustomerid" name="ucustomerid" value="${customer.uid }"/></td>
				<td align="left" style="border-right: 2px dashed #ffffff;"><input type="text" class="l-text" style="text-align: right;width: 85px;height: 28px;" value="${customer.cname }" readonly="readonly"/></td>
				<td align="right">折后金额(元)：</td>
				<td align="left" style="border-right: 2px dashed #ffffff;"><input type="text" id="orderReceivable_namount" name="orderReceivable.namount" class="l-text" style="text-align: right;width: 85px;height: 28px;color: red;" value="${namount }" readonly="readonly"/></td>
				<td align="right">实收金额(元)：</td>
				<td align="left"><input type="text" id="orderReceipts_namount" name="orderReceipts.namount" class="l-text validate[required,custom[number],min[0]]" style="text-align: right;width: 85px;height: 28px;color: red;" value="${namount }" data-prompt-position="topLeft:-105"/></td>
			</tr>
		</table>
	</form>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/customerOrder/checkStand.js"></script>
</body>
</html>
