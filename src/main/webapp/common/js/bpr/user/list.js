/**
 * 可爱雪-功能模块
 */

/**
 * 弹出框
 */
var _ligerDialog = null;
/**
 * 账户表格行数据
 */
var _userTable = null;
/**
 * 页面加载
 */
$(function(){
	$("#addForm,#modifyForm").validationEngine();
	$("#userToolBar").ligerToolBar({
		items:[
		    { text: '增加', click: _addUser, icon: 'add' }
		]
	});
	_userTable = $("#maingrid").ligerGrid({
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'ccode', align: 'left', width: 80, minWidth: 60 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120, align:'left' }
            ],
		url:contextPath + "/bpr/user/getUserJSON",
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
						_userTable.loadData();
					}
				});
			}
		});
	}
}
/**
 * 新增
 */
function _addUser(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增账户",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
/**
 * 新增时验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_user','ccode',field.val(),'*编码重复');
	}
}

/**
 * 新增时验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_user','cname',field.val(),'*名称重复');
	}
}
