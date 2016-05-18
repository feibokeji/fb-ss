/**
 * 可爱雪-角色
 */

/**
 * 弹出框
 */
var _ligerDialog = null;
/**
 * 账户表格行数据
 */
var _roleTable = null;
/**
 * 原有编码
 */
var _old_ccode = null;
/**
 * 原有名称
 */
var _old_cname = null;
/**
 * 页面加载
 */
$(function(){
	$("#addForm,#modifyForm").validationEngine();
	_roleTable = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { dispaly:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'ccode', align: 'left', width: 200, minWidth: 120 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120 }
            ],
        toolbar: { items: [
	            { text: '增加', click: _addRole, icon: 'add' },
	            { line: true },
	            { text: '修改', click: _modifyRole, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: _deleteRole, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/role/getRoleJSON",
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false,
	    onBeforeCheckAllRow:function(checked, grid ,element){
	    	return false;//禁用全选
	    },
	    onCheckRow:function(checked,rowdata,rowindex){
	    	if(checked){
	    		for(var rowid in this.records)
		    		this.unselect(rowid);
		    	this.select(rowindex);
	    	}else{
	    		this.unselect(rowid);
	    	}
	    }
	});
});
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitForm(_form){
	if(_form.validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				_form.ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else{
						_ligerDialog.hide();
						$.ligerDialog.success("保存成功!");
						_roleTable.loadData();
					}
				});
			}
		});
	}
}
/**
 * 新增
 */
function _addRole(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增角色",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
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
/**
 * 修改
 */
function _modifyRole(){
	var rows = _roleTable.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({ target: $("#modifyDiv"),title:"修改角色",width:480,height:340,
			buttons:[{text:"保存",onclick:function(i,d){submitForm($("#modifyForm"));}},{text:"关闭",onclick:function(i,d){d.hide();resetModifyItem();}}]
		});
		setModifyItem(rows[0].uid,rows[0].ccode,rows[0].cname);
	}else{
		$.ligerDialog.warn("请选择需要修改的角色!");
	}
}
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
 * 设置修改时表单数据
 * @param uid
 * @param ccode
 * @param cname
 */
function setModifyItem(uid,ccode,cname){
	_old_ccode = ccode;
	_old_cname = cname;
	$("#modify_uid").val(uid);
	$("#modify_ccode").val(ccode);
	$("#modify_cname").val(cname);
}
/**
 * 重置修改时表单数据
 */
function resetModifyItem(){
	_old_ccode = null;
	_old_cname = null;
	$("#modify_uid").val("");
	$("#modify_ccode").val("");
	$("#modify_cname").val("");
}
/**
 * 删除
 */
function _deleteRole(){
	var rows = _roleTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗?",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/role/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "have"){
							$.ligerDialog.error("此角色已使用,不能删除!");
						}else{
							$.ligerDialog.success("数据删除成功!");
							_roleTable.loadData();
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的角色!");
	}
}