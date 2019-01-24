/**
 * 新增付款方式操作JavaScript
 */
$(function(){
	$("#addForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
});
function ajaxCname(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_payment_method','cname',field.val(),'*付款方式重复');
	}
}
function ajaxCcode(field,rules,i,options)
{
	if(field.val().length > 0){
		return checkData('t_payment_method','ccode',field.val(),'*代码重复');
	}
}
function closeDialog()
{
	$.ligerDialog.confirm("您确定要关闭比窗口吗?",function(yes){
		if(yes){
			frameElement.dialog.close();
		}
	});
}
function submitForm()
{
	if($("#addForm").validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				$("#addForm").ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else{
						$.ligerDialog.success("保存成功!");
						window.parent.paymentMethodTable.loadData();
					}
				});
			}
		})
	}
}