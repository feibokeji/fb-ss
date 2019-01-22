<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/liger/images/skins/ligerui-icons.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/jQuery-Validation-Engine-2.6.2-ciaoca/css/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/jquery-ui/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/bpr/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
</head>
<!-- /bpr/user/detail.jsp -->
<body>
	<form action="${contextPath }/bpr/user/mod" id="modUserForm" name="modUserForm" method="post">
		<input type="hidden" name="uid" value="${user.uid }"/>
		<input type="hidden" name="udeptid" value="${user.udeptid }"/>
		<input type="hidden" id="_djoindate" value="${user.djoindate }"/>
		<input type="hidden" id="_dbirthday" value="${user.dbirthday }"/>
		<input type="hidden" id="_csex" value="${user.csex }"/>
		<input type="hidden" id="_ccode" value="${user.ccode }"/>
		<input type="hidden" id="_cname" value="${user.cname }"/>
		<h2>&nbsp;</h2>
		<table class="add-table">
			<tr>
				<th align="right"><span style="color: red;">*</span>用户代码:</th>
				<td align="left"><input type="text" id="ccode" name="ccode" value="${user.ccode }" class="validate[required,funcCall[ajaxCode]]"/></td>
			</tr>
			<tr>
				<th align="right"><span style="color: red;">*</span>用户名称:</th>
				<td align="left"><input type="text" id="cname" name="cname" value="${user.cname }" class="validate[required,funcCall[ajaxName]]"/></td>
			</tr>
			<tr>
				<th align="right">英文名字:</th>
				<td align="left"><input type="text" name="cnameen" value="${user.cnameen }" class="validate[custom[onlyLetterSp]]"/></td>
			</tr>
			<tr>
				<th align="right">职务:</th>
				<td align="left"><input type="text" name="cduty" value="${user.cduty }"/></td>
			</tr>
			<tr>
				<th align="right">级别:</th>
				<td align="left"><input type="text" name="crank" value="${user.crank }" class="validate[custom[integer]]"/></td>
			</tr>
			<tr>
				<th align="right">入职日期:</th>
				<td align="left"><input type="text" id="djoindate" name="djoindate" value="${user.djoindate }"/></td>
			</tr>
			<tr>
				<th align="right">身份证:</th>
				<td align="left"><input type="text" name="cidcard" value="${user.cidcard }" class="validate[custom[chinaIdLoose]]"/></td>
			</tr>
			<tr>
				<th align="right">性别:</th>
				<td align="left">
					<select id="csex" name="csex">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<th align="right">出生日期:</th>
				<td align="left"><input type="text" id="dbirthday" name="dbirthday" value="${user.dbirthday }"/></td>
			</tr>
			<tr>
				<th align="right">工作电话:</th>
				<td align="left"><input type="text" name="cofficetel" value="${user.cofficetel }" class="validate[custom[phone]]"/></td>
			</tr>
			<tr>
				<th align="right">工作传真:</th>
				<td align="left"><input type="text" name="cofficefax" value="${user.cofficefax }" class="validate[custom[phone]]"/></td>
			</tr>
			<tr>
				<th align="right">工作地址:</th>
				<td align="left"><input type="text" name="cofficeaddr" value="${user.cofficeaddr }"/></td>
			</tr>
			<tr>
				<th align="right">移动电话:</th>
				<td align="left"><input type="text" name="cmobiletel" value="${user.cmobiletel }" class="validate[custom[phone]]"/></td>
			</tr>
			<tr>
				<th align="right">住宅电话:</th>
				<td align="left"><input type="text" name="chometel" value="${user.chometel }" class="validate[custom[phone]]"/></td>
			</tr>
			<tr>
				<th align="right">住宅地址:</th>
				<td align="left"><input type="text" name="chomeaddr" value="${user.chomeaddr }"/></td>
			</tr>
			<tr>
				<th align="right">电子邮件:</th>
				<td align="left"><input type="text" name="cemail" value="${user.cemail }" class="validate[custom[email]]"/></td>
			</tr>
			<tr>
				<th align="right">MSN:</th>
				<td align="left"><input type="text" name="cmsn" value="${user.cmsn }"/></td>
			</tr>
			<tr>
				<th align="right">QQ:</th>
				<td align="left"><input type="text" name="cqq" value="${user.cqq }" class="validate[custom[qq]]"/></td>
			</tr>
			<tr>
				<th align="right">备注:</th>
				<td align="left">
					<textarea rows="3" cols="30" name="cmemo" style="border: none;">${user.cmemo }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="40">
					<input type="button" value="保存" onclick="f_Submit()" class="l-button" style="border: 1px solid #A3C0E8;margin-left: 20px;"/>
				</td>
			</tr>
		</table>
	</form>
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery.form.js"></script>
	<script type="text/javascript" src="${contextPath}/common/jQuery-Validation-Engine-2.6.2-ciaoca/js/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/jQuery-Validation-Engine-2.6.2-ciaoca/js/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/bpr/user/detail.js"></script>
</body>
</html>