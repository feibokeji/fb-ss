<?xml version="1.0" encoding="UTF-8" ?>
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
<!-- /bpr/moduleGroup/list.jsp -->
<body>
	<div id="moduleGroupToolBar"></div>
    <div id="maingrid"></div>
  	<div id="addDiv" style="display: none;">
  		<form id="addForm" name="addForm" method="post" action="${contextPath }/bpr/moduleGroup/save">
  			<table class="add_update_table">
	  			<tr>
	  				<th><span style="color: red;">*</span>编号：</th>
	  				<td><input type="text" id="add_ccode" name="ccode" class="l-text validate[required,funcCall[ajaxCNo]]"/></td>
	  			</tr>
	  			<tr>
	  				<th><span style="color: red;">*</span>名称：</th>
	  				<td><input type="text" id="add_cname" name="cname" class="l-text validate[required,funcCall[ajaxCName]]"/></td>
	  			</tr>
  			</table>
  		</form>
  	</div>
  	<div id="modifyDiv" style="display: none;">
  		<form id="modifyForm" name="modifyForm" method="post" action="${contextPath }/bpr/moduleGroup/modify">
  			<input type="hidden" id="modify_uid" name="uid"/>
  			<table class="add_update_table">
  				<tr>
	  				<th><span style="color: red;">*</span>编号：</th>
	  				<td><input type="text" id="modify_ccode" name="ccode" class="l-text validate[required,funcCall[ajaxModifyCNo]]"/></td>
	  			</tr>
	  			<tr>
	  				<th><span style="color: red;">*</span>名称：</th>
	  				<td><input type="text" id="modify_cname" name="cname" class="l-text validate[required,funcCall[ajaxModifyCName]]"/></td>
	  			</tr>
  			</table>
  		</form>
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
	<script type="text/javascript" src="${contextPath}/common/js/bpr/moduleGroup/list.js"></script>
</body>
</html>