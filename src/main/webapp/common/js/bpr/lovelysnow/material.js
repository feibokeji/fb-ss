/**
 * 可爱雪-物料类管理
 */

/**
 * 弹出框
 */
var _ligerDialog = null;
/**
 * 物料表格行数据
 */
var _materialTableTr = null;
/**
 * 原有编码
 */
var _old_cno = null;
/**
 * 原有名称
 */
var _old_cname = null;
/**
 * 页面加载
 */
$(function(){
	$("#addForm,#modifyForm").validationEngine();
	_materialTableTr = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { dispaly:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'cno', align: 'left', width: 100, minWidth: 60 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120 },
            { display: '规格', name: 'cspecifications', width: 200,minWidth: 120 },
            { display: '价格', name: 'nprice', width: 100,minWidth: 60 }
            ],
        toolbar: { items: [
	            { text: '增加', click: _addMaterial, icon: 'add' },
	            { line: true },
	            { text: '修改', click: _modifyMaterial, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: _deleteMaterial, img: contextPath + '/common/liger/images/skins/icons/delete.gif' }
            ]
        },
		url:contextPath + "/bpr/lovelysnow/listMaterial",
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
						_materialTableTr.loadData();
					}
				});
			}
		});
	}
}
/**
 * 新增物料数据
 */
function _addMaterial(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增物料",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
/**
 * 新增时验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_material','cno',field.val(),'*编码重复');
	}
}

/**
 * 新增时验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_material','cname',field.val(),'*名称重复');
	}
}
/**
 * 修改物料数据
 */
function _modifyMaterial(){
	var rows = _materialTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({ target: $("#modifyDiv"),title:"修改物料",width:480,height:340,
			buttons:[{text:"保存",onclick:function(i,d){submitForm($("#modifyForm"));}},{text:"关闭",onclick:function(i,d){d.hide();resetModifyItem();}}]
		});
		setModifyItem(rows[0].uid,rows[0].cno,rows[0].cname,rows[0].cspecifications,rows[0].nprice);
	}else{
		$.ligerDialog.warn("请选择需要修改的物料!");
	}
}
/**
 * 修改时验证编码
 * @param item
 */
function ajaxModifyCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cno)
			return checkData('t_material','cno',field.val(),'*编码重复');
	}
}

/**
 * 修改时验证名称
 * @param item
 */
function ajaxModifyCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cname)
			return checkData('t_material','cname',field.val(),'*名称重复');
	}
}
/**
 * 设置修改时表单数据
 * @param uid
 * @param cno
 * @param cname
 * @param cspecifications
 * @param nprice
 */
function setModifyItem(uid,cno,cname,cspecifications,nprice){
	_old_cno = cno;
	_old_cname = cname;
	$("#modify_uid").val(uid);
	$("#modify_cno").val(cno);
	$("#modify_cname").val(cname);
	$("#modify_cspecifications").val(cspecifications);
	$("#modify_nprice").val(nprice);
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
	$("#modify_cspecifications").val("");
	$("#modify_nprice").val("");
}
/**
 * 删除物料数据
 */
function _deleteMaterial(){
	var rows = _materialTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗?",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/lovelysnow/deleteMaterial",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "have"){
							$.ligerDialog.error("此物料已被关联到产品信息中,不能删除此物料!");
						}else{
							$.ligerDialog.success("数据删除成功!");
							_materialTableTr.loadData();
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的类别!");
	}
}