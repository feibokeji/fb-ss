<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>飞博科技管理平台-编辑公司信息</title>
<link type="text/css" href="${contextPath}/common/liger/css/ligerui-all.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/formValidator2.2.4/validationEngine.jquery.css" rel="stylesheet" />
<link type="text/css" href="${contextPath}/common/css/main.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${contextPath}/common/js/base/html5.js"></script>
<![endif]-->
<style type="text/css">
	.l-table-edit{line-height: 40px;}
	.l-button{margin-top: 20px;height: 25px;}
</style>
</head>
<!-- edit.jsp -->
<body style="padding: 10px;">
	<form action="${contextPath }/corp/editSave" id="editCorpForm" name="editCorpForm" method="post">
		<input type="hidden" id="uid" name="uid" value="${corp.uid }"/>
		<input type="hidden" id="dcreatetime" name="dcreatetime" value="${corp.dcreatetime }"/>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td"><font class="redStar">*</font>公司代码:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="ccode" name="ccode" value="${corp.ccode }" class="validate[required,minSize[6],maxSize[20],funcCall[checkCorpCode]] l-text"/></td>
				<td align="right" class="l-table-edit-td"><font class="redStar">*</font>公司名称:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cname" name="cname" value="${corp.cname }" class="validate[required,minSize[2],maxSize[50],funcCall[checkCorpName]] l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">英文名称:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cnameen" name="cnameen" value="${corp.cnameen }" class="validate[custom[onlyLetterNumber],maxSize[50]] l-text"/></td>
				<td align="right" class="l-table-edit-td">公司简称:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cnameab" name="cnameab" value="${corp.cnameab }" class="validate[maxSize[50]] l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"><font class="redStar">*</font>公司负责人:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cprincipal" name="cprincipal" value="${corp.cprincipal }" class="validate[required,minSize[2],maxSize[20]] l-text"/></td>
				<td align="right" class="l-table-edit-td">&nbsp;&nbsp;税务登记号:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="ctaxno" name="ctaxno" value="${corp.ctaxno }" class="validate[custom[number]] l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td"><font class="redStar">*</font>公司地址:&nbsp;&nbsp;</td>
				<td colspan="3" align="left" class="l-table-edit-td"><textarea cols="100" rows="2" class="validate[required,maxSize[100]] l-textarea" id="caddr" name="caddr" style="width:400px">${corp.caddr }</textarea></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">邮编:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="czip" name="czip" value="${corp.czip }" class="validate[custom[number],minSize[6],maxSize[6]] l-text"/></td>
				<td align="right" class="l-table-edit-td">传真号:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cfax" name="cfax" value="${corp.cfax }" class="validate[custom[phone]] l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">总机电话:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="ctelgeneral" name="ctelgeneral" value="${corp.ctelgeneral }" class="validate[custom[phone]] l-text"/></td>
				<td align="right" class="l-table-edit-td">值班电话:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="ctelguard" name="ctelguard" value="${corp.ctelguard }" class="validate[custom[phone]] l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">电子邮件:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cemail" name="cemail" value="${corp.cemail }" class="validate[custom[email]] l-text"/></td>
				<td align="right" class="l-table-edit-td">网站地址:&nbsp;&nbsp;</td>
				<td align="left" class="l-table-edit-td"><input type="text" id="cwebsite" name="cwebsite" value="${corp.cwebsite }" class="validate[custom[url]] l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">所在城市:&nbsp;&nbsp;</td>
				<td colspan="3" align="left" class="l-table-edit-td"><input type="text" id="ccity" name="ccity" value="${corp.ccity }" class="l-text"/></td>
			</tr>
			<tr>
				<td align="right" class="l-table-edit-td">公司备注:&nbsp;&nbsp;</td>
				<td colspan="3" align="left" class="l-table-edit-td"><textarea cols="100" rows="4" class="validate[maxSize[100]] l-textarea" id="cmemo" name="cmemo" style="width:400px">${corp.cmemo }</textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="更新" class="l-button" onclick="submitForm()"/> 
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">var contextPath = '${contextPath}';var updateOK = '${updateOK}';var oldCode = '${corp.ccode}';var oldName = '${corp.cname}';</script>
	<script type="text/javascript" src="${contextPath}/common/js/base/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${contextPath}/common/liger/js/ligerui.all.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine-zh_CN.js"></script>
	<script type="text/javascript" src="${contextPath}/common/formValidator2.2.4/jquery.validationEngine.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/base.js"></script>
	<script type="text/javascript" src="${contextPath}/common/js/corp/edit.js"></script>
</body>
</html>