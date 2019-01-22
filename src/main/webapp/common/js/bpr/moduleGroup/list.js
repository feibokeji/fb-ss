/**
 * 可爱雪-功能模块组
 */

/**
 * 弹出框
 */
var _ligerDialog = null;
/**
 * 账户表格行数据
 */
var _moduleGroupTable = null;
/**
 * 原有编码
 */
var _old_ccode = null;
/**
 * 原有名称
 */
var _old_cname = null;
var _showModuleGrid = null;
var map = {};
/**
 * 页面加载
 */
$(function(){
	$("#addForm,#modifyForm").validationEngine();
	_moduleGroupTable = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'ccode', align: 'left', width: 200, minWidth: 120 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120 }
            ],
        toolbar: { items: [
	            { text: '增加', click: _addModuleGroup, icon: 'add' },
	            { line: true },
	            { text: '修改', click: _modifyModuleGroup, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: _deleteModuleGroup, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/moduleGroup/getModuleGroupJSON",
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],frozen: false,fixedCellHeight:false,
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
	    },
	    detail:{onShowDetail:f_showModule,height:'auto'}
	});
});
function f_showModule(row, detailPanel,callback){
	map[row.uid] = new Array();
	var grid = document.createElement('div');
	$(detailPanel).append(grid);
	_showModuleGrid = $(grid).css('margin',10).ligerGrid({
        columns:
                    [
                    { display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
                    { display: '类型', name: 'ctype', align: 'left', width: 120, minWidth: 80 },
                    { display: '编码', name: 'ccode', align: 'left', width: 120, minWidth: 80 },
                    { display: '名称', name: 'cname', align: 'left',width: 120,minWidth: 80 },
                    { display: '父级模块', name: 'cparent', align: 'left',width: 120,minWidth: 80 },
                    { display: '级别', name: 'ilevel', align: 'left',width: 120,minWidth: 80 },
                    { display: '代码路径', name: 'ccodepath', align: 'left',width: 240,minWidth: 120 },
                    { display: '访问地址', name: 'caddr', align: 'left',width: 240,minWidth: 120 }
                    ], 
                    toolbar: { items: [{ text: '保存',click:_saveModule, icon: 'save',id:row.uid }]},
                    url:contextPath + "/bpr/moduleGroup/getModuleListJSON?umodulegroupid=" + row.uid,
                    isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
                    pageSize:10 ,rownumbers:true,pageSizeOptions:[10],frozen: false,
            	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false,
            	    enabledEdit: true, clickToEdit: true,onSuccess:f_success,isChecked: f_isChecked,onCheckRow: f_onCheckRow,onCheckAllRow: f_onCheckAllRow
    });  
}
function _saveModule(element){
    if (map[element.id] != null && map[element.id].length > 0) {
    	$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/moduleGroup/saveModuleGroupModule",
					data:{'umodulegroupid':element.id,"umoduleids":map[element.id].toString()},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据保存失败!");
						else{
							$.ligerDialog.success("数据保存成功!");
							_showModuleGrid.loadData();
						}
					}
				});
			}
		});
    }else{
    	$.ligerDialog.warn("请选择需要关联的功能模块!");
    }
}
function findCheckedUID(umodulegroupid,uid){
	for(var i = 0;i < map[umodulegroupid].length;i++){
		if(map[umodulegroupid][i] == uid) return i;
	}
	return -1;
}
function addCheckedUID(umodulegroupid,uid){
	if(findCheckedUID(umodulegroupid,uid) == -1)
		map[umodulegroupid].push(uid);
}
function removeCheckedUID(umodulegroupid,uid){
	var i = findCheckedUID(umodulegroupid,uid);
	if(i == -1) return;
	map[umodulegroupid].splice(i,1);
}
function f_success(data){
	$.each(data,function(key,value){
		if(key == "Rows"){
			for(var i = 0; i < value.length; i++){
				if(value[i].haveGroup > 0 && findCheckedUID(value[i].umodulegroupid,value[i].uid) == -1){
					map[value[i].umodulegroupid].push(value[i].uid);
				}
			}
		}
	});
}
function f_onCheckAllRow(checked){
    for (var rowid in this.records){
        if(checked)
        	addCheckedUID(this.records[rowid]['umodulegroupid'],this.records[rowid]['uid']);
        else
        	removeCheckedUID(this.records[rowid]['umodulegroupid'],this.records[rowid]['uid']);
    }
}
function f_isChecked(row){
	if(findCheckedUID(row.umodulegroupid,row.uid) == -1)
		return false;
	return true;
}
function f_onCheckRow(checked, row)
{
    if (checked) addCheckedUID(row.umodulegroupid,row.uid);
    else removeCheckedUID(row.umodulegroupid,row.uid);
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
						_moduleGroupTable.loadData();
					}
				});
			}
		});
	}
}
/**
 * 新增
 */
function _addModuleGroup(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增功能模块组",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
/**
 * 新增时验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_module_group','ccode',field.val(),'*编码重复');
	}
}

/**
 * 新增时验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_module_group','cname',field.val(),'*名称重复');
	}
}
/**
 * 修改
 */
function _modifyModuleGroup(){
	var rows = _moduleGroupTable.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({ target: $("#modifyDiv"),title:"修改功能模块组",width:480,height:340,
			buttons:[{text:"保存",onclick:function(i,d){submitForm($("#modifyForm"));}},{text:"关闭",onclick:function(i,d){d.hide();resetModifyItem();}}]
		});
		setModifyItem(rows[0].uid,rows[0].ccode,rows[0].cname);
	}else{
		$.ligerDialog.warn("请选择需要修改的功能模块组!");
	}
}
/**
 * 修改时验证编码
 * @param item
 */
function ajaxModifyCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_ccode)
			return checkData('t_module_group','ccode',field.val(),'*编码重复');
	}
}

/**
 * 修改时验证名称
 * @param item
 */
function ajaxModifyCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cname)
			return checkData('t_module_group','cname',field.val(),'*名称重复');
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
function _deleteModuleGroup(){
	var rows = _moduleGroupTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗?",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/moduleGroup/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "have"){
							$.ligerDialog.error("此功能模块组已使用,不能删除!");
						}else{
							$.ligerDialog.success("数据删除成功!");
							_moduleGroupTable.loadData();
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的功能模块组!");
	}
}