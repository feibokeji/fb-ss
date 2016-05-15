<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/Gray2014/css/all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
<title>可爱雪-财务单据</title>
</head>
<!-- /bpr/lovelysnow/accountOrder.jsp -->
<body>
	<h2 style="margin-left:50px;line-height: 45px;">可爱雪-${ctype }单列表</h2>
	<div class="l-clear"></div>
    <div id="maingrid"></div>
  	<div style="display:none;"></div>
  	<div id="addDiv" style="display: none;">
  		<form id="addForm" name="addForm" method="post" action="${contextPath }/bpr/lovelysnow/addAccountOrder">
  			<input type="hidden" id="uaccounttypeid" name="uaccounttypeid"/>
  			<table class="order-table">
  				<tr>
  					<th colspan="6"><h2>可爱雪${ctype }单据</h2></th>
  				</tr>
  				<tr>
  					<td align="right" width="60">制单日期:</td>
  					<td align="left"><label id="orderDate"></label></td>
  					<td></td>
  					<td></td>
  					<td align="right" width="60">制单人:</td>
  					<td align="left">${user.cname }</td>
  				</tr>
  				<tr>
  					<td align="right" width="60">类型:</td>
  					<td align="left"><input type="text" id="combobox" class="l-text"/></td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td align="right" width="60">名称:</td>
  					<td align="left" colspan="5"><input type="text" class="l-text" style="width: 400px;"/></td>
  				</tr>
  				<tr>
  					<td align="right" width="60">单价:</td>
  					<td align="left"><input type="text" class="l-text"/></td>
  					<td align="right" width="60">数量:</td>
  					<td align="left"><input type="text" class="l-text"/></td>
  					<td align="right" width="60">金额:</td>
  					<td align="left"><input type="text" class="l-text"/></td>
  				</tr>
  				<tr>
  					<td align="right" width="60">描述:</td>
  					<td align="left" colspan="5"><input type="text" class="l-text" style="width: 400px;"/></td>
  				</tr>
  				<tr>
  					<td align="right" width="60">&nbsp;</td>
  					<td align="left">&nbsp;</td>
  					<td></td>
  					<td></td>
  					<td></td>
  					<td></td>
  				</tr>
  			</table>
  		</form>
  	</div>
  	<div id="addAccountTypeDiv" style="display: none;">111111111</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';var ctype = '${ctype}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerGrid.showFilter.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/lovelysnow/accountOrder.js"></script>
</body>
</html>