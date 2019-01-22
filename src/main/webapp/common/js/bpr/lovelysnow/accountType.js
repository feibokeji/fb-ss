/**
 * 可爱雪-账务类型
 */
var _accountTypeTableTr = null;
/**
 * 原有编码
 */
var _old_cno = null;
/**
 * 原有名称
 */
var _old_cname = null;
$(function(){
	$("#addForm").validationEngine();
	_accountTypeTableTr = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '类别', name: 'ctype', width: 100, minWidth: 60 },
            { display: '编码', name: 'cno', align: 'left', width: 100, minWidth: 60 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120 },
            { display: '描述', name: 'cmemo', width: 300,minWidth: 120 }
            ],
        toolbar: { items: [
        { text: '增加', click: f_add, icon: 'add' },
        { line: true },
        { text: '修改', click: f_modify, icon: 'modify' },
        { line: true },
        { text: '删除', click: f_delete, img: contextPath + '/common/liger/images/skins/icons/delete.gif' }
        ]},
        url:contextPath+"/bpr/lovelysnow/getAccountTypeJSON",
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
	    		this.unselect(rowindex);
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
						_accountTypeTableTr.loadData();
					}
				});
			}
		});
	}
}
function f_add(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增财务类型",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
function f_modify(){
	var rows = _accountTypeTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({ target: $("#modifyDiv"),title:"修改财务类型",width:480,height:340,
			buttons:[{text:"保存",onclick:function(i,d){submitForm($("#modifyForm"));}},{text:"关闭",onclick:function(i,d){d.hide();resetModifyItem();}}]
		});
		setModifyItem(rows[0].uid,rows[0].ctype,rows[0].cno,rows[0].cname,rows[0].cmemo);
	}else{
		$.ligerDialog.warn("请选择需要修改的物料!");
	}
}
function f_delete(){
	var rows = _accountTypeTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗?",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/lovelysnow/deleteAccountType",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "have"){
							$.ligerDialog.error("此财务类型已被关联到单据信息中,不能删除!");
						}else{
							$.ligerDialog.success("数据删除成功!");
							_accountTypeTableTr.loadData();
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的类别!");
	}
}
/**
 * 设置修改时表单数据
 * @param uid
 * @param ctype
 * @param cno
 * @param cname
 * @param cmemo
 */
function setModifyItem(uid,ctype,cno,cname,cmemo){
	_old_cno = cno;
	_old_cname = cname;
	$("#modify_uid").val(uid);
	$("#modify_ctype").val(ctype);
	$("#modify_cno").val(cno);
	$("#modify_cname").val(cname);
	$("#modify_cmemo").val(cmemo);
}
/**
 * 重置修改时表单数据
 */
function resetModifyItem(){
	_old_cno = null;
	_old_cname = null;
	$("#modify_uid").val("");
	$("#modify_ctype").val("");
	$("#modify_cno").val("");
	$("#modify_cname").val("");
	$("#modify_cmemo").val("");
}
/**
 * 新增时验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_account_type','cno',field.val(),'*编码重复');
	}
}
/**
 * 新增时验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_account_type','cname',field.val(),'*名称重复');
	}
}
/**
 * 修改时验证编码
 * @param item
 */
function ajaxModifyCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cno)
			return checkData('t_account_type','cno',field.val(),'*编码重复');
	}
}
/**
 * 修改时验证名称
 * @param item
 */
function ajaxModifyCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cname)
			return checkData('t_account_type','cname',field.val(),'*名称重复');
	}
}