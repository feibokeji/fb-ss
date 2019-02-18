/**
 * 新增供应商手机单据JavaScript
 */
var totalNumber = 0;//记录数据数量[包含已被删除的数据量]
var lineNumber = 0;
var box_data = null;
var choosePhoneDialog = null;
$(function(){
	//单据类型
	switch (itype) {
	case 0:
		$("#titleH2").text("手机入库单");
		break;
	case 1:
		$("#titleH2").text("手机退库单");
		break;
	default:
		$("#titleH2").text("手机入库单");
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
					"<td><label name='lineNumber'>"+i+"</label></td>" +//:序号
					"<td><label id='addOrderDetail_"+i+"_cbrandname'></label></td>" +//:品牌
					"<td><input type='hidden' id='addOrderDetail_"+i+"_uphonemodelid' name='orderDetailList["+i+"].uphonemodelid'/><input type='text' id='addOrderDetail_"+i+"_cphonemodelname' name='orderDetailList["+i+"].cphonemodelname' style='width: 100px;border:none;'/></td>" +//:型号
					"<td><input type='hidden' id='addOrderDetail_"+i+"_ucolorid' name='orderDetailList["+i+"].ucolorid'/><input type='text' id='addOrderDetail_"+i+"_ccolorname' name='orderDetailList["+i+"].ccolorname' style='width: 80px;height:18px;border:none;'/></td>" +//:颜色
					"<td><input type='text' id='addOrderDetail_"+i+"_imei' name='orderDetailList["+i+"].imei' style='width: 100px;height:18px;border:none;' class='validate[funcCall[ajaxIMEI]]'/></td>" +//:串号
					"<td><label id='addOrderDetail_"+i+"_cram'></label></td>" +//:运行内存
					"<td><label id='addOrderDetail_"+i+"_crom'></label></td>" +//:存储内存
					"<td><label id='addOrderDetail_"+i+"_ccpu'></label></td>" +//:处理器
					"<td><label id='addOrderDetail_"+i+"_ccamera'></label></td>" +//:摄像头
					"<td><label id='addOrderDetail_"+i+"_cscreen'></label></td>" +//:屏幕
					"<td><label id='addOrderDetail_"+i+"_cbattery'></label></td>" +//:电池
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_ncostprice' name='orderDetailList["+i+"].ncostprice' class='validate[custom[number],min[0]]'/></td>" +//:进货价
					"<td><input type='text' style='width: 60px;height:18px;text-align:right;border:none;' id='addOrderDetail_"+i+"_nretailprice' name='orderDetailList["+i+"].nretailprice' class='validate[custom[number],min[0]]'/></td>" +//:销售价
					"<td><a href='javascript:deleteLine(\"detailsTable\",\"dataLineTr"+i+"\")' title='删除' style='text-decoration:none;color:black;'>-</a></td>" +//:操作
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
				{ display: '品牌', name: 'cbrandname', width: 100,minWidth: 80 },
				{ display: '型号', name: 'cname', width: 100,minWidth: 80 },
				{ display: '运行内存(RAM)', name: 'cram', width: 100,minWidth: 80 },
				{ display: '存储内存(ROM)', name: 'crom', width: 100,minWidth: 80 },
				{ display: '进货价(元)', name: 'ncostprice', width: 100,minWidth: 80 },
				{ display: '销售价(元)', name: 'nretailprice', width: 100,minWidth: 80 },
				{ display: '处理器(CPU)', name: 'ccpu', width: 120,minWidth: 100 },
				{ display: '屏幕', name: 'cscreen', width: 120,minWidth: 100 },
				{ display: '摄像头', name: 'ccamera', width: 180,minWidth: 160 },
				{ display: '电池', name: 'cbattery', width: 100,minWidth: 80 },
				{ display: '网络模式', name: 'cnetwork', width: 100,minWidth: 80 },
				{ display: '亮点描述', name: 'chighlightdesc', width: 160,minWidth: 140 },
				{ display: '保修时间(天)', name: 'iwarrantyday', width: 100,minWidth: 80 },
				{ display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80 },
				{ display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 },
				{ display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120 }
	        ], 
			switchPageSizeApplyComboBox: false,
			url:contextPath + "/bpr/phoneModel/getPhoneModelJSON",
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
		width:120,
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
        				$("#addOrderDetail_" + _number + "_cbrandname").text(box_data["Rows"][i].cbrandname);//:品牌
        				$("#addOrderDetail_" + _number + "_uphonemodelid").val(box_data["Rows"][i].uid);//:手机型号主键
        				$("#addOrderDetail_" + _number + "_cphonemodelname").val(box_data["Rows"][i].cname);//:手机型号
        				//颜色处理
        				loadColor(_number, box_data["Rows"][i].uid);
        				$("#addOrderDetail_" + _number + "_cram").text(box_data["Rows"][i].cram);//:运行内存
        				$("#addOrderDetail_" + _number + "_crom").text(box_data["Rows"][i].crom);//:存储内存
        				$("#addOrderDetail_" + _number + "_ccpu").text(box_data["Rows"][i].ccpu);//:处理器
        				$("#addOrderDetail_" + _number + "_ccamera").text(box_data["Rows"][i].ccamera);//:摄像头
        				$("#addOrderDetail_" + _number + "_cscreen").text(box_data["Rows"][i].cscreen);//:屏幕
        				$("#addOrderDetail_" + _number + "_cbattery").text(box_data["Rows"][i].cbattery);//:电池
        				$("#addOrderDetail_" + _number + "_ncostprice").val(box_data["Rows"][i].ncostprice);//:商品进货价
        				$("#addOrderDetail_" + _number + "_nretailprice").val(box_data["Rows"][i].nretailprice);//:商品金额
        				calculateTotalAmount();
        			}
        		}
        	}
        }
	});
}
/**
 * 加载手机型号的颜色
 * @param number 控件序号
 * @param uphonemodelid 手机型号主键
 */
function loadColor(number,uphonemodelid){
	$("#addOrderDetail_" + number + "_ccolorname").ligerComboBox({
		slide: false,
		width:80,
		height:18,
        selectBoxWidth: 600, 
        selectBoxHeight: 320,
        valueField:'ucolorid',
        textField:'ccolorname',
        autocomplete:true,
        grid:{
			columns: [
	            { display:'主键', name : 'ucolorid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'ccolorname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/phoneModel/getPhoneModelColorJSON?uphonemodelid="+uphonemodelid,
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addOrderDetail_" + number + "_ucolorid").val(value);
		}
	});
}
/**
 * 计算总金额
 */
function calculateTotalAmount(){
	var totalAmount = 0;
	for(var i = 1; i <= findMaxIndex(); i++){
		var _amount = $("#addOrderDetail_" + i + "_ncostprice").val();
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
		var _element = "addOrderDetail_" + i + "_cphonemodelname";
		loadAutoComplete(_element,i);
		calculateTotalAmount();
	}
}
/**
 * 更新数据行序号
 * @param elementId 元素id
 */
function updateLineSerialNumber(elementId){
	var _label = $("#" + elementId + " tr td label[name='lineNumber']");
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
	var _element = "addOrderDetail_" + totalNumber + "_cphonemodelname";
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
		$("#addOrderDetail_" + i + "_cbrandname").text("");
		$("#addOrderDetail_" + i + "_uphonemodelid").val("");
		$("#addOrderDetail_" + i + "_cphonemodelname").val("");
		$("#addOrderDetail_" + i + "_ucolorid").val("");
		$("#addOrderDetail_" + i + "_ccolorname").val("");
		$("#addOrderDetail_" + i + "_imei").val("");
		$("#addOrderDetail_" + i + "_cram").text("");
		$("#addOrderDetail_" + i + "_crom").text("");
		$("#addOrderDetail_" + i + "_ccpu").text("");
		$("#addOrderDetail_" + i + "_ccamera").text("");
		$("#addOrderDetail_" + i + "_cscreen").text("");
		$("#addOrderDetail_" + i + "_cbattery").text("");
		$("#addOrderDetail_" + i + "_ncostprice").val("");
		$("#addOrderDetail_" + i + "_nretailprice").val("");
		calculateTotalAmount();
	}
}
/**
 * 验证是否有数据
 * @returns
 */
function validData(){
	for(var i = 1; i <= findMaxIndex(); i++){
		var _element = "addOrderDetail_" + i + "_uphonemodelid";
		var _elementColor = "addOrderDetail_" + i + "_ucolorid";
		var _elementimei = "addOrderDetail_" + i + "_imei";
		var _value = $("#" + _element).val();
		var _colorValue = $("#" + _elementColor).val();
		var _imei = $("#" + _elementimei).val();
		if(_value != null && _value != undefined && _value != "" && _colorValue != null && _colorValue != undefined && _colorValue != "" && _imei != null && _imei != undefined && _imei != "")
			return true;
	}
	return false;
}
/**
 * 验证手机串号是否重复
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function ajaxIMEI(field,rules,i,options){
	if(field.val().length > 0){
		if(localValidIMEI(field.val()))
			return "*手机串号重复";
		else
			return checkData('t_supplier_phone_order','imei',field.val(),'*手机串号重复');
	}
}
/**
 * 本地验证手机串号是否重复
 * @param value
 */
function localValidIMEI(value){
	var repeatQuantity = 0;
	for(var i = 1; i <= findMaxIndex(); i++){
		var element = "addOrderDetail_" + i + "_imei";
		var imei = $("#" + element).val();
		if(value == imei)
			repeatQuantity++;
	}
	if(repeatQuantity > 1)
		return true;
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
//选择手机型号
function choosePhoneModel(){
	choosePhoneDialog = $.ligerDialog.open({url:contextPath+"/bpr/phoneModel/choose",title:"选择手机型号",allowClose:true,width:1000,height:480,
		buttons:[{text:"导入",onclick:function(i,d){
			var selectedRows = choosePhoneDialog.frame.phoneModelTable.getSelectedRows();
			if(selectedRows.length > 0){
				loadChoosePhoneModel(selectedRows);
			}else
				$.ligerDialog.error("请选择型号后，再进行导入！");
		}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
//计算有效数据行
function calculateValidLine(){
	var line = 0;
	for(var i = 1; i <= findMaxIndex(); i++){
		var _element = "addOrderDetail_" + i + "_uphonemodelid";
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
//加载选择的手机型号
function loadChoosePhoneModel(selectedRows){
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
			var _element = "addOrderDetail_" + maxIndex + "_cphonemodelname";
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
				if($(this).attr("id").indexOf("_uphonemodelid") > 0){
					isPrint = true;
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == "" && selectedRows.length > data_i){
						$(this).val(selectedRows[data_i].uid);
					}
					var id = $(this).attr("id").split("_");
					if(id.length > 2 && selectedRows.length > data_i){
						loadColor(id[1], selectedRows[data_i].uid);
					}
				}
				if($(this).attr("id").indexOf("_cphonemodelname") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == "" && selectedRows.length > data_i){
						$(this).val(selectedRows[data_i].cname);
					}
				}
				if($(this).attr("id").indexOf("_ncostprice") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == "" && selectedRows.length > data_i){
						$(this).val(selectedRows[data_i].ncostprice);
					}
				}
				if($(this).attr("id").indexOf("_nretailprice") > 0){
					if($(this).val() == null || $(this).val() == undefined || $(this).val() == "" && selectedRows.length > data_i){
						$(this).val(selectedRows[data_i].nretailprice);
					}
				}
			});
			if(isPrint){
				$(this).find("label").each(function(){
					if($(this).attr("id") != null && $(this).attr("id") != undefined && $(this).attr("id") != ""){
						if($(this).attr("id").indexOf("_cbrandname") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].cbrandname);
							}
						}
						if($(this).attr("id").indexOf("_cram") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].cram);
							}
						}
						if($(this).attr("id").indexOf("_crom") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].crom);
							}
						}
						if($(this).attr("id").indexOf("_ccpu") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].ccpu);
							}
						}
						if($(this).attr("id").indexOf("_ccamera") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].ccamera);
							}
						}
						if($(this).attr("id").indexOf("_cscreen") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].csreen);
							}
						}
						if($(this).attr("id").indexOf("_cbattery") > 0){
							if($(this).text() == null || $(this).text() == undefined || $(this).text() == "" && selectedRows.length > data_i){
								$(this).text(selectedRows[data_i].cbattery);
							}
						}
					}
				});
				data_i++;
			}
		}
	});
	updateLineSerialNumber("detailsTable");
	calculateTotalAmount();
}