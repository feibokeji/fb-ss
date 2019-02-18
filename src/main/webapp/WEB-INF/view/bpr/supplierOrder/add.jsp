<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增供应商单据</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/supplierOrder/add.jsp -->
<body>
	<!-- 订单详细内容 -->
	<form id="addOrderForm" name="addOrderForm" method="post" action="${contextPath }/bpr/supplierOrder/addSave">
		<input type="hidden" name="itype" value="${itype }"/>
	    <input type="hidden" name="uuserid" value="${user.uid }"/>
	    <input type="hidden" id="addIstatus" name="istatus" value="1"/>
	    <input type="hidden" id="addUsupplierid" name="usupplierid"/>
	    <table style="margin: 0 auto;border: 1px solid #eeeeee;width: 98%;line-height: 45px;">
	    	<tr>
	        	<td colspan="11" align="center"><h2 id="titleH2"></h2></td>
	        </tr>
	        <tr>
	        	<td align="right" width="60px">供应商：</td>
	        	<td align="left" width="100px"><input type="text" id="addCsuppliername" name="csuppliername" class="validate[required]"/></td>
	        	<td align="right" width="60px">日期：</td>
	        	<td align="left" width="100px"><input type="text" id="addDrecordateStr" name="drecorddateStr" class="validate[required]"/></td>
	        	<td align="right" width="60px">操作人：</td>
	        	<td align="left" width="100px"><label style="border-bottom: 1px solid #bbbbbb;">&nbsp;&nbsp;&nbsp;${user.cname }&nbsp;&nbsp;&nbsp;</label></td>
	        	<td><input type="button" class="l-button" value="选择商品" onclick="chooseOtherGoods()"/></td>
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
	        				<th width="60px">移除</th>
	        				<th></th>
	        				<th></th>
	        			</tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr style="line-height: 18px;">
	        	<td colspan="11">
	        		<table style="margin: 0 auto;width: 100%;" class="listTable">
	        			<tr>
	        				<td width="40px"></td>
	        				<td width="80px"></td>
	        				<td width="80px"></td>
	        				<td width="202px"></td>
				        	<td align="right" width="60px">合计:</td>
				        	<td width="60px"></td>
				        	<td width="60px" align="right"></td>
				        	<td width="60px" align="right"><label id="totalAmount">0</label></td>
				        	<td width="60px"></td>
				        	<td></td>
				        	<td></td>
	        			</tr>
	        		</table>
	        	</td>
	        </tr>
	        <tr>
	        	<td colspan="11" style="border-top: 1px solid #eeeeee;line-height: 45px;">
	        		<input type="button" value="+添加行" onclick="addLine('detailsTable')" class="l-button"/>
	        		<input type="button" value="保存" class="l-button" onclick="submitForm()"/>
	        	</td>
	        </tr>
		</table>
	</form>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';var itype = ${itype};</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/common.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/supplierOrder/add.js"></script>
</body>
</html>