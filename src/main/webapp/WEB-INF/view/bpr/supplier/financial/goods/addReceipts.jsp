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
<!-- /bpr/supplier/financial/goods/addReceipts.jsp -->
<body>
	<form id="receiptsForm" method="post" action="${contextPath }/bpr/supplier/financial/goods/saveReceipts">
		<input type="hidden" name="ureceivableid" value="${receivable.uid }"/>
		<input type="hidden" name="ctype" value="${receivable.ctype }"/>
		<table class="receipts_table">
			<tr>
				<td colspan="6" align="center" height="60px;">
					<c:if test="${receivable.ctype eq 'AR' }"><h2>供应商-商品类-收款单</h2></c:if>
					<c:if test="${receivable.ctype eq 'AP' }"><h2>供应商-商品类-付款单</h2></c:if>
				</td>
			</tr>
			<tr>
				<td align="right">单&nbsp;据&nbsp;&nbsp;编&nbsp;号：</td>
				<td width="150px;">${receivable.corderno }</td>
				<td align="right">供&nbsp;应&nbsp;商&nbsp;名&nbsp;称：</td>
				<td width="158px">${receivable.csuppliername }</td>
				<td align="right">日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期：</td>
				<td>
					<jsp:useBean id="now" class="java.util.Date" scope="page"/>
					<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<td align="right">操&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;员：</td>
				<td>${user.cname }</td>
				<td align="right">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
				<td>
					<select name="istatus" style="width: 158px;height: 30px;">
						<option value="1">已审核</option>
						<option value="0">未审核</option>
					</select>
				</td>
				<td align="right">未结金额(元)：</td>
				<td>${addNamount }</td>
			</tr>
			<tr>
				<td align="right">支&nbsp;付&nbsp;&nbsp;方&nbsp;式：</td>
				<td>
					<select id="paymentMethodSelect" name="upaymentmethodid" style="width: 158px;height: 30px;"></select>
				</td>
				<td align="right">
					<c:if test="${receivable.ctype eq 'AR' }">实收金&nbsp;额(元)：</c:if>
					<c:if test="${receivable.ctype eq 'AP' }">实付金&nbsp;额(元)：</c:if>
				</td>
				<td>
					<input type="text" class="validate[required,custom[number],min[1],max[${addNamount }]]" style="width: 154px;height: 26px;" value="${addNamount }" id="namount" name="namount" onchange="convert_rmb()"/>
				</td>
				<td align="right">大&nbsp;&nbsp;写&nbsp;&nbsp;金&nbsp;&nbsp;额：</td>
				<td><span id="amountInWords"></span></td>
			</tr>
			<tr>
				<td align="right">收付款说明：</td>
				<td colspan="5">注意选择支付方式，此单据不能用于挂账！</td>
			</tr>
		</table>
	</form>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/convertRMB.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/supplier/financial/goods/addReceipts.js"></script>
</body>
</html>
