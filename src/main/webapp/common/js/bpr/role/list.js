/**
 * 弹出框
 */
var _ligerDialog = null;
/**
 * 账户表格行数据
 */
var _roleTable = null;
//新增角色页面
var addRoleDialog = null;

var _showModuleGroupGrid = null;
var map = {};
/**
 * 页面加载
 */
$(function(){
	$("#roleToolBar").ligerToolBar({
		items:[
		    { text: '增加', click: _addRole, icon: 'add' },
	        { line: true },
	        { text: '修改', click: _modifyRole, icon: 'modify' },
	        { line: true },
	        { text: '删除', click: _deleteRole, icon:'delete' }
		]
	});
	_roleTable = $("#maingrid").ligerGrid({
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'ccode', align: 'left', width: 200, minWidth: 120 },
            { display: '用户', name: 'cusername', width: 120, minWidth: 60, align:'left' },
            { display: '名称', name: 'cname', width: 200,minWidth: 120, align:'left' }
            ],
		url:contextPath + "/bpr/role/getRoleJSON",
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
	    detail:{onShowDetail:f_showModuleGroup,height:'auto'}
	});
});
/**
 * 新增
 */
function _addRole(){
	addRoleDialog = $.ligerDialog.open({url:contextPath+"/bpr/role/add",title:"新增角色",allowClose:true,width:340,height:320});
}
/**
 * 修改
 */
function _modifyRole(){
	var rows = _roleTable.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({url:contextPath+"/bpr/role/modify?uid="+rows[0].uid,title:"修改角色",allowClose:true,width:340,height:320});
	}else{
		$.ligerDialog.warn("请选择需要修改的角色!");
	}
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
/**
 * 获取角色关联的功能模块组
 * @param row
 * @param detailPanel
 * @param callback
 */
function f_showModuleGroup(row, detailPanel,callback){
	map[row.uid] = new Array();
	var grid = document.createElement('div');
	$(detailPanel).append(grid);
	_showModuleGroupGrid = $(grid).css('margin',10).ligerGrid({
        columns:
                    [
                    { dispaly:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
                    { display: '编码', name: 'ccode', align: 'left', width: 120, minWidth: 80 },
                    { display: '名称', name: 'cname', width: 120,minWidth: 80, align:'left' }
                    ], 
                    toolbar: { items: [{ text: '保存',click:_saveModuleGroup, icon: 'save',id:row.uid }]},
                    url:contextPath + "/bpr/role/getRoleModuleGroupListJSON?uroleid=" + row.uid,
                    isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
                    pageSize:5 ,rownumbers:true,pageSizeOptions:[5],frozen: false,
            	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false,
            	    enabledEdit: true, clickToEdit: true,onSuccess:f_success,isChecked: f_isChecked,onCheckRow: f_onCheckRow,onCheckAllRow: f_onCheckAllRow
    });  
}
function findCheckedUID(uroleid,uid){
	for(var i = 0;i < map[uroleid].length;i++){
		if(map[uroleid][i] == uid) return i;
	}
	return -1;
}
function addCheckedUID(uroleid,uid){
	if(findCheckedUID(uroleid,uid) == -1)
		map[uroleid].push(uid);
}
function removeCheckedUID(uroleid,uid){
	var i = findCheckedUID(uroleid,uid);
	if(i == -1) return;
	map[uroleid].splice(i,1);
}
function f_success(data){
	$.each(data,function(key,value){
		if(key == "Rows"){
			for(var i = 0; i < value.length; i++){
				if(value[i].haveModuleGroup > 0 && findCheckedUID(value[i].uroleid,value[i].uid) == -1){
					map[value[i].uroleid].push(value[i].uid);
				}
			}
		}
	});
}
function f_onCheckAllRow(checked){
    for (var rowid in this.records){
        if(checked)
        	addCheckedUID(this.records[rowid]['uroleid'],this.records[rowid]['uid']);
        else
        	removeCheckedUID(this.records[rowid]['uroleid'],this.records[rowid]['uid']);
    }
}
function f_isChecked(row){
	if(findCheckedUID(row.uroleid,row.uid) == -1)
		return false;
	return true;
}
function f_onCheckRow(checked, row)
{
    if (checked) addCheckedUID(row.uroleid,row.uid);
    else removeCheckedUID(row.uroleid,row.uid);
}
function _saveModuleGroup(element){
    if (map[element.id] != null && map[element.id].length > 0) {
    	$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/role/saveRoleModuleGroup",
					data:{'uroleid':element.id,"umodulegroupids":map[element.id].toString()},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据保存失败!");
						else{
							$.ligerDialog.success("数据保存成功!");
							_showModuleGroupGrid.loadData();
						}
					}
				});
			}
		});
    }else{
    	$.ligerDialog.warn("请选择需要关联的功能模块组!");
    }
}