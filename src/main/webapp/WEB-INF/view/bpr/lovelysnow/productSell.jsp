<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>可爱雪-产品销售</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/Gray2014/css/all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/lovelysnow/productSell.jsp -->
<body>
	<div id="layout1">
    	<div position="left" title="单据">
    		<ul id="tree1"></ul>
    	</div>
        <div position="center" title="产品销售单" style="overflow: scroll;">
        	<!-- 查看 -->
        	<img src="" alt="" id="seal" class="seal_img"/>
        	<input type="hidden" id="cstatus" value="${order.cstatus }"/>
        	<input type="hidden" id="uid" value="${order.uid }"/>
        	<table style="margin: 0 auto;border: 1px solid #eeeeee;width: 98%;line-height: 45px;">
	        	<tr>
	        		<td align="right" width="100">日期:</td><td align="left"><label><fmt:formatDate value="${order.dordertime }" pattern="yyyy-MM-dd"/></label></td>
	        		<td align="right" width="100">编号:</td><td align="left"><label>${order.cno }</label></td>
	        	</tr>
	        	<tr>
	        		<td colspan="4">
	        			<table class="listTable">
	        				<tr>
	        					<th>序号</th>
	        					<th>类别</th>
	        					<th>产品编码</th>
	        					<th>产品名称</th>
	        					<th>销售数量</th>
	        					<th>销售金额</th>
	        					<th>退货数量</th>
	        					<th>退货金额</th>
	        					<th>赠送数量</th>
	        					<th>赠送金额</th>
	        					<th>数量小计</th>
	        					<th>金额小计</th>
	        					<th>参考进价</th>
	        					<th>进价金额</th>
	        					<th>参考利润</th>
	        					<th>当前主供应商</th>
	        					<th>品牌</th>
	        				</tr>
	        				<c:set var="totalNSqty" value="0"></c:set>
	        				<c:set var="totalNSamount" value="0"></c:set>
	        				<c:set var="totalNBqty" value="0"></c:set>
	        				<c:set var="totalNBamount" value="0"></c:set>
	        				<c:set var="totalNGqty" value="0"></c:set>
	        				<c:set var="totalNGamount" value="0"></c:set>
	        				<c:set var="totalNqtySubtotal" value="0"></c:set>
	        				<c:set var="totalNamountSubtotal" value="0"></c:set>
	        				<c:set var="totalNreferenceprofits" value="0"></c:set>
	        				<c:forEach items="${list }" var="item">
	        				<tr>
	        					<td>${item.isort }</td>
	        					<td>${item.ccategoryname }</td>
	        					<td>${item.cproductno }</td>
	        					<td>${item.cproductname }</td>
	        					<td align="right">${item.nsqty }<c:set var="totalNSqty" value="${totalNSqty + item.nsqty }"></c:set></td>
	        					<td align="right">${item.nsamount }<c:set var="totalNSamount" value="${totalNSamount + item.nsamount }"></c:set></td>
	        					<td align="right">${item.nbqty }<c:set var="totalNBqty" value="${totalNBqty + item.nbqty }"></c:set></td>
	        					<td align="right">${item.nbamount }<c:set var="totalNBamount" value="${totalNBamount + item.nbamount }"></c:set></td>
	        					<td align="right">${item.ngqty }<c:set var="totalNGqty" value="${totalNGqty + item.ngqty }"></c:set></td>
	        					<td align="right">${item.ngamount }<c:set var="totalNGamount" value="${totalNGamount + item.ngamount }"></c:set></td>
	        					<td align="right">${item.nqtysubtotal }<c:set var="totalNqtySubtotal" value="${totalNqtySubtotal + item.nqtysubtotal }"></c:set></td>
	        					<td align="right">${item.namountsubtotal }<c:set var="totalNamountSubtotal" value="${totalNamountSubtotal + item.namountsubtotal }"></c:set></td>
	        					<td align="right">${item.nreferenceprice }</td>
	        					<td align="right">${item.npurchaseprice }</td>
	        					<td align="right">${item.nreferenceprofits }<c:set var="totalNreferenceprofits" value="${totalNreferenceprofits + item.nreferenceprofits }"></c:set></td>
	        					<td>${item.cmainsupplier }</td>
	        					<td>${item.cbrand }</td>
	        				</tr>
	        				</c:forEach>
	        				<tr>
	        					<td></td>
	        					<td></td>
	        					<td  align="right">合计</td>
	        					<td></td>
	        					<td align="right">${totalNSqty }</td>
	        					<td align="right">${totalNSamount }</td>
	        					<td align="right">${totalNBqty }</td>
	        					<td align="right">${totalNBamount }</td>
	        					<td align="right">${totalNGqty }</td>
	        					<td align="right">${totalNGamount }</td>
	        					<td align="right">${totalNqtySubtotal }</td>
	        					<td align="right">${totalNamountSubtotal }</td>
	        					<td></td>
	        					<td></td>
	        					<td align="right">${totalNreferenceprofits }</td>
	        					<td></td>
	        					<td></td>
	        				</tr>
	        			</table>
	        		</td>
	        	</tr>
	        	<tr>
	        		<td colspan="4">
	        			<c:if test="${order.cstatus eq '00' }">
		        			<input type="button" value="审核" class="l-button" onclick="f_Audit()"/>
		        			<input type="button" value="删除" class="l-button" onclick="f_Delete()"/>
	        			</c:if>
	        			<c:if test="${order.cstatus eq '01' }">
	        				<input type="button" value="反审核" class="l-button" onclick="f_n_Audit()"/>
	        			</c:if>
	        		</td>
	        	</tr>
	        </table>
        </div>  
    </div> 
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/lovelysnow/productSell.js"></script>
</body>
</html>