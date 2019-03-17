/**
 * 商品收银台
 */
var discountLigerSpinner = null;
$(function(){
	$("#checkStandForm").validationEngine('attach', { scroll:false});
	discountLigerSpinner = $("#orderReceivable_ndiscount").ligerSpinner({height:28,width:85,minValue:0.00,maxValue:1.00,onChangeValue:discount_onChangeValue});
	discountLigerSpinner.setValue(1.00);
	$("#orderReceipts_upaymentmethodid option").each(function(){
		if($(this).text() == "人民币")
			$(this).attr("selected",true);
	});
});
//加
function add(input_element,i){
	//最大库存
	var inventoryQuantity = parseFloat($("#orderDetailList_"+i+"_inventoryQuantity").val());
	//价格
	var nprice = parseFloat($("#orderDetailList_"+i+"_nprice").val());
	//数量元素
	var nquantityElement = $("#orderDetailList_"+i+"_nquantity");
	//金额元素
	var namountElement = $("#orderDetailList_"+i+"_namount");
	//数量显示元素
	var nquantitySpanElement = $("#orderDetailList_"+i+"_nquantity_span");
	//金额显示元素
	var namountSpanElement = $("#orderDetailList_"+i+"_namount_span");
	
	//原有数量
	var oldQuantity = parseFloat(nquantityElement.val());
	if(oldQuantity + 1 > inventoryQuantity)
		$.ligerDialog.warn("该商品销售量已超出现有库存！");
	else{
		var newQuantity = oldQuantity + 1;
		var newNamount = (newQuantity * nprice).toFixed(2);
		nquantityElement.val(newQuantity);
		nquantitySpanElement.text(newQuantity);
		namountElement.val(newNamount);
		namountSpanElement.text(newNamount);
		calculate();
	}
}
//减
function subtraction(input_element,i){
	//最大库存
	var inventoryQuantity = parseFloat($("#orderDetailList_"+i+"_inventoryQuantity").val());
	//价格
	var nprice = parseFloat($("#orderDetailList_"+i+"_nprice").val());
	//数量元素
	var nquantityElement = $("#orderDetailList_"+i+"_nquantity");
	//金额元素
	var namountElement = $("#orderDetailList_"+i+"_namount");
	//数量显示元素
	var nquantitySpanElement = $("#orderDetailList_"+i+"_nquantity_span");
	//金额显示元素
	var namountSpanElement = $("#orderDetailList_"+i+"_namount_span");
	
	//原有数量
	var oldQuantity = parseFloat(nquantityElement.val());
	if(oldQuantity - 1 > 0){
		var newQuantity = oldQuantity - 1;
		var newNamount = (newQuantity * nprice).toFixed(2);
		nquantityElement.val(newQuantity);
		nquantitySpanElement.text(newQuantity);
		namountElement.val(newNamount);
		namountSpanElement.text(newNamount);
		calculate();
	}else if(oldQuantity - 1 == 0){
		del(input_element,i);
	}
}
//删除
function del(input_element,i){
	$(input_element).parent().parent().remove();
	calculate();
}
//计算销售量和金额
function calculate(){
	if($("#checkStandTable").find("tr").length == 1){
		window.parent.checkStandDialog.close();
	}else{
		var quantity = 0.00;
		var namount = 0.00;
		$("input:hidden").each(function(){
			if($(this).attr("id") != undefined && $(this).attr("id") != null){
				if($(this).attr("id").indexOf("nquantity") > 0)
					quantity += parseFloat($(this).val());
				if($(this).attr("id").indexOf("namount") > 0)
					namount += parseFloat($(this).val());
			}
		});
		$("#goodsQuantityInput").val(quantity.toFixed(2));
		$("#orderReceivable_nactualamount").val(namount.toFixed(2));
		var discount = parseFloat(discountLigerSpinner.getValue());
		var discountNamount = namount * discount;
		$("#orderReceivable_namount").val(discountNamount.toFixed(2));
		$("#orderReceipts_namount").val(discountNamount.toFixed(2));
	}
}
//整单折扣改变时处理函数
function discount_onChangeValue(value){
	var oldNamount = parseFloat($("#orderReceivable_nactualamount").val());
	var discount = parseFloat(value);
	var discountNamount = oldNamount * discount;
	$("#orderReceivable_namount").val(discountNamount.toFixed(2));
	$("#orderReceipts_namount").val(discountNamount.toFixed(2));
}
//结账
function submitForm(){
	if($("#checkStandForm").validationEngine("validate")){
		var quantity = parseFloat($("#goodsQuantityInput").val());
		if(quantity > 0){
			$.ligerDialog.confirm("您确定要结账吗？",function(yes){
				if(yes){
					var waitting = $.ligerDialog.waitting('结账中,请稍候...');
					$("#checkStandForm").ajaxSubmit(function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("结账失败!");
						else{
							window.parent.goodsTable.loadData();
							window.parent.checkStandDialog.close();
						}
					});
				}
			});
		}else{
			$.ligerDialog.error("销售量不能为零!");
		}
	}
}