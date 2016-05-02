/**
 * 可爱雪-产品类别管理
 */
var _ligerDialog = null;//弹出框
var _categoryTableTr = null;//类别表格行数据

$(function(){
	$("#addForm").validationEngine();
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
		buttons:[{text:"保存",onclick:function(i,d){submitForm();}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}

/**
 * 提交产品类别新增表单
 * @param item
 */
function submitForm(){
	var _form = $("#addForm");
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
 * 修改
 * @param item
 */
function _modifyCategory(){
	var rows = _categoryTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		alert(1);
	}else{
		$.ligerDialog.warn("请选择需要修改的类别!");
	}
}
/**
 * 删除
 */
function _deleteCategory(){
	var rows = _categoryTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		alert(1);
	}else{
		$.ligerDialog.warn("请选择需要删除的类别!");
	}
}
