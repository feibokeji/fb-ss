/**
 * 修改客户类型JavaScript
 */
$(function(){
	$("#modifyForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
});
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != oldCno)
			return checkData('t_customer_type','cno',field.val(),'*编码重复');
	}
}
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != oldCname)
			return checkData('t_customer_type','cname',field.val(),'*名称重复');
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
	if($("#modifyForm").validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				$("#modifyForm").ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else{
						$.ligerDialog.success("保存成功!");
						window.parent.customerTypeTable.loadData();
					}
				});
			}
		})
	}
}