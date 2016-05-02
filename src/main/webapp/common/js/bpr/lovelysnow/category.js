/**
 * 可爱雪-产品类别管理
 */
var _ligerDialog = null;//弹出框
var _categoryTableTr = null;//类别表格行数据
var _old_cno = null;//原有编码
var _old_cname = null;//原有名称

$(function(){
	$("#addForm").validationEngine();
	$("#modifyForm").validationEngine();
	_categoryTableTr = $("#maingrid").ligerGrid({
            				height:'100%',
				            columns: [
					            { dispaly:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
					            { display: '编码', name: 'cno', align: 'left', width: 100, minWidth: 60 },
					            { display: '名称', name: 'cname', width: 200,minWidth: 120 }
					            ],
				            toolbar: { items: [
						            { text: '增加', click: _addCategory, icon: 'add' },
						            { line: true },
						            { text: '修改', click: _modifyCategory, icon: 'modify' },
						            { line: true },
						            { text: '删除', click: _deleteCategory, img: contextPath + '/common/liger/images/skins/icons/delete.gif' }
					            ]
				            },
							url:contextPath + "/bpr/lovelysnow/listCategory",
						    pageSize:10 ,rownumbers:true,pageSizeOptions:[10],
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
 * 新增产品类别
 */
function _addCategory(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增产品类别",width:480,height:240,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}

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
						_categoryTableTr.loadData();
					}
				});
			}
		});
	}
}

/**
 * 验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_category','cno',field.val(),'*编码重复');
	}
}

/**
 * 验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_category','cname',field.val(),'*名称重复');
	}
}

/**
 * 修改时验证编码
 * @param item
 */
function ajaxModifyCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cno)
			return checkData('t_category','cno',field.val(),'*编码重复');
	}
}

/**
 * 修改时验证名称
 * @param item
 */
function ajaxModifyCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cname)
			return checkData('t_category','cname',field.val(),'*名称重复');
	}
}

/**
 * 修改
 * @param item 
 */
function _modifyCategory(){
	var rows = _categoryTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({ target: $("#modifyDiv"),title:"修改产品类别",width:480,height:240,
			buttons:[{text:"保存",onclick:function(i,d){submitForm($("#modifyForm"));}},{text:"关闭",onclick:function(i,d){d.hide();resetModifyItem();}}]
		});
		setModifyItem(rows[0].uid,rows[0].cno,rows[0].cname);
	}else{
		$.ligerDialog.warn("请选择需要修改的类别!");
	}
}
/**
 * 设置修改时表单数据
 * @param uid
 * @param cno
 * @param cname
 */
function setModifyItem(uid,cno,cname){
	_old_cno = cno;
	_old_cname = cname;
	$("#modify_uid").val(uid);
	$("#modify_cno").val(cno);
	$("#modify_cname").val(cname);
}
/**
 * 重置修改时表单数据
 */
function resetModifyItem(){
	_old_cno = null;
	_old_cname = null;
	$("#modify_uid").val("");
	$("#modify_cno").val("");
	$("#modify_cname").val("");
}

/**
 * 删除
 */
function _deleteCategory(){
	var rows = _categoryTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗?",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/lovelysnow/deleteCategory",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "have"){
							$.ligerDialog.error("此类别下已包含有产品信息,不能删除此类别!");
						}else{
							$.ligerDialog.success("数据删除成功!");
							_categoryTableTr.loadData();
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的类别!");
	}
}
