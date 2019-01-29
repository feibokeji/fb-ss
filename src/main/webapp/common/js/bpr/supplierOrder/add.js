/**
 * 新增供应商单据JavaScript
 */
var totalNumber = 0;//记录数据数量[包含已被删除的数据量]
var lineNumber = 0;
var box_data = null;
$(function(){
	//单据类型
	switch (itype) {
	case 0:
		$("#titleH2").text("商品入库单");
		break;
	case 1:
		$("#titleH2").text("商品退库单");
		break;
	case 2:
		$("#titleH2").text("商品报损单");
		break;
	default:
		$("#titleH2").text("商品入库单");
		break;
	}
	$("#addOrderForm").validationEngine('attach', { 
		 promptPosition: 'bottomRight',scroll:false
	});
	$("#addCsuppliername").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/supplier/getSupplierJSON",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addUsupplierid").val(value);
		}
	});
	$("#addDrecordateStr").ligerDateEditor();
	totalNumber = lineNumber;
	totalNumber = totalNumber + 10;
	loadLine("detailsTable",totalNumber);
});
/**
 * 创建行
 * @param i
 * @returns {String}
 */
function createLine(i){
	var _line = "<tr id='dataLineTr"+i+"'>" +
					"<td><label>"+i+"</label></td>" +//:序号
					"<td><input type='hidden' id='addOrderDetail_"+i+"_uothergoodsid' name='orderDetailList["+i+"].uothergoodsid'/><input type='text' id='addOrderDetail_"+i+"_cname' name='orderDetailList["+i+"].cname' style='width: 100px;'/></td>" +//:名称
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nprice' name='orderDetailList["+i+"].nprice' onchange='updateLineAmount("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:价格
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nquantity' name='orderDetailList["+i+"].nquantity' onchange='updateLineAmount("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:数量
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_namount' name='orderDetailList["+i+"].namount' onchange='updateLinePrice("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:金额
					"<td><a href='javascript:deleteLine(\"detailsTable\",\"dataLineTr"+i+"\")' title='删除' style='text-decoration:none;color:black;'>-</a></td>" +//:操作
					"<td></td><td></td><td></td><td></td><td></td>" +
				"</tr>";
	return _line;
}
/**
 * 数据加载完成
 * @param data
 */
function f_boxSuccess(data){
	box_data = data;
}
/**
 * 表格数据渲染参数
 * @param checkbox 是否启用复选框
 * @returns options 
 */
function getGridOptions(checkbox){
	var options = {
			columns: [
				{ display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
				{ display: '类别', name: 'ccategoryname', width: 100, minWidth: 80 },
				{ display: '品牌', name: 'cbrandname', width: 100,minWidth: 80 },
	            { display: '编号', name: 'cno', width: 120,minWidth: 100 },
	            { display: '条形码', name: 'cbarcode', width: 120,minWidth: 100 },
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 },
	            { display: '全称', name: 'cfullname', width: 160,minWidth: 140 },
	            { display: '助记码', name: 'cmnemoniccode', width: 100,minWidth: 80 },
	            { display: '规格', name: 'cspecifications', width: 180,minWidth: 160 },
	            { display: '单位', name: 'cunitname', width: 100,minWidth: 80 },
	            { display: '进货价(元)', name: 'ncostprice', width: 100,minWidth: 80 },
	            { display: '销售价(元)', name: 'nretailprice', width: 100,minWidth: 80 },
	            { display: '保修时间(天)', name: 'iwarrantyday', width: 100,minWidth: 80 },
	            { display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80 },
	            { display: '积分', name: 'iintegral', width: 80,minWidth: 60 },
	            { display: '记录日期', name: 'drecorddateStr', width: 120,minWidth: 100 },
	            { display: '更新日期', name: 'dupdatedateStr', width: 120,minWidth: 100 }
	        ], 
			switchPageSizeApplyComboBox: false,
			url:contextPath + "/bpr/otherGoods/getOtherGoodsJSON",
			onSuccess: f_boxSuccess,
			checkbox:checkbox
	};
	return options;
}
/**
 * 加载自动填充
 * @param elementId
 * @param number
 */
function loadAutoComplete(elementId,_number){
	$("#" + elementId).ligerComboBox({
		slide: false,
		width:200,
		height:18,
        selectBoxWidth: 600, 
        selectBoxHeight: 320,
        valueField:'uid',
        textField:'cname',
        autocomplete:true,
        grid:getGridOptions(false),
        condition: { fields: [{ name: 'cname', label: '名称', width: 180, type: 'text' }] },
        conditionSearchClick: function (e){
            if(e.rules != undefined && e.rules != null && e.rules.length > 0){
            	var parmValue = e.rules[0].value;
            	e.grid.set('parms', { cname: parmValue });
            }else
            	e.grid.set('parms', { cname: "" });
            e.grid.reload();
        },
        onSelected: function (value){
        	if(box_data != null){
        		for(var i = 0; i < box_data["Rows"].length;i++){
        			if(box_data["Rows"][i].uid == value){
        				$("#addOrderDetail_" + _number + "_uothergoodsid").val(value);//:商品主键
        				$("#addOrderDetail_" + _number + "_cname").val(box_data["Rows"][i].cname);//:商品名称
        				$("#addOrderDetail_" + _number + "_nprice").val(box_data["Rows"][i].ncostprice);//:商品进货价
        				$("#addOrderDetail_" + _number + "_nquantity").val(1);//:商品数量
        				$("#addOrderDetail_" + _number + "_namount").val(box_data["Rows"][i].ncostprice);//:商品金额
        				calculateTotalAmount();
        			}
        		}
        	}
        }
	});
}
/**
 * 更新金额
 * @param number
 */
function updateLineAmount(number){
	var nprice = $("#addOrderDetail_" + number + "_nprice");//:价格
	var nquantity = $("#addOrderDetail_" + number + "_nquantity");//:数量
	var namount = $("#addOrderDetail_" + number + "_namount");//:金额
	_amount = parseFloat(parseFloat(nprice.val()) * parseFloat(nquantity.val())).toFixed(2);
	namount.val(_amount);
	calculateTotalAmount();
}
/**
 * 更新价格
 * @param number
 */
function updateLinePrice(number){
	var nprice = $("#addOrderDetail_" + number + "_nprice");//:价格
	var nquantity = $("#addOrderDetail_" + number + "_nquantity");//:数量
	var namount = $("#addOrderDetail_" + number + "_namount");//:金额
	_price = parseFloat(parseFloat(namount.val()) / parseFloat(nquantity.val())).toFixed(2);
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
 * 加载数据行
 * 
 * @param elementId 元素id
 * @param number 行数
 */
function loadLine(elementId, number) {
	for(var i = lineNumber + 1; i <= number; i++){
		$("#" + elementId).append(createLine(i));
		var _element = "addOrderDetail_" + i + "_cname";
		loadAutoComplete(_element,i);
		calculateTotalAmount();
	}
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
 * 添加数据行
 * @param elementId 元素id
 */
function addLine(elementId){
	//更新数据量
	totalNumber = totalNumber + 1;
	//添加数据行
	$("#" + elementId).append(createLine(totalNumber));
	//数据行添加时间
	var _element = "addOrderDetail_" + totalNumber + "_cname";
	loadAutoComplete(_element,totalNumber);
	//更新序号
	updateLineSerialNumber(elementId);
	calculateTotalAmount();
}
/**
 * 初始化页面数据
 */
function clearLine(){
	for(var i = 1;i <= totalNumber;i++){
		$("#addOrderDetail_" + i + "_uothergoodsid").val("");
		$("#addOrderDetail_" + i + "_cname").val("");
		$("#addOrderDetail_" + i + "_nprice").val("");
		$("#addOrderDetail_" + i + "_nquantity").val("");
		$("#addOrderDetail_" + i + "_namount").val("");
		calculateTotalAmount();
	}
}
/**
 * 验证是否有数据
 * @returns
 */
function validData(){
	for(var i = 1; i <= totalNumber; i++){
		var _element = "addOrderDetail_" + i + "_uothergoodsid";
		var _value = $("#" + _element).val();
		if(_value != null && _value != undefined && _value != "")
			return true;
	}
	return false;
}
/**
 * 提交表单
 * @returns
 */
function submitForm(){
	if($("#addOrderForm").validationEngine("validate")){
		if(validData()){
			$.ligerDialog.confirm("确定要保存吗？",function(yes){
				if(yes){
					$.ligerDialog.confirm("如果您确定此单据正确无误，您可以选择\'是\'直接审核；\n如您不确定是否正确无误，您可以选择\'否\'不审核保存。",function(y){
						if(y)
							$("#addIstatus").val("0");
						else
							$("#addIstatus").val("1");
						var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
						$("#addOrderForm").ajaxSubmit(function(data){
							waitting.close();
							if(data == "fail")
								$.ligerDialog.error("保存失败!");
							else if(data == "nHave"){
								$.ligerDialog.error("无数据无法保存!");
							}else{
								$.ligerDialog.success("保存成功!");
								//window.location.href = contextPath + "/bpr/supplierOrder/add?itype=" + itype;
								clearLine();
								//manager.reload();
							}
						});
					});
				}
			});
		}else
			$.ligerDialog.warn("请填写有效数据！再进行保存。");
	}
}