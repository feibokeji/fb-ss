<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能模块</title>
<link type="text/css" href="${contextPath}/common/liger/skins/Aqua/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/module/list.jsp -->
<body>
	<form action="${contextPath }/bpr/module/list" method="post" id="moduleListForm" name="moduleListForm">
	<input type="hidden" id="currentPage" name="currentPage" value="1"/>
	<input type="button" value="新增模块" onclick="addModule()" class="l-button" style="margin-top: 20px;margin-bottom: 20px;margin-left: 10px;"/>
	<input type="submit" value="加载数据" class="l-button" style="margin-left: 30px;"/>
	<table class="listTableAll" id="listTableAll">
		<tr>
			<th width="2%"></th>
			<th width="2%">类别</th>
			<th width="6%">代码</th>
			<th width="5%">名称</th>
			<th width="6%">父级代码</th>
			<th width="3%">级别</th>
			<th width="3%">序号</th>
			<th width="10%">代码路径</th>
			<th width="10%">访问地址</th>
			<th width="6%">操作</th>
		</tr>
		<c:forEach items="${page.resultRows }" var="module" varStatus="i">
		<tr>
			<td><input type="checkbox" value="${module.cname }" id="${module.uid }" name="_checkbox"/></td>
			<td align="left">${module.ctype }</td>
			<td align="left">${module.ccode }</td>
			<td align="left">${module.cname }</td>
			<td align="left">${module.cparent }</td>
			<td>${module.ilevel }</td>
			<td>${module.isort }</td>
			<td align="left">${module.ccodepath }</td>
			<td align="left">${module.caddr }</td>
			<td><input type="button" onclick="editModule('${module.uid}')" class="l-button-small" value="编辑"/>&nbsp;|&nbsp;<input type="button" class="l-button-small" value="删除" onclick="deleteModule('${module.uid}')"/></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<jsp:include page="/WEB-INF/include/page.jsp">
					<jsp:param value="searchForm" name="formName" />
				</jsp:include>
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/module/list.js"></script>
</body>
</html>