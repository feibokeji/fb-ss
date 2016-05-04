/**
 * 可爱雪-物料类管理
 */

/**
 * 弹出框
 */
var _ligerDialog = null;
/**
 * 产品表格行数据
 */
var _productTableTr = null;
var _addCategoryComboBox = null;
var _modifyCategoryComboBox = null;
var _showMaterialGrid = null;
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
	$("#addForm,#modifyForm,addCategoryForm,addMaterialForm").validationEngine();
	_productTableTr = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { dispaly: '主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '类别', name: 'ccategoryname', align: 'left', width: 100, minWidth: 60 },
            { display: '编码', name: 'cno', align: 'left', width: 100, minWidth: 60 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120 },
            { display: '价格', name: 'nprice', width: 100,minWidth: 60 }
            ],
        toolbar: { items: [
	            { text: '增加', click: _addProduct, icon: 'add' },
	            { line: true },
	            { text: '修改', click: _modifyProduct, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: _deleteProduct, img: contextPath + '/common/liger/images/skins/icons/delete.gif' }
            ]
        },
		url:contextPath + "/bpr/lovelysnow/listProduct",
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
	    		this.unselect(rowid);
	    	}
	    },
	    detail:{onShowDetail:f_showMaterial,height:'auto'}
	});
	//类别下拉框
	_addCategoryComboBox = $("#add_box_ucategoryid").ligerComboBox({
		slide: false,
        selectBoxWidth: 600, 
        selectBoxHeight: 380,
        valueField:'uid',
        textField:'cname',
        condition:{fields: [{ name: 'cname', label: '名称', width: 90, type: 'text' }]},
        grid:getGridOptions(false),
        onSelected: function (value){$("#add_ucategoryid").val(value);}
	});
	_modifyCategoryComboBox = $("#modify_box_ucategoryid").ligerComboBox({
		slide: false,
        selectBoxWidth: 600, 
        selectBoxHeight: 380,
        valueField:'uid',
        textField: 'cname',
        condition:{fields: [{ name: 'cname', label: '名称', width: 90, type: 'text' }]},
        grid:getGridOptions(false),
        onSelected: function (value){$("#modify_ucategoryid").val(value);}
	});
});
/**
 * 表格数据渲染参数
 * @param checkbox 是否启用复选框
 * @returns options 
 */
function getGridOptions(checkbox){
	var options = {
			columns: [
			            { dispaly:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
			            { display: '编码', name: 'cno', align: 'left', width: 60, minWidth: 60 },
			            { display: '名称', name: 'cname', width: 100,minWidth: 100 }
			            ], 
			            toolbar: { items: [{ text: '增加', click: _addCategory, icon: 'add' }]},
			            switchPageSizeApplyComboBox: false,
			            url:contextPath + "/bpr/lovelysnow/listCategory",
			            pageSize:5,
			            rownumbers:true,
			            pageSizeOptions:[5],
			            onReload:false,
			            dataAction:"local",
			            selectRowButtonOnly:true,
			            enabledSort:false,
			            checkbox:false,
	};
	return options;
}
/**
 * 获取产品关联物料信息
 * @param row
 * @param detailPanel
 * @param callback
 */
function f_showMaterial(row, detailPanel,callback){
	var grid = document.createElement('div');
	$(detailPanel).append(grid);
	_showMaterialGrid = $(grid).css('margin',10).ligerGrid({
        columns:
                    [
                    { dispaly:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
                    { display: '编码', name: 'cno', align: 'left', width: 60, minWidth: 60 },
                    { display: '名称', name: 'cname', width: 60,minWidth: 60 },
                    { display: '规格', name: 'cspecifications', width: 60,minWidth: 60 },
                    { display: '价格', name: 'nprice', width: 60,minWidth: 60 },
                    { display: '数量', name: 'nqty', width: 60,minWidth: 60,type:'float',editor:{type:'float',value:0} }
                    ], 
                    toolbar: { items: [{ text: '保存',click:_saveProductMaterial, icon: 'save' },{ line: true },{ text: '新增',click: _addMaterial, icon: 'add' }]},
                    url:contextPath + "/bpr/lovelysnow/listMaterial",
                    isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
                    pageSize:5 ,rownumbers:true,pageSizeOptions:[5],frozen: false,
            	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false,
            	    enabledEdit: true, clickToEdit: true
    });  
}
/**
 * 新增产品类别
 */
function _addCategory(){
	$.ligerDialog.open({ target: $("#addCategoryDiv"),title:"新增类别",width:480,height:240,
		buttons:[{text:"保存",onclick:function(i,d){submitForm("addCategoryForm");}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
/**
 * 新增物料数据
 */
function _addMaterial(){
	$.ligerDialog.open({ target: $("#addMaterialDiv"),title:"新增物料",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm("addMaterialForm");}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
function _saveProductMaterial(){
	var rows = _showMaterialGrid.getCheckedRows();
    if (rows != null && rows != "") {
    	alert(JSON.stringify(rows));
    }else{
    	$.ligerDialog.warn("请选择需要关联的物料!");
    }
}
/**
 * 新增类别时验证编码
 * @param item
 */
function ajaxCategoryCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_category','cno',field.val(),'*编码重复');
	}
}

/**
 * 新增类别时验证名称
 * @param item
 */
function ajaxCategoryCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_category','cname',field.val(),'*名称重复');
	}
}
/**
 * 新增物料时验证编码
 * @param item
 */
function ajaxMaterialCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_material','cno',field.val(),'*编码重复');
	}
}

/**
 * 新增物料时验证名称
 * @param item
 */
function ajaxMaterialCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_material','cname',field.val(),'*名称重复');
	}
}
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitForm(_form_id){
	var _form = $("#" + _form_id);
	if(_form.validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				_form.ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else{
						$.ligerDialog.success("保存成功!");
						chooseLoadData(_form_id);
					}
				});
			}
		});
	}
}
/**
 * 根据实际表单选择性的刷新或关闭窗口
 * @param _form_id
 */
function chooseLoadData(_form_id){
	if(_form_id == "addForm" || _form_id == "modifyForm"){
		_ligerDialog.hide();
		_productTableTr.loadData();
	}else if(_form_id == "addMaterialForm")
		_showMaterialGrid.loadData();
}
/**
 * 新增产品信息
 */
function _addProduct(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增产品",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){submitForm("addForm");}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
/**
 * 新增时验证编码
 * @param item
 */
function ajaxCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_product','cno',field.val(),'*编码重复');
	}
}

/**
 * 新增时验证名称
 * @param item
 */
function ajaxCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_product','cname',field.val(),'*名称重复');
	}
}
/**
 * 修改产品信息
 */
function _modifyProduct(){
	var rows = _productTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		_ligerDialog = $.ligerDialog.open({ target: $("#modifyDiv"),title:"修改产品",width:480,height:340,
			buttons:[{text:"保存",onclick:function(i,d){submitForm("modifyForm");}},{text:"关闭",onclick:function(i,d){d.hide();resetModifyItem();}}]
		});
		setModifyItem(rows[0].uid,rows[0].ucategoryid,rows[0].ccategoryname,rows[0].cno,rows[0].cname,rows[0].nprice);
	}else{
		$.ligerDialog.warn("请选择需要修改的产品!");
	}
}
/**
 * 修改时验证编码
 * @param item
 */
function ajaxModifyCNo(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cno)
			return checkData('t_product','cno',field.val(),'*编码重复');
	}
}

/**
 * 修改时验证名称
 * @param item
 */
function ajaxModifyCName(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != _old_cname)
			return checkData('t_product','cname',field.val(),'*名称重复');
	}
}
/**
 * 设置修改时表单数据
 * @param uid
 * @param ucategoryid
 * @param cno
 * @param cname
 * @param nprice
 */
function setModifyItem(uid,ucategoryid,ccategoryname,cno,cname,nprice){
	_old_cno = cno;
	_old_cname = cname;
	$("#modify_uid").val(uid);
	$("#modify_ucategoryid").val(ucategoryid);
	$("#modify_box_ucategoryid").val(ccategoryname);
	$("#modify_cno").val(cno);
	$("#modify_cname").val(cname);
	$("#modify_nprice").val(nprice);
}
/**
 * 重置修改时表单数据
 */
function resetModifyItem(){
	_old_cno = null;
	_old_cname = null;
	$("#modify_uid").val("");
	$("#modify_ucategoryid").val("");
	$("#modify_box_ucategoryid").val("");
	$("#modify_cno").val("");
	$("#modify_cname").val("");
	$("#modify_nprice").val("");
}
/**
 * 删除产品信息
 */
function _deleteProduct(){
	var rows = _productTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗?",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/lovelysnow/deleteProduct",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "have"){
							$.ligerDialog.error("此产品已被使用,不能删除此产品!");
						}else{
							$.ligerDialog.success("数据删除成功!");
							_productTableTr.loadData();
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的产品!");
	}
}