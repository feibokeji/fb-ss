/**
 * 功能模块管理--新增页面
 */
var dialog = frameElement.dialog;

$(function() {
	$('#editModuleForm').validationEngine('attach', { 
		 promptPosition: 'bottomLeft',scroll:false
	});
	if(msg != null && msg != ""){
		$.ligerDialog.success(msg);
	}
});
/**
 *提交表单
 */
function submitModuleForm(){
	if($("#editModuleForm").validationEngine("validate")){
		$.ligerDialog.confirm('您确定要保存吗？', function (yes){
			if(yes){
				$.ligerDialog.waitting('正在保存中,请稍候...');
				$("#editModuleForm").submit();
			}
		});
	}
}
/**
 * 检查类别
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkType(field, rules, i, options){
	if(parentType != null && parentType != '' && field.val().length > 0){
		if(parentType != field.val()){
			field.val(parentType);
			return "*此功能模块的类别必须为:" + parentType;
		}
	}
}
/**
 * 检查代码
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkCode(field, rules, i, options){
	if(field.val().length > 0){
		$("#ccodepath").val((parentCodePath == '' ? '|' : parentCodePath) + field.val() + "|");
		return checkData('t_module','ccode',field.val(),'*代码重复');
	}
}
/**
 * 检查名称
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkName(field, rules, i, options){
	if(field.val().length > 0){
		return checkData('t_module','cname',field.val(),'*名称重复');
	}
}
/**
 * 检查父级代码
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkParentCode(field, rules, i, options){
	if(parentCode != ''){
		if(field.val() != parentCode){
			field.val(parentCode);
			return "*此功能模块的父级代码必须为:" + parentCode;
		}
	}else{
		if(field.val().length > 0){
			return "*此功能模块的父级代码必须为空";
		}
	}
}
/**
 * 检查级别
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkLevel(field, rules, i, options){
	if(field.val().length > 0){
		if(parseInt(field.val()) != defaultLevel){
			field.val(defaultLevel);
			return "*此功能模块的级别必须为:" + defaultLevel;
		}
	}
}
/**
 * 检查代码路径
 * @param field
 * @param rules
 * @param i
 * @param options
 */
function checkCodePath(field, rules, i, options){
	if(field.val().length >= 3){
		//检查代码路径中前后是否含有"|"
		var firstChar = field.val().substring(0,1);
		var endChar = field.val().substring((field.val().length - 1),field.val().length);
		if(firstChar != "|" || endChar != "|"){
			return "*功能模块的代码路径前后必须是:'|'符号,例如:|TEST|";
		}
		//存在父级功能模块时验证是否包含父级代码路径
		if(parentCodePath != ''){
			if(field.val().length > parentCodePath.length){
				if(parentCodePath != field.val().substring(0,parentCodePath.length)){
					return "*功能模块的代码路径必须包含父级代码路径";
				}
			}else{
				return "*功能模块的代码路径必须包含父级代码路径";
			}
		}
	}else{
		return "*功能模块的代码路径前后必须是:'|'符号,例如:|TEST|";
	}
}
/**
 * 关闭弹出框
 */
function closeDialog(){
	$.ligerDialog.confirm("您确定要关闭比窗口吗?",function(yes){
		if(yes){
			dialog.close();
		}
	});
}