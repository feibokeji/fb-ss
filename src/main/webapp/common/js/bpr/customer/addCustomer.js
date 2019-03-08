/**
 * 新增客户信息JavaScript
 */
$(function(){
	$("#addForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
	$("#addCcustomerTypeName").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '编码', name: 'cno', align: 'left', width: 40, minWidth: 40 },
	            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' },
	            { display: '账期(天数)', name: 'ipaymentdays', width: 80,minWidth: 60, align:'left' }
	        ],
	        url:contextPath + "/bpr/customer/getCustomerTypeJSON",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addUcustomerTypeId").val(value);
		}
	});
	$("#addDbirthday").ligerDateEditor();
});
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
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
						window.parent.customerTable.loadData();
					}
				});
			}
		})
	}
}