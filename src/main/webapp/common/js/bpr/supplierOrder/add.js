/**
 * 新增供应商单据JavaScript
 */
var totalNumber = 0;//记录数据数量[包含已被删除的数据量]
var lineNumber = 0;
var box_data = null;
var chooseOtherGoodsDialog = null;
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
					"<td><input type='text' style='width: 80px;height:18px;text-align:center;border:none;' id='addOrderDetail_"+i+"_ccategoryname' name='orderDetailList["+i+"].ccategoryname'/></td>" + //类别
					"<td><input type='text' style='width: 80px;height:18px;text-align:center;border:none;' id='addOrderDetail_"+i+"_cbrandname' name='orderDetailList["+i+"].cbrandname'/></td>" + //品牌
					"<td><input type='hidden' id='addOrderDetail_"+i+"_uothergoodsid' name='orderDetailList["+i+"].uothergoodsid'/><input type='text' id='addOrderDetail_"+i+"_cname' name='orderDetailList["+i+"].cname' style='width: 100px;'/></td>" +//:名称
					"<td><input type='text' style='width: 60px;height:18px;text-align:center;border:none;' id='addOrderDetail_"+i+"_cunitname' name='orderDetailList["+i+"].cunitname'/></td>" + //单位
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nquantity' name='orderDetailList["+i+"].nquantity' onchange='updateLineAmount("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:数量
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nprice' name='orderDetailList["+i+"].nprice' onchange='updateLineAmount("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:价格
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_namount' name='orderDetailList["+i+"].namount' onchange='updateLinePrice("+i+")' class='validate[custom[number],min[0]]'/></td>" +//:金额
					"<td><a href='javascript:deleteLine(\"detailsTable\",\"dataLineTr"+i+"\")' title='删除' style='text-decoration:none;color:black;'>-</a></td>" +//:操作
					"<td></td><td></td>" +
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
        				$("#addOrderDetail_" + _number + "_ccategoryname").val(box_data["Rows"][i].ccategoryname);//:类别
        				$("#addOrderDetail_" + _number + "_cbrandname").val(box_data["Rows"][i].cbrandname);//:品牌
        				$("#addOrderDetail_" + _number + "_uothergoodsid").val(value);//:商品主键
        				$("#addOrderDetail_" + _number + "_cname").val(box_data["Rows"][i].cname);//:商品名称
        				$("#addOrderDetail_" + _number + "_cunitname").val(box_data["Rows"][i].cunitname);//:单位
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
	for(var i = 1; i <= findMaxIndex(); i++){
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
	totalNumber = findMaxIndex() + 1;
	//添加数据行
	$("#" + elementId).append(createLine(totalNumber));
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
	for(var i = 1;i <= findMaxIndex();i++){
		$("#addOrderDetail_" + i + "_ccategoryname").val("");
		$("#addOrderDetail_" + i + "_cbrandname").val("");
		$("#addOrderDetail_" + i + "_uothergoodsid").val("");
		$("#addOrderDetail_" + i + "_cname").val("");
		$("#addOrderDetail_" + i + "_cunitname").val("");
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
	for(var i = 1; i <= findMaxIndex(); i++){
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
								clearLine();
							}
						});
					});
				}
			});
		}else
			$.ligerDialog.warn("请填写有效数据！再进行保存。");
	}
}
//选择商品信息
function chooseOtherGoods(){
	chooseOtherGoodsDialog = $.ligerDialog.open({url:contextPath+"/bpr/otherGoods/choose",title:"选择商品",allowClose:true,width:1000,height:480,
		buttons:[{text:"导入",onclick:function(i,d){
			//console.log(chooseOtherGoodsDialog.frame.otherGoodsTable.getSelectedRows());
			var selectedRows = chooseOtherGoodsDialog.frame.otherGoodsTable.getSelectedRows();
			if(selectedRows.length > 0){
				loadChooseOtherGoods(selectedRows);
			}else
				$.ligerDialog.error("请选择商品后，再进行导入！");
		}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
//计算有效数据行
function calculateValidLine(){
	var line = 0;
	for(var i = 1; i <= findMaxIndex(); i++){
		var _element = "addOrderDetail_" + i + "_uothergoodsid";
		var _value = $("#" + _element).val();
		if(_value != null && _value != undefined && _value != "")
			line++;
	}
	return line;
}
//查找最大数据行最大下标
function findMaxIndex(){
	var max = 0;
	$("#detailsTable tr").each(function(i){
		if(i != 0 && $(this).attr("id") != null && $(this).attr("id") != undefined && $(this).attr("id") != ""){
			$(this).find("input").each(function(){
				var id = $(this).attr("id").split("_");
				if(id.length > 2)
					max = id[1];
			});
		}
	});
	return parseInt(max);
}
//加载选择的商品信息
function loadChooseOtherGoods(selectedRows){
	// 有效显示的行
	var validTotalNumber = $("#detailsTable tr").length - 1;
	// 所选商品量
	var rowsLength = selectedRows.length;
	// 有效数据行
	var validLine = calculateValidLine();
	// 最大数据行下标
	var maxIndex = findMaxIndex();
	
	if(validTotalNumber < (rowsLength + validLine)){
		for(var i = 0; i < (rowsLength + validLine) - validTotalNumber; i++){
			maxIndex++;
			$("#detailsTable").append(createLine(maxIndex));
			var _element = "addOrderDetail_" + maxIndex + "_cname";
			loadAutoComplete(_element,maxIndex);
			updateLineSerialNumber("detailsTable");
			calculateTotalAmount();
		}
	}
	var data_i = 0;
	$("#detailsTable tr").each(function(i){
		if(i != 0 && i > validLine){
			var isPrint = false;
			$(this).find("input").each(function(){
				if($(this).attr("id").indexOf("_uothergoodsid") > 0){
					isPrint = true;
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].uid);
					}
				}
				if($(this).attr("id").indexOf("_ccategoryname") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].ccategoryname);
					}
				}
				if($(this).attr("id").indexOf("_cbrandname") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].cbrandname);
					}
				}
				if($(this).attr("id").indexOf("_cname") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].cname);
					}
				}
				if($(this).attr("id").indexOf("_cunitname") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].cunitname);
					}
				}
				if($(this).attr("id").indexOf("_nprice") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].ncostprice);
					}
				}
				if($(this).attr("id").indexOf("_nquantity") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(1);
					}
				}
				if($(this).attr("id").indexOf("_namount") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == ""){
						$(this).val(selectedRows[data_i].ncostprice);
					}
				}
				
			});
			if(isPrint)
				data_i++;
		}
	});
	updateLineSerialNumber("detailsTable");
	calculateTotalAmount();
}