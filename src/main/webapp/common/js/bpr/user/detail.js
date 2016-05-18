/**
 * 账户信息
 */
var _ccode = null;
var _cname = null;

$(function(){
	$("#modUserForm").validationEngine();
	
	var _djoindate = $("#_djoindate").val();
	var _dbirthday = $("#_dbirthday").val();
	
    if(_djoindate != null && _djoindate != ""){
    	_djoindate = _djoindate.substring(0,_djoindate.indexOf(" "));
    }
    if(_dbirthday != null && _dbirthday != ""){
    	_dbirthday = _dbirthday.substring(0,_dbirthday.indexOf(" "));
    }
    
	$("#djoindate").ligerDateEditor({initValue:_djoindate});
	$("#dbirthday").ligerDateEditor({initValue:_dbirthday});
	
	$("#csex").val($("#_csex").val());
	
	_ccode = $("#_ccode").val();
	_cname = $("#_cname").val();
});

//提交表单
function f_Submit(){
	var form = $("#modUserForm");
	if(form.validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				form.ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else
						$.ligerDialog.success("保存成功!");
				});
			}
		});
	}
}

/**
 * 修改时验证编码
 * @param item
 */
function ajaxCode(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _ccode)
			return checkData('t_user','ccode',field.val(),'*编码重复');
	}
}

/**
 * 修改时验证名称
 * @param item
 */
function ajaxName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _cname)
			return checkData('t_user','cname',field.val(),'*名称重复');
	}
}