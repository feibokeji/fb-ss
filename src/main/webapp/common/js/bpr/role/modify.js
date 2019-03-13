/**
 * 修改角色页面
 */
var modifyCombobox = null;
$(function(){
	$("#modifyForm").validationEngine();
	modifyCombobox = $("#modify_cusername").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 140,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '代码', name: 'ccode', align: 'left', width: 60, minWidth: 40 },
	            { display: '名称', name: 'cname', width: 100,minWidth: 80, align:'left' }
	        ],
	        url:contextPath + "/bpr/user/getUserJSON",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#modify_uuserid").val(value);
		}
	});
	$("#modify_cusername").val(oldUserName);
});
/**
 * 修改时验证编码
 * @param item
 */
function ajaxModifyCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_ccode)
			return checkData('t_role','ccode',field.val(),'*编码重复');
	}
}

/**
 * 修改时验证名称
 * @param item
 */
function ajaxModifyCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cname)
			return checkData('t_role','cname',field.val(),'*名称重复');
	}
}
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitForm(){
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
						window.parent._roleTable.loadData();
					}
				});
			}
		});
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