/**
 * 修改客户信息JavaScript
 */
$(function(){
	$("#modifyForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
	$("#modifyCcustomerTypeName").ligerComboBox({
		url:contextPath+'/bpr/customer/getCustomerTypeComboBoxJSON',
		valueField:'id',
		textField:'name',
		columns:[
			{header:'id',name:'id'},
			{header:'编号',name:'cno'},
			{header:'类型',name:'cname'},
			{header:'账期(天数)',name:'ipaymentdays'}
		],
		autocomplete:true
	});
	$("#modifyDbirthday").ligerDateEditor();
});
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != oldCname)
			return checkData('t_customer','cname',field.val(),'*名称重复');
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
						window.parent.customerTable.loadData();
					}
				});
			}
		})
	}
}