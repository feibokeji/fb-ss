/**
 * 可爱雪-物料入库单
 */
var totalNumber = 0;//记录数据数量[包含已被删除的数据量]
var box_data = null;
var actionNodeID = null;
$(function(){
	//页面布局
	$("#layout1").ligerLayout({ leftWidth: 220});
	//左侧树形数据
	menu1 = $.ligerMenu({//未审核单据右键菜单 
		top: 100,
		left: 100, 
		width: 120, 
		items:[{ text:'审核',click:f_Audit,icon:'right'},{ text:'修改',click:f_Modify,icon:'modify'},{text:'查看',click:f_View,icon:'view'}]
    });
	menu2 = $.ligerMenu({//已审核单据右键菜单 
		top: 100,
		left: 100, 
		width: 120, 
		items:[{ text: '反审核',click:f_n_Audit, icon: 'right'},{ text:'查看',click:f_View,icon:'view'}]
    });
    var tree = $("#tree1").ligerTree({
    	url:contextPath+"/bpr/lovelysnow/getOrderMaterialGroup",
    	nodeWidth:180,
        idFieldName :'id',
        slide : false,
        parentIDFieldName :'pid',
        checkbox: false,
        onContextmenu: function (node, e){
        	actionNodeID = node.data.id;
        	var isAudit = node.data.text.indexOf('未审核');
        	if(node.data.pid != '0'){
        		if(isAudit > 0)
        			menu1.show({ top: e.pageY, left: e.pageX });
        		else
        			menu2.show({ top: e.pageY, left: e.pageX });
        	}
            return false;
        }
    });
    manager = $("#tree1").ligerGetTreeManager();
    
    ////////////////////////右侧
    if(type == "add"){
    	$("#add_div").show();
    	//添加表单验证
        $("#addOrderForm").validationEngine();
        //添加日历控件
    	$("#dordertime").ligerDateEditor();
        //默认加载10行数据
    	totalNumber = 10;
    	//加载数据行
    	loadLine("detailsTable",totalNumber);
    }else if(type == "view"){
    	$("#view_div").show();
    	var v_cstatus = $("#v_h_cstatus").val();
    	var img_url = "";
    	if(v_cstatus == "00"){
    		img_url = contextPath+"/common/images/not_audit.png";
    	}else if(v_cstatus == "01"){
    		img_url = contextPath+"/common/images/audit.png";
    	}
    	$("#seal").attr("src",img_url).show();
    }
});
/**
 * 审核订单
 * @param item
 * @param i
 */
function f_Audit(item,i){
	$.ligerDialog.confirm("确定要审核吗？",function(yes){
		if(yes){
			if(audit(actionNodeID,'01')){
				$.ligerDialog.success("审核成功!");
				manager.reload();
			}
			else
				$.ligerDialog.error("审核失败!");
		}
	});
}
/**
 * 反审核
 * @param item
 * @param i
 */
function f_n_Audit(item,i){
	$.ligerDialog.confirm("确定要反审核吗？",function(yes){
		if(yes){
			if(audit(actionNodeID,'00')){
				$.ligerDialog.success("反审核成功!");
				manager.reload();
			}
			else
				$.ligerDialog.error("反审核失败!");
		}
	});
}
/**
 * 查看页面审核功能
 * @param uid
 */
function f_v_audit(uid){
	$.ligerDialog.confirm("确定要审核吗？",function(yes){
		if(yes){
			if(audit(uid,'01')){
				$.ligerDialog.success("审核成功!");
				window.location.href = contextPath + "/bpr/lovelysnow/procurement?type=view&uid="+uid;
			}
			else
				$.ligerDialog.error("审核失败!");
		}
	});
}
/**
 * 查看页面反审核功能
 * @param uid
 */
function f_v_not_audit(uid){
	$.ligerDialog.confirm("确定要反审核吗？",function(yes){
		if(yes){
			if(audit(uid,'00')){
				$.ligerDialog.success("反审核成功!");
				window.location.href = contextPath + "/bpr/lovelysnow/procurement?type=view&uid="+uid;
			}
			else
				$.ligerDialog.error("反审核失败!");
		}
	});
}
function audit(uid,cstatus){
	var result = false;
	var waitting;
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/auditOrder",
		data:{'uid':uid,'cstatus':cstatus},
		dataType:"html",
		beforeSend:function(){
			waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
		},
		success:function(data){
			waitting.close();
			result = data;
		}
	});
	return result;
}
/**
 * 修改订单
 * @param item
 * @param i
 */
function f_Modify(item,i){
	
}
/**
 * 查看
 * @param item
 * @param i
 */
function f_View(item,i){
	window.location.href = contextPath + "/bpr/lovelysnow/procurement?type=view&uid="+actionNodeID;
}
function openAdd(){
	window.location.href = contextPath + "/bpr/lovelysnow/procurement?type=add";
}
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitForm(_form){
	var form = $("#"+_form);
	if(form.validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				$.ligerDialog.confirm("如果您确定此单据正确无误，您可以选择\'是\'直接审核；\n如您不确定是否正确无误，您可以选择\'否\'不审核保存。",function(y){
					if(y){
						$("#cstatus").val("01");
					}
					var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
					form.ajaxSubmit(function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("保存失败!");
						else if(data == "nHave"){
							$.ligerDialog.error("无数据无法保存!");
						}else{
							$.ligerDialog.success("保存成功!");
							clearLine();
							manager.reload();
						}
					});
				});
			}
		});
	}
}
/**
 * 加载数据行
 * 
 * @param elementId 元素id
 * @param number 行数
 */
function loadLine(elementId, number) {
	for(var i = 1; i <= number; i++){
		$("#" + elementId).append(createLine(i));
		var _element = "addOrderDetail_" + i + "_cmaterialname";
		loadAutoComplete(_element,i);
		calculateTotalAmount();
	}
}
/**
 * 添加数据行
 * @param elementId 元素id
 */
function addLine(elementId){
	//更新数据量
	totalNumber = totalNumber + 1;
	//添加数据行
	$("#" + elementId).append(createLine(totalNumber));
	//数据行添加时间
	var _element = "addOrderDetail_" + totalNumber + "_cmaterialname";
	loadAutoComplete(_element,totalNumber);
	//更新序号
	updateLineSerialNumber(elementId);
	calculateTotalAmount();
}
/**
 * 更新数据行序号
 * @param elementId 元素id
 */
function updateLineSerialNumber(elementId){
	var _label = $("#" + elementId + " tr td label");
	_label.each(function(i){
		$(this).text((i+1));
	});
}
/**
 * 删除数据行
 * @param elementId 元素id
 */
function deleteLine(parentElementId,elementId){
	$("#" + elementId).remove();
	updateLineSerialNumber(parentElementId);
	calculateTotalAmount();
}
/**
 * 创建数据行
 * @param i
 * @returns {String}
 */
function createLine(i){
	var _line = "<tr id='dataLineTr"+i+"'>" +
					"<td><label>"+i+"</label></td>" +//:序号
					"<td><input type='hidden' id='addOrderDetail_"+i+"_umaterialid' name='orderMaterialDetailList["+i+"].umaterialid'/><input type='text' id='addOrderDetail_"+i+"_cmaterialname' name='orderMaterialDetailList["+i+"].cmaterialname' style='width: 100px;'/></td>" +//:名称
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nprice' name='orderMaterialDetailList["+i+"].nprice' onchange='updateLineAmount("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:价格
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nqty' name='orderMaterialDetailList["+i+"].nqty' onchange='updateLineAmount("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:数量
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_namount' name='orderMaterialDetailList["+i+"].namount' onchange='updateLinePrice("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:金额
					"<td><a href='javascript:deleteLine(\"detailsTable\",\"dataLineTr"+i+"\")' title='删除' style='text-decoration:none;color:black;'>-</a></td>" +//:操作
					"<td></td><td></td><td></td><td></td><td></td>" +
				"</tr>";
	return _line;
}
/**
 * 加载自动填充
 * @param elementId
 * @param number
 */
function loadAutoComplete(elementId,_number){
	$("#" + elementId).ligerComboBox({
		slide: false,
		width:100,
		height:18,
        selectBoxWidth: 400, 
        selectBoxHeight: 220,
        valueField:'uid',
        textField:'cname',
        grid:getGridOptions(false),
        onSelected: function (value){
        	if(box_data != null){
        		for(var i = 0; i < box_data["Rows"].length;i++){
        			if(box_data["Rows"][i].uid == value){
        				$("#addOrderDetail_" + _number + "_umaterialid").val(value);//:物料主键
        				$("#addOrderDetail_" + _number + "_cmaterialname").val(box_data["Rows"][i].cname);//:物料名称
        				$("#addOrderDetail_" + _number + "_nprice").val(box_data["Rows"][i].nprice);//:物料价格
        				$("#addOrderDetail_" + _number + "_nqty").val(1);//:物料数量
        				$("#addOrderDetail_" + _number + "_namount").val(box_data["Rows"][i].nprice);//:物料金额
        				calculateTotalAmount();
        			}
        		}
        	}
        }
	});
}
/**
 * 表格数据渲染参数
 * @param checkbox 是否启用复选框
 * @returns options 
 */
function getGridOptions(checkbox){
	var options = {
			columns: [
			            { dispaly:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
			            { display: '编码', name: 'cno', align: 'left', width: 60, minWidth: 60 },
			            { display: '名称', name: 'cname', width: 100,minWidth: 60 },
			            { display: '规格', name: 'cspecifications', width: 60,minWidth: 60 },
			            { display: '价格', name: 'nprice', width: 60,minWidth: 60 }
			            ], 
			            switchPageSizeApplyComboBox: false,
			            url:contextPath + "/bpr/lovelysnow/listMaterial",
			            pageSize:5,
			            rownumbers:true,
			            pageSizeOptions:[5],
			            onReload:false,
			            dataAction:"local",
			            selectRowButtonOnly:true,
			            enabledSort:false,
			            onSuccess: f_boxSuccess,
			            checkbox:checkbox
	};
	return options;
}
/**
 * 数据加载完成
 * @param data
 */
function f_boxSuccess(data){
	box_data = data;
}
/**
 * 更新金额
 * @param number
 */
function updateLineAmount(number){
	var nprice = $("#addOrderDetail_" + number + "_nprice");//:价格
	var nqty = $("#addOrderDetail_" + number + "_nqty");//:数量
	var namount = $("#addOrderDetail_" + number + "_namount");//:金额
	_amount = parseFloat(parseFloat(nprice.val()) * parseFloat(nqty.val())).toFixed(2);
	namount.val(_amount);
	calculateTotalAmount();
}
/**
 * 更新价格
 * @param number
 */
function updateLinePrice(number){
	var nprice = $("#addOrderDetail_" + number + "_nprice");//:价格
	var nqty = $("#addOrderDetail_" + number + "_nqty");//:数量
	var namount = $("#addOrderDetail_" + number + "_namount");//:金额
	_price = parseFloat(parseFloat(namount.val()) / parseFloat(nqty.val())).toFixed(2);
	nprice.val(_price);
	calculateTotalAmount();
}
/**
 * 计算总金额
 */
function calculateTotalAmount(){
	var totalAmount = 0;
	for(var i = 1; i <= totalNumber; i++){
		var _amount = $("#addOrderDetail_" + i + "_namount").val();
		if(_amount == undefined || _amount == "" || isNaN(_amount))
			_amount = 0;
		totalAmount += parseFloat(_amount);
	}
	$("#totalAmount").text(totalAmount.toFixed(2));
}
/**
 * 初始化页面数据
 */
function clearLine(){
	$("#dordertime").val("");
	for(var i = 1;i <= totalNumber;i++){
		$("#addOrderDetail_" + i + "_umaterialid").val("");//:物料主键
		$("#addOrderDetail_" + i + "_cmaterialname").val("");//:物料名称
		$("#addOrderDetail_" + i + "_nprice").val("");//:物料价格
		$("#addOrderDetail_" + i + "_nqty").val("");//:物料数量
		$("#addOrderDetail_" + i + "_namount").val("");//:物料金额
		calculateTotalAmount();
	}
}