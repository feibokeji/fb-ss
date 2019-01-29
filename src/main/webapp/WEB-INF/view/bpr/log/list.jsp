<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/log/list.jsp -->
<body>
	<div id="navtab1" style="width:100%;border:1px solid #A3C0E8;overflow:hidden; ">
		<div tabid="login" title="登录日志" lselected="true"  style="height:100%;overflow: scroll;" >
			<ul style="line-height: 20px;margin-left: 5px;">
				<c:forEach items="${loginList }" var="login">
				<li>
					<fmt:formatDate value="${login.dlogintime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/>:${login.cusername}[${login.ctype }]
					&nbsp;&nbsp;&nbsp;&nbsp;IP:${login.cloginip }&nbsp;&nbsp;&nbsp;&nbsp;URL:${login.cloginurl}
					&nbsp;&nbsp;&nbsp;&nbsp;备注:${login.cmemo }
				</li>
				</c:forEach>
			</ul>
		</div>
		<div tabid="operate" title="操作日志" style="height:100%;overflow: scroll;" >
			<ul style="line-height: 20px;margin-left: 5px;">
				<c:forEach items="${operateList }" var="operate">
				<li>
					<fmt:formatDate value="${operate.doperatetime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"/>:${operate.cusername}[${operate.ctype }]
					&nbsp;&nbsp;&nbsp;&nbsp;IP:${operate.coperateip }&nbsp;&nbsp;&nbsp;&nbsp;URL:${operate.coperateurl}
					&nbsp;&nbsp;&nbsp;&nbsp;状态:${operate.cstatus }&nbsp;&nbsp;&nbsp;&nbsp;备注:${operate.cmemo }
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript">
		$("#navtab1").ligerTab();
	</script>
</body>
</html>