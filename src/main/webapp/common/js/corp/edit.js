$(function() {
	$("#editCorpForm").ligerForm();
	$('#editCorpForm').validationEngine('attach', { 
		 promptPosition: 'centerRight'
	});
	if(updateOK){
		$.ligerDialog.success("保存成功!");
	}
});
/**
 * 提交表单
 */
function submitForm(){
	if($("#editCorpForm").validationEngine("validate")){
		$.ligerDialog.confirm('您确定要更新吗？', function (yes){
			if(yes){
				$.ligerDialog.waitting('正在更新中,请稍候...');
				$("#editCorpForm").submit();
			}
		});
	}
}
/**
 * 验证公司代码唯一性
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkCorpCode(field,rules,i,options){
	if(field.val().length > 0){
		if(oldCode != field.val()){
			return checkData('t_corp','ccode',field.val(),'*编号重复');
		}
	}
}
/**
 * 验证公司名称唯一性
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkCorpName(field,rules,i,options){
	if(field.val().length > 0){
		if(oldName != field.val()){
			return checkData('t_corp','cname',field.val(),'*名称重复');
		}
	}
}
