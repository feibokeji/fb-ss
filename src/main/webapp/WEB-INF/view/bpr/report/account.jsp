<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>可爱雪-账务报表</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/report/account.jsp -->
<body>
	<h2>&nbsp;</h2>
	<h2 style="margin: 0 auto;text-align: center;">可爱雪-账务报表</h2>
	<h2>&nbsp;</h2>
	<input type="hidden" id="search_beganTime" value="${accountOrder.beganTime }"/>
	<input type="hidden" id="search_endTime" value="${accountOrder.endTime }"/>
	<input type="hidden" id="search_ctype" value="${accountOrder.ctype }"/>
	<input type="hidden" id="search_caccountname" value="${accountOrder.caccountname }"/>
	<input type="hidden" id="search_caccounttypename" value="${accountOrder.caccounttypename }"/>
	<input type="hidden" id="search_uaccountid" value="${accountOrder.uaccountid }"/>
	<input type="hidden" id="search_uaccounttypeid" value="${accountOrder.uaccounttypeid }"/>
	<form id="searchForm" name="serachForm" method="post" action="${contextPath }/bpr/report/searchAccountOrder">
		<input type="hidden" id="uaccountid" name="uaccountid" value="${accountOrder.uaccountid }"/>
		<input type="hidden" id="uaccounttypeid" name="uaccounttypeid" value="${accountOrder.uaccounttypeid }"/>
		<table style="margin: 0 auto;" width="70%">
			<tr>
				<td align="right">开始日期:</td>
				<td align="left"><input type="text" id="beganTime" name="beganTime"/></td>
				<td align="right">结束日期:</td>
				<td align="left"><input type="text" id="endTime" name="endTime"/></td>
				<td align="right">账户:</td>
				<td align="left"><input type="text" id="caccountname" name="caccountname" class="validate[required]"/></td>
				<td align="right">类别:</td>
				<td align="left">
					<select id="ctype" name="ctype">
						<option>收入</option>
						<option>支出</option>
					</select>
				</td>
				<td align="right">类型:</td>
				<td align="left"><input type="text" id="caccounttypename" name="caccounttypename"/></td>
				<td align="center"><input type="button" onclick="submitSearch()"  value="查询" class="l-button"/></td>
			</tr>
		</table>
	</form>
	<h2>&nbsp;</h2>
	<table class="listTable" width="70%">
		<tr>
			<th>序号</th>
			<th>日期</th>
			<th>账户</th>
			<th>编码</th>
			<th>类别</th>
			<th>类型</th>
			<th>名称</th>
			<th>金额</th>
		</tr>
		<c:set var="totalNamount" value="0"></c:set>
		<c:forEach items="${accountOrderList }" var="item" varStatus="i">
		<c:set var="totalNamount" value="${totalNamount + item.namount }"></c:set>
		<tr>
			<td align="center">${i.index + 1 }</td>
			<td align="center"><fmt:formatDate value="${item.dcreatetime }" pattern="yyyy-MM-dd"/></td>
			<td align="center">${item.caccountname }</td>
			<td align="center">${item.ccode }</td>
			<td align="center">${item.ctype }</td>
			<td align="center">${item.caccounttypename }</td>
			<td align="center">${item.cname }</td>
			<td align="right">${item.namount }</td>
		</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="right">合计:</td>
			<td align="right">${totalNamount }</td>
		</tr>
	</table>
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
	<script type="text/javascript" src="${contextPath}/common/js/bpr/report/account.js"></script>
</body>
</html>