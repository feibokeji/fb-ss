<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>飞博科技管理平台-登录页面</title>
<link type="text/css" href="${contextPath}/common/css/bpr/login.css" rel="stylesheet"/>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="image/x-icon" href="${contextPath}/common/images/favicon.ico" rel="shortcut icon" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- login.jsp -->
<body>
	<div id="pageloading"></div>
	<div id="loginDiv">
		<div class="loginLogo">&nbsp;&nbsp;飞博科技管理平台</div>
		<table>
			<tr>
				<td width="120" align="right"><label class="_label">帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</label></td>
				<td><input type="text" name="code" id="code" class="textInput1" tabindex="1" /></td>
			</tr>
			<tr>
				<td width="120" align="right"><label class="_label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;</label></td>
				<td>
					<input type="password" name="password" id="password" class="textInput1" tabindex="2" />
					<a href="javascript:void(0);" class="findPwd">找回密码？</a> 
				</td>
			</tr>
			<tr>
				<td width="120" align="right"><label>验&nbsp;&nbsp;证&nbsp;&nbsp;码&nbsp;&nbsp;</label> </td>
				<td>
					<input type="text" name="verifyCode" id="verifyCode" class="textInput2" tabindex="3" /> 
					<img src="${contextPath }/image.jsp" id="random" class="random" onclick="show(document.getElementById('random'))" width="75" height="30" style="border: 1px solid gray" /> 
					<a href="javascript:show(document.getElementById('random'));" >看不清？</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="checkbox" id="remember" name="remember" tabindex="4"/> 
					<label for="remember">记住登陆信息</label>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="登录" id="submitBtn" class="l-button" onclick="login()"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="注册" class="l-button" onclick="register()"/>
				</td>
			</tr>
		</table>
		<div class="about">
			<a href="#" target="_Blank">关于我们</a>
			| <a href="#" target="_Blank">平台介绍</a> 
			| <a href="#" target="_Blank">商务合作</a>
			| <a href="#" target="_Blank">广告投放</a>
		</div>
	</div>
	<div id="footer">内乡县飞博电脑中心<br/> ◎ 2015-2017 Copyright 2015-2017,FeiBo All Rights Reserved</div>
	<script type="text/javascript"> var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/login.js"></script>
</body>
</html>