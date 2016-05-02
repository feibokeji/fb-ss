<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>飞博科技管理平台-公司列表</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- list.jsp -->
<body>
	<form action="${contextPath }/corp/list" id="searchCorpForm" name="searchCorpForm" method="post">
		<input type="hidden" id="currentPage" name="currentPage" value="1"/>
		<table class="searchTable">
			<tr>
				<td class="search-table-tr-td-label">公司代码:&nbsp;&nbsp;</td>
				<td><input type="text" id="ccode" name="ccode" value="${corp.ccode }"/></td>
				<td class="search-table-tr-td-label">公司名称:&nbsp;&nbsp;</td>
				<td><input type="text" id="cname" name="cname" value="${corp.cname }"/></td>
				<td class="search-table-tr-td-label">公司负责人:&nbsp;&nbsp;</td>
				<td><input type="text" id="cprincipal" name="cprincipal" value="${corp.cprincipal }"/></td>
				<td><input type="submit" value="查询" class="l-button"/></td>
			</tr>
		</table>
		<table class="listTable">
			<tr>
				<th width="30"></th>
				<th>公司代码</th>
				<th>公司名称</th>
				<th>公司负责人</th>
				<th>公司地址</th>
				<th>创建时间</th>
				<th>更新日期</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${page.resultRows }" var="corp" varStatus="i">
			<tr>
				<td>${i.index + 1 }</td>
				<td>${corp.ccode }</td>
				<td>${corp.cname }</td>
				<td>${corp.cprincipal }</td>
				<td>${corp.caddr }</td>
				<td>${corp.dcreatetime }</td>
				<td>${corp.dupdatetime }</td>
				<td><input type="button" value="编辑" class="l-button" onclick="editCorp('${corp.uid}')"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="删除" class="l-button" onclick="deleteCorp('${corp.uid}')"/></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="center">
					<jsp:include page="/WEB-INF/include/page.jsp">
						<jsp:param value="searchForm" name="formName" />
					</jsp:include>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/corp/list.js"></script>
</body>
</html>