/**
 * 可爱雪-财务单据
 */
var orderTableTr = null;
/*var orderData = null;*/
var combobox = null;
var box_account = null;
var comboboxData = null;
var box_account_data = null;
var dialog = null;
var _ligerDialog = null;
$(function(){
	/*f_getOrderData();*/
	f_getComboboxData();
	f_getBoxAccountData();
	$("#addForm,#addAccountTypeForm,#addAccountForm").validationEngine();
	orderTableTr = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { dispaly: '主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { dispaly: '账户', name : 'caccountname', align: 'left', width:120, minWidth: 60},
            { display: '编码', name: 'ccode', align: 'left', width: 140, minWidth: 80 },
            { display: '名称', name: 'cname', align: 'left', width: 120, minWidth: 100 },
            { display: '类别', name: 'ctype', width: 80,minWidth: 60 },
            { display: '类型', name: 'caccounttypename', width: 80,minWidth: 60 },
            { display: '用户', name: 'cusername', width: 80,minWidth: 60 },
            { display: '备注', name: 'cmemo', align: 'right',width: 300,minWidth: 120 },
            { display: '时间', name: 'ccreatetime', type:'date',width: 100,minWidth: 60 },
            {display:'金额',name:'namount',type:'float',align:'right',width:80,minWidth:60},
            { display: '审核', name: 'iaudit', type:'int',
            	render: function (item){
            		if (parseInt(item.iaudit) == 1) return '<span style=\"color:green;\">已审核</span>';
                return '<span style=\"color:red;\">未审核</span>';},width: 60,minWidth: 60 }
            ],
        toolbar: { items: [
            { text: '详细', click: f_view, icon: 'view'},
            { line: true },
            { text: '新增', click: f_add, icon: 'add'},
            { line: true },
            { text: '删除', click: f_delete, icon:'delete'},
            { line: true },
            { text: '审核', click: f_audit, icon: 'ok'}
        ]},
        url:contextPath+"/bpr/lovelysnow/getAccountOrder?ctype="+ctype,
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:true,
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
	$("#orderDate").text((new Date()).pattern("yyyy年MM月dd日"));
	combobox = $("#combobox").ligerComboBox({
		data:comboboxData,
		addRowButton: '新增',
		addRowButtonClick: function (){
			combobox.clear();
            dialog = $.ligerDialog.open({
                height: 300,
                width: 400,
                title: '新增' + ctype + "类型",
                target: $("#addAccountTypeDiv"),
                showMax: false,
                showToggle: true,
                showMin: false,
                isResize: true,
                slide: false,
                buttons:[{text:"保存",onclick:function(i,d){submitAccountTypeForm($("#addAccountTypeForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
            });
		},
		onSelected: function (value){$("#uaccounttypeid").val(value);}
	});
	box_account = $("#box_account").ligerComboBox({
		data:box_account_data,
		addRowButton: '新增',
		addRowButtonClick: function (){
			box_account.clear();
            dialog = $.ligerDialog.open({
                height: 300,
                width: 400,
                title: '新增账户',
                target: $("#addAccountDiv"),
                showMax: false,
                showToggle: true,
                showMin: false,
                isResize: true,
                slide: false,
                buttons:[{text:"保存",onclick:function(i,d){submitAccountForm($("#addAccountForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
            });
		},
		onSelected: function (value){$("#uaccountid").val(value);}
	});
});
function f_getOrderData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountOrder",
		data:{'ctype':ctype},
		dataType:"json",
		success:function(data){
			orderData = data;
		}
	});
}
function f_getComboboxData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountTypeJSONArray",
		data:{'ctype':ctype},
		dataType:"json",
		success:function(data){
			comboboxData = data;
		}
	});
}
function f_getBoxAccountData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountJSONArray",
		dataType:"json",
		success:function(data){
			box_account_data = data;
		}
	});
}
//详细
function f_view(){
	var rows = orderTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		$.ajax({
			type:"post",
			async:false,
			cache:false,
			url:contextPath+"/bpr/lovelysnow/getAccountOrderDetail",
			data:{'uid':rows[0].uid},
			dataType:"json",
			success:function(data){
				//alert(JSON.stringify(data));
				//alert(data.ccreatetime)
				$("#view_create_date").text(data.ccreatetime.substring(0,data.ccreatetime.indexOf(" ")));
				$("#view_cusername").text(data.cusername);
				$("#view_caccounttypename").text(data.caccounttypename);
				$("#view_account").text(data.caccountname);
				$("#view_cname").text(data.cname);
				$("#view_nprice").text(data.accountOrderDetailList[0].nprice);
				$("#view_nqty").text(data.accountOrderDetailList[0].nqty);
				$("#view_namount").text(data.namount);
				$("#view_cmemo").text(data.cmemo);
				showImg(data.iaudit,'0','1')
				_ligerDialog = $.ligerDialog.open({ target: $("#viewDiv"),title:ctype+"单据明细",width:680,height:290,
					buttons:[{text:"关闭",onclick:function(i,d){d.hide();}}]
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要查看的单据!");
	}
}
//显示图标
function showImg(data,condition1,condition2){
	var img_url = "";
	if(data == condition1){
		img_url = contextPath+"/common/images/not_audit.png";
	}else if(data == condition2){
		img_url = contextPath+"/common/images/audit.png";
	}
	$("#seal").attr("src",img_url).show();
}
//新增
function f_add(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增"+ctype+"单据",width:680,height:290,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
function f_delete(){
	var rows = orderTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		if(rows[0].iaudit == '1'){
			$.ligerDialog.warn("您选择的单据已审核不能删除!");
		}else{
			$.ligerDialog.confirm("您确定要删除此单据吗?",function(yes){
				if(yes){
					$.ajax({
						type:"post",
						async:false,
						cache:false,
						url:contextPath+"/bpr/lovelysnow/deleteAccountOrder",
						data:{'uid':rows[0].uid},
						dataType:"html",
						success:function(data){
							if(data == "fail")
								$.ligerDialog.error("删除失败!");
							else{
								$.ligerDialog.success("删除成功!");
								orderTableTr.loadData();
							}
						}
					});
				}
			});
		}
	}else{
		$.ligerDialog.warn("请选择需要删除的单据!");
	}
}
function f_audit(){
	var rows = orderTableTr.getCheckedRows();
	if(rows != null && rows != ""){
		if(rows[0].iaudit == '1'){
			$.ligerDialog.warn("您选择的单据已审核!");
		}else{
			$.ligerDialog.confirm("您确定要审核此单据吗?",function(yes){
				if(yes){
					$.ajax({
						type:"post",
						async:false,
						cache:false,
						url:contextPath+"/bpr/lovelysnow/auditAccountOrder",
						data:{'uid':rows[0].uid,'iaudit':'1'},
						dataType:"html",
						success:function(data){
							if(data == "fail")
								$.ligerDialog.error("审核失败!");
							else{
								$.ligerDialog.success("审核成功!");
								orderTableTr.loadData();
							}
						}
					});
				}
			});
		}
	}else{
		$.ligerDialog.warn("请选择需要审核的单据!");
	}
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
 * 新增时验证编码
 * @param item
 */
function ajaxAccountCNo(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_account','cno',field.val(),'*编码重复');
	}
}
/**
 * 新增时验证名称
 * @param item
 */
function ajaxAccountCName(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_account','cname',field.val(),'*名称重复');
	}
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
						$.ligerDialog.success("保存成功!");
						_ligerDialog.hide();
						orderTableTr.loadData();
					}
				});
			}
		});
	}
}
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitAccountTypeForm(_form){
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
						f_getComboboxData();
						combobox.clearContent();
						combobox.setData(comboboxData);
						dialog.hide();
					}
				});
			}
		});
	}
}
/**
 * 提交产品类别新增/修改表单
 * @param _form 表单id
 */
function submitAccountForm(_form){
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
						f_getBoxAccountData();
						box_account.clearContent();
						box_account.setData(box_account_data);
						dialog.hide();
					}
				});
			}
		});
	}
}
function f_checkbox(checkbox){
	if(checkbox.checked)
		$("#iaudit").val(1);
	else
		$("#iaudit").val(0);
}