/**
 * 新增 实收/实付 页面
 */
$(function(){
	$("#receiptsForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
	loadPaymentMethod();
	convert_rmb();
});
//加载支付方式
//挂账方式不能加载
function loadPaymentMethod(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/paymentMethod/getPaymentMethodJSON",
		dataType:"json",
		success:function(data){
			for(var i = 0; i < data.Rows.length; i++){
				if(data.Rows[i].cname != "挂账"){
					$("#paymentMethodSelect").append("<option value='"+data.Rows[i].uid+"'>"+data.Rows[i].cname+"</option>");
				}
			}
		}
	});
}
//大写金额
function convert_rmb(){
	var amount = parseFloat($("#namount").val());
	$("#amountInWords").html(convertRMB(amount));
}
//提交表单
function submitForm(){
	if($("#receiptsForm").validationEngine("validate")){
		$.ligerDialog.confirm("您确定要提交吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('提交中,请稍候...');
				$("#receiptsForm").ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("提交失败!");
					else{
						window.parent.receivableGrid.loadData();
						window.parent.addReceiptsDialog.close();
					}
				});
			}
		});
	}
}