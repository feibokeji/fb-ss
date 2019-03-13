/**
 * 新增 角色信息
 */
var userComboBox = null;
$(function(){
	$("#addForm").validationEngine();
	userComboBox = $("#add_cusername").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 140,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',resize:true,
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
			$("#add_uuserid").val(value);
		}
	});
});
/**
 * 新增时验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_role','ccode',field.val(),'*编码重复');
	}
}

/**
 * 新增时验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_role','cname',field.val(),'*名称重复');
	}
}
function submitForm(){
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