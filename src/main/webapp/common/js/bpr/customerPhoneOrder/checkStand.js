/**
 * 手机收银台
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
				if($(this).attr("id").indexOf("nprice") > 0){
					namount += parseFloat($(this).val());
					quantity++;
				}
			}
		});
		$("#phoneQuantityInput").val(quantity.toFixed(2));
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
		$.ligerDialog.confirm("您确定要结账吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('结账中,请稍候...');
				$("#checkStandForm").ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("结账失败!");
					else{
						window.parent.phoneMaingrid.loadData();
						window.parent.checkStandDialog.close();
					}
				});
			}
		});
	}
}