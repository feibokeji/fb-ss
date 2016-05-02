<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>飞博科技管理平台-部门管理</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /dept/list.jsp -->
<body style="padding: 10px;">
	<ul id="dept-tree">
		<li>
            <span>节点1</span>
            <ul>
                <li>
                    <span>节点1.1</span>
                     <ul>
                        <li><span>节点1.1.2</span></li>
                        <li><span>节点1.1.2</span></li>
                     </ul>
                 </li>
                 <li><span>节点1.2</span></li>
            </ul>
        </li> 
        <li><span>节点2</span></li>
        <li>
            <span>节点3</span>
            <ul>
                <li><span>节点3.1</span></li>
                <li><span>节点3.2</span></li>
            </ul>
        </li>
	</ul>
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/dept/list.js"></script>
</body>
</html>