<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>可爱雪-物料采购</title>
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
<!-- /bpr/lovelysnow/procurement.jsp -->
<body>
	<div id="layout1">
    	<div position="left">
    		<ul id="tree1"></ul>
    	</div>
        <div position="center" title="新增物料采购入库单" style="overflow: scroll;">
        	<!-- 订单详细内容 -->
        	<form>
        		<table style="margin: 0 auto;border: 1px solid #eeeeee;width: 98%;line-height: 45px;">
        			<tr>
        				<td colspan="8" align="center"><h2>物料采购入库单</h2></td>
        			</tr>
        			<tr>
        				<td align="right" width="60px">日期：</td>
        				<td align="left" width="100px"><input type="text" id="dcreatetime" name="dcreatetime" /></td>
        				<td align="right" width="60px">操作人：</td>
        				<td align="left" width="100px"><label style="border-bottom: 1px solid #bbbbbb;">&nbsp;&nbsp;&nbsp;${user.cname }&nbsp;&nbsp;&nbsp;</label></td>
        				<td></td>
        				<td></td>
        				<td></td>
        				<td></td>
        			</tr>
        			<tr>
        				<td colspan="8" align="center" style="border-bottom: 1px solid #eeeeee;"></td>
        			</tr>
        			<tr>
        				<td colspan="8">
        					<table id="detailsTable" style="margin: 0 auto;width: 100%;" class="listTable">
        						<tr>
        							<th width="40px">序号</th>
        							<th width="100px">物料</th>
        							<th width="60px">价格(元)</th>
        							<th width="60px">数量(小)</th>
        							<th width="60px">金额(元)</th>
        							<th width="60px">操作</th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        						</tr>
        					</table>
        				</td>
        			</tr>
        			<tr>
        				<td colspan="8" style="border-top: 1px solid #eeeeee;line-height: 45px;">
        					<input type="button" value="添加数据行" onclick="addLine('detailsTable')" class="l-button"/>
        					<input type="submit" value="保存" class="l-button"/>
        					<input type="submit" value="审核" class="l-button"/>
        				</td>
        			</tr>
        		</table>
        	</form>
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
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/lovelysnow/procurement.js"></script>
</body>
</html>