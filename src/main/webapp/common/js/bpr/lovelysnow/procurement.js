/**
 * 可爱雪-物料入库单
 */
var data = [];
var totalNumber = 0;//记录数据数量[包含已被删除的数据量]
var box_data = null;
$(function(){
	$("#layout1").ligerLayout({ leftWidth: 150});
	data.push({ id: 1, pid: 0, text: '2016-05-01' });
    data.push({ id: 2, pid: 1, text: '01' });
    data.push({ id: 3, pid: 1, text: '02' });
    data.push({ id: 4, pid: 1, text: '03' });      

    data.push({ id: 5, pid: 0, text: '2016-05-02' });
    data.push({ id: 6, pid: 5, text: '04' });
    data.push({ id: 7, pid: 5, text: '05' });

    var tree = $("#tree1").ligerTree({  
    	data:data, 
        idFieldName :'id',
        slide : false,
        parentIDFieldName :'pid',
        checkbox: false
    });
    treeManager = $("#tree1").ligerGetTreeManager();
    treeManager.collapseAll();
    
    $("#addOrderForm").validationEngine();
    //添加日历控件
	$("#dordertime").ligerDateEditor();
    //默认加载10行数据
	totalNumber = 10;
	loadLine("detailsTable",totalNumber);
});
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitForm(_form){
	var form = $("#"+_form);
	if(form.validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				form.ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else{
						$.ligerDialog.success("保存成功!");
						clearLine();
					}
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
					"<td><a href='javascript:deleteLine(\"detailsTable\",\"dataLineTr"+i+"\")' title='删除'><img src='"+contextPath+"/common/images/delete-row.gif'/></a></td>" +//:操作
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
			            { display: '名称', name: 'cname', width: 60,minWidth: 60 },
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