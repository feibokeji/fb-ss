<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>可爱雪-物料入库</title>
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
    	<div position="left" title="单据">
    		<ul id="tree1"></ul>
    	</div>
        <div position="center" title="物料入库单" style="overflow: scroll;">
        	<div id="add_div" style="display: none;">
	        	<!-- 订单详细内容 -->
	        	<form id="addOrderForm" name="addOrderForm" method="post" action="${contextPath }/bpr/lovelysnow/saveOrderMaterial">
	        		<input type="hidden" id="cstatus" name="cstatus" value="00"/>
	        		<table style="margin: 0 auto;border: 1px solid #eeeeee;width: 98%;line-height: 45px;">
	        			<tr>
	        				<td colspan="11" align="center"><h2>物料入库单</h2></td>
	        			</tr>
	        			<tr>
	        				<td align="right" width="60px">日期：</td>
	        				<td align="left" width="100px"><input type="text" id="dordertime" name="dordertime" class="validate[required]"/></td>
	        				<td align="right" width="60px">操作人：</td>
	        				<td align="left" width="100px"><label style="border-bottom: 1px solid #bbbbbb;">&nbsp;&nbsp;&nbsp;${user.cname }&nbsp;&nbsp;&nbsp;</label></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        			</tr>
	        			<tr>
	        				<td colspan="11" align="center" style="border-bottom: 1px solid #eeeeee;"></td>
	        			</tr>
	        			<tr>
	        				<td colspan="11">
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
	        			<tr style="line-height: 18px;">
	        				<td colspan="11">
	        					<table style="margin: 0 auto;width: 100%;" class="listTable">
	        						<tr>
	        							<td width="40px"></td>
				        				<td width="101px"></td>
				        				<td width="61px"></td>
				        				<td width="60px" align="right">合计:</td>
				        				<td width="60px" align="right"><label id="totalAmount">0</label></td>
				        				<td width="60px"></td>
				        				<td></td>
				        				<td></td>
				        				<td></td>
				        				<td></td>
				        				<td></td>
	        						</tr>
	        					</table>
	        				</td>
	        			</tr>
	        			<tr>
	        				<td colspan="11" style="border-top: 1px solid #eeeeee;line-height: 45px;">
	        					<input type="button" value="+添加数据行" onclick="addLine('detailsTable')" class="l-button"/>
	        					<input type="button" value="保存" class="l-button" onclick="submitForm('addOrderForm')"/>
	        				</td>
	        			</tr>
	        		</table>
	        	</form>
        	</div>
        	<!-- 查看 -->
        	<div id="view_div" style="display: none;">
        		<img src="" alt="" id="seal" class="seal_img"/>
        		<table style="margin: 0 auto;border: 1px solid #eeeeee;width: 98%;line-height: 45px;">
	        			<tr>
	        				<td colspan="11" align="center"><h2>物料入库单</h2></td>
	        			</tr>
	        			<tr>
	        				<td align="right" width="60px">日期：</td>
	        				<td align="left" width="100px"><fmt:formatDate value="${order.dordertime }" pattern="yyyy-MM-dd"/></td>
	        				<td align="right" width="60px">操作人：</td>
	        				<td align="left" width="100px">${user.cname }</td>
	        				<td align="right" width="60px">编号：</td>
	        				<td align="left" width="100px">${order.cno }</td>
	        				<td><input type="hidden" id="v_h_cstatus" value="${order.cstatus }"/></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        				<td></td>
	        			</tr>
	        			<tr>
	        				<td colspan="11" align="center" style="border-bottom: 1px solid #eeeeee;"></td>
	        			</tr>
	        			<tr>
	        				<td colspan="11">
	        					<table id="detailsTable" style="margin: 0 auto;width: 100%;" class="listTable">
	        						<tr>
	        							<th width="40px">序号</th>
	        							<th width="100px">物料</th>
	        							<th width="60px">价格(元)</th>
	        							<th width="60px">数量(小)</th>
	        							<th width="60px">金额(元)</th>
	        							<th width="60px"></th>
	        							<th></th>
	        							<th></th>
	        							<th></th>
	        							<th></th>
	        							<th></th>
	        						</tr>
	        						<c:set var="totalNamount" value="0"></c:set>
	        						<c:forEach items="${orderMaterialList }" var="detail">
	        							<tr>
	        								<td>${detail.isort }</td>
	        								<td>${detail.cmaterialname }</td>
	        								<td align="right">${detail.nprice }</td>
	        								<td align="right">${detail.nqty }</td>
	        								<td align="right">${detail.namount }</td>
	        								<td><c:set var="totalNamount" value="${totalNamount + detail.namount }"></c:set></td>
	        								<td></td>
	        								<td></td>
	        								<td></td>
	        								<td></td>
	        								<td></td>
	        							</tr>
	        						</c:forEach>
	        						<tr>
	        							<td width="40px"></td>
				        				<td width="101px"></td>
				        				<td width="61px"></td>
				        				<td width="60px" align="right">合计:</td>
				        				<td width="60px" align="right"><label>${totalNamount }</label></td>
				        				<td width="60px"></td>
				        				<td></td>
				        				<td></td>
				        				<td></td>
				        				<td></td>
				        				<td></td>
	        						</tr>
	        					</table>
	        				</td>
	        			</tr>
	        			<tr>
	        				<td colspan="11" align="center">
	        					<c:if test="${order.cstatus eq '00'}">
	        						<input type="button" style="margin-top: 20px;margin-bottom: 20px;margin-right: 20px;" value="审核" class="l-button" onclick="f_v_audit('${order.uid}')"/>
	        					</c:if>
	        					<c:if test="${order.cstatus eq '01'}">
	        						<input type="button" style="margin-top: 20px;margin-bottom: 20px;margin-right: 20px;" value="反审核" class="l-button" onclick="f_v_not_audit('${order.uid}')"/>
	        					</c:if>
	        					<input type="button" style="margin-top: 20px;margin-bottom: 20px;" value="新增单据" class="l-button" onclick="openAdd()"/>
	        				</td>
	        			</tr>
	        		</table>
        	</div>
        </div>  
    </div> 
	<!-- javascript文件引用 -->
	<script type="text/javascript">var contextPath = '${contextPath}';var type = '${type}';</script>
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