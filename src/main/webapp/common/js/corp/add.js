$(function() {
	$("#addCorpForm").ligerForm();
	$('#addCorpForm').validationEngine('attach', { 
		 promptPosition: 'centerRight'
	});
	if(addOK){
		$.ligerDialog.success("保存成功!");
	}
});
/**
 * 提交表单
 */
function submitForm(){
	if($("#addCorpForm").validationEngine("validate")){
		$.ligerDialog.confirm('您确定要保存吗？', function (yes){
			if(yes){
				$.ligerDialog.waitting('正在保存中,请稍候...');
				$("#addCorpForm").submit();
			}
		});
	}
}
//数据验证方法
function checkData(table,column,value,msg){
	var result = "";
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/auxiliary/checkDataRepeat",
		data:{'table':table,'column':column,'value':value},
		dataType:"html",
		success:function(data){
			if(data == 'true'){
				result = msg;
			}
		}
	});
	if(result != ""){
		return result;
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
		return checkData('t_corp','ccode',field.val(),'*编号重复');
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
		return checkData('t_corp','cname',field.val(),'*名称重复');
	}
}
