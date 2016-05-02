<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的主页</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/home.jsp -->
<body>
	<div id="uploadExcelDialog">
		<form action="${contextPath }/bpr/product/uploadExcel" method="post" id="uploadForm" name="uploadForm" enctype="multipart/form-data" onsubmit="return false;">
			<table class="homeTable">
				<tr>
					<td colspan="2" align="center">
						<b>前台销售按商品汇总.XLS</b>
					</td>
				</tr>
				<tr>
					<th>日期：</th>
					<td><input type="text" id="uploadTime" name="uploadTime"/></td>
				</tr>
				<tr>
					<th align="right">文件：</th>
					<td>
						<input type="file" id="excelFrontDeskSalesProduct" name="excelFrontDeskSalesProduct"/>
					</td>
				</tr>
				<tr>
					<th align="right"><span style="color: red;">提示：</span></th>
					<td align="left"><span style="color: red;">*只能上传.xls/.xlsx格式的Excel文件</span></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="上传" class="l-button" style="margin: 5px auto 5px auto;"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/uploadPreview.min.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/home.js"></script>
</body>
</html>