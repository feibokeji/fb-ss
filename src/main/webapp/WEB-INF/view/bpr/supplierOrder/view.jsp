<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow: hidden">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查看供应商商品单据</title>
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/supplierOrder/add.jsp -->
<body>
	<table style="margin: 0 auto;border: 1px solid #eeeeee;width: 98%;line-height: 45px;">
		<tr>
	    	<td colspan="11" align="center">
	    		<h2 id="titleH2">
	    			<c:if test="${order.itype eq 0 }">商品入库单</c:if>
	    			<c:if test="${order.itype eq 1 }">商品退库单</c:if>
	    			<c:if test="${order.itype eq 2 }">商品报损单</c:if>
	    		</h2>
	    	</td>
	    </tr>
	    <tr>
	    	<td align="right" width="60px">供应商：</td>
	        <td align="left" width="100px"><label style="border-bottom: 1px solid #bbbbbb;">&nbsp;&nbsp;&nbsp;${order.csuppliername }&nbsp;&nbsp;&nbsp;</label></td>
	        <td align="right" width="60px">日期：</td>
	        <td align="left" width="200px"><label style="border-bottom: 1px solid #bbbbbb;">&nbsp;&nbsp;&nbsp;${order.drecorddateStr }&nbsp;&nbsp;&nbsp;</label></td>
	        <td align="right" width="60px">操作人：</td>
	        <td align="left" width="100px"><label style="border-bottom: 1px solid #bbbbbb;">&nbsp;&nbsp;&nbsp;${order.cusername }&nbsp;&nbsp;&nbsp;</label></td>
	        <td>
	        	<c:if test="${order.istatus eq 0 }">
	        		<img src="${contextPath }/common/images/audit.png" alt="已审核" />
	        	</c:if>
	        	<c:if test="${order.istatus eq 1 }">
	        		<img src="${contextPath }/common/images/not_audit.png" alt="未审核" />
	        	</c:if>
	        </td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
		</tr>
	    <tr>
	    	<td colspan="11" align="center" style="border-bottom: 1px solid #eeeeee;"></td>
	   	</tr>
	   	<tr>
	   		<td colspan="11">
	   			<table id="detailsTable" style="margin: 0 auto;width: 100%;" class="listTable">
	        		<tr>
	        			<th width="40px">序号</th>
	        			<th width="80px">类别</th>
	        			<th width="80px">品牌</th>
	        			<th width="200px">商品</th>
	        			<th width="60px">单位</th>
	        			<th width="60px">数量</th>
	        			<th width="60px">价格(元)</th>
	        			<th width="60px">金额(元)</th>
	        			<th></th>
	        			<th></th>
	        			<th></th>
	        		</tr>
	        		<c:set var="totalNamount" value="0"></c:set>
	        		<c:set var="totalQuantity" value="0"></c:set>
	        		<c:forEach items="${order.orderDetailList }" var="detail">
	        		<tr id="dataLineTr${detail.isort }">
	        			<td><label>${detail.isort }</label></td>
	        			<td>${detail.ccategoryname }</td>
	        			<td>${detail.cbrandname }</td>
	        			<td align="left">${detail.cname }</td>
	        			<td>${detail.cunitname }</td>
	        			<td>${detail.nquantity }</td>
	        			<td>${detail.nprice }</td>
	        			<td>${detail.namount }</td>
	        			<td><c:set var="totalNamount" value="${totalNamount + detail.namount }"></c:set></td>
	        			<td><c:set var="totalQuantity" value="${totalQuantity + detail.nquantity }"></c:set></td>
	        			<td></td>
	        		</tr>
	        		</c:forEach>
	        		<tr>
				        <td colspan="5" align="right">合计:</td>
				        <td><label>${totalQuantity }</label></td>
				        <td></td>
				        <td><label>${totalNamount }</label></td>
				        <td></td>
				        <td></td>
				        <td></td>
	        		</tr>
	        	</table>
	   		</td>
	   	</tr>
	</table>
</body>
</html>