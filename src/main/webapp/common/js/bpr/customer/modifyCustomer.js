/**
 * 修改客户信息JavaScript
 */
var customerTypeComboBox = null;
$(function(){
	$('input:radio[name="isex"][value='+oldIsex+']').attr("checked",true);
	$("#modifyForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
	customerTypeComboBox = $("#modifyCcustomerTypeName").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,autocomplete:true,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '编号', name: 'cno', width: 60,minWidth: 40, align:'left' },
	            { display: '类型', name: 'cname', width: 120,minWidth: 100, align:'left' },
	            { display: '账期(天数)', name: 'ipaymentdays', width: 60,minWidth: 40, align:'left' }
	        ],
	        url:contextPath + "/bpr/customer/getCustomerTypeJSON",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#ucustomertypeid").val(value);
		}
	});
	$("#modifyCcustomerTypeName").val(oldCustomerTypeName);
	$("#modifyDbirthdayStr").ligerDateEditor();
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