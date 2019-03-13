/**
 * 客户信息JavaScript
 */
var customerTypeTable,customerTypeDialog;
var customerTable,customerDialog;
var searchCustomerTypeUid,searchCname,searchIsex,searchCcontactnumber,searchCwechat
,searchDbirthdayMin,searchDbirthdayMax,iintegralMin,iintegralMax,ipaymentdaysMin,ipaymentdaysMax,drecorddateMin,drecorddateMax;
$(function(){
	//页面布局
	$("#layout1").ligerLayout({ leftWidth: 300});
	//查询验证
	$("#searchCustomerForm").validationEngine('attach', { 
		 promptPosition: 'bottomRight',scroll:false
	});
	//日历控件
	$("#searchDbirthdayMin,#searchDbirthdayMax,#drecorddateMin,#drecorddateMax").ligerDateEditor();
	$("#customerTypeToolBar").ligerToolBar({
		items:[
		       { text: '增加', click: addCustomerType, icon: 'add' },
	           { line: true },
	           { text: '修改', click: modifyCustomerType, icon: 'modify' },
	           { line: true },
	           { text: '删除', click: deleteCustomerType, icon:'delete' }
		]
	});
	//客户类型列表
	customerTypeTable = window['customerTypeMaingrid'] = $("#customerTypeMaingrid").ligerGrid({
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'cno', align: 'left', width: 40, minWidth: 40 },
            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' },
            { display: '账期(天数)', name: 'ipaymentdays', width: 80,minWidth: 60, align:'left' }
            ],
		url:contextPath + "/bpr/customer/getCustomerTypeJSON",
	    rownumbers:true,usePager:false,
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false,
	    onBeforeCheckAllRow:function(checked, grid ,element){
	    	return false;//禁用全选
	    },
	    onCheckRow:function(checked,rowdata,rowindex){
	    	if(checked){
	    		for(var rowid in this.records)
		    		this.unselect(rowid);
		    	this.select(rowindex);
		    	$("#searchCustomerTypeUid").val(rowdata.uid);
		    	$("#searchCustomerTypeCname").val(rowdata.cname);
	    	}else{
	    		this.unselect(rowindex);
	    		$("#searchCustomerTypeUid").val("");
		    	$("#searchCustomerTypeCname").val("");
	    	}
	    }
	});
	$("#customerToolBar").ligerToolBar({
		items:[
		    {text:'增加',click:addCustomer,icon:'add'},
			{line:true},
			{text:'修改',click:modifyCustomer,icon:'modify'},
			{line:true},
			{text:'删除',click:deleteCustomer,icon:'delete'}
		]
	});
	//客户信息列表
	customerTable = window['customerMaingrid'] = $("#customerMaingrid").ligerGrid({
		columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '客户类型外键', name: 'ucustomertypeid', align: 'left', width: 40, minWidth: 40 ,hide: true},
            { display: '用户外键', name: 'uuserid', width: 120,minWidth: 100 ,hide: true},
            { display: '部门外键', name: 'udeptid', width: 120,minWidth: 100 ,hide: true},
            { display: '客户类型', name: 'ccustomertypename', width: 120,minWidth: 100, align:'left'},
            { display: '客户名称', name: 'cname', width: 120,minWidth: 100, align:'left'},
            { display: '性别', name: 'isexStr', width: 120,minWidth: 100, align:'left'},
            { display: '联系电话', name: 'ccontactnumber', width: 120,minWidth: 100, align:'left'},
            { display: '地址', name: 'caddress', width: 120,minWidth: 100, align:'left'},
            { display: '微信', name: 'cwechat', width: 120,minWidth: 100, align:'left'},
            { display: '生日', name: 'dbirthdayStr', width: 120,minWidth: 100, align:'left'},
            { display: '积分', name: 'iintegral', width: 120,minWidth: 100, align:'left'},
            { display: '账期(天数)', name: 'ipaymentdays', width: 120,minWidth: 100, align:'left'},
            { display: '记录日期', name: 'drecorddateStr', width: 120,minWidth: 100, align:'left'},
            { display: '更新日期', name: 'dupdatedateStr', width: 120,minWidth: 100, align:'left'}
            ],
		url:contextPath + "/bpr/customer/getCustomerJSON",
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
//新增客户类型
function addCustomerType(){
	customerTypeDialog = $.ligerDialog.open({url:contextPath+"/bpr/customer/addCustomerType",title:"新增客户类型",allowClose:true,width:540,height:320});
}
//修改客户类型
function modifyCustomerType(){
	var rows = customerTypeTable.getCheckedRows();
	if(rows != null && rows != ""){
		customerTypeDialog = $.ligerDialog.open({url:contextPath+"/bpr/customer/modifyCustomerType?uid="+rows[0].uid,title:"修改客户类型",allowClose:true,width:540,height:320});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的客户类型信息!");
	}
}
//删除客户类型
function deleteCustomerType(){
	var rows = customerTypeTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/customer/deleteCustomerType",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							customerTypeTable.loadData();
							$.ligerDialog.success("数据删除成功!");
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}
	else{
		$.ligerDialog.warn("请选择需要删除的客户类型信息！");
	}
}
//新增客户信息
function addCustomer(){
	customerDialog = $.ligerDialog.open({url:contextPath+"/bpr/customer/addCustomer",title:"新增客户信息",allowClose:true,width:640,height:400});
}
//修改客户信息
function modifyCustomer(){
	var rows = customerTable.getCheckedRows();
	if(rows != null && rows != ""){
		customerDialog = $.ligerDialog.open({url:contextPath+"/bpr/customer/modifyCustomer?uid="+rows[0].uid,title:"修改客户信息",allowClose:true,width:640,height:400});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的客户信息!");
	}
}
//删除客户信息
function deleteCustomer(){
	var rows = customerTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/customer/deleteCustomer",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							customerTable.loadData();
							$.ligerDialog.success("数据删除成功!");
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}
	else{
		$.ligerDialog.warn("请选择需要删除的客户信息！");
	}
}
//查询客户信息
function searchCustomer()
{
	if($("#searchCustomerForm").validationEngine("validate")){
		searchCustomerTypeUid = $("#searchCustomerTypeUid").val();
		searchCname = $("#searchCname").val();
		searchIsex = parseInt($("#searchIsex").val());
		searchCcontactnumber = $("#searchCcontactnumber").val();
		searchCwechat = $("#searchCwechat").val();
		searchDbirthdayMin = $("#searchDbirthdayMin").val();
		searchDbirthdayMax = $("#searchDbirthdayMax").val();
		iintegralMin = $("#iintegralMin").val();
		iintegralMax = $("#iintegralMax").val();
		ipaymentdaysMin = $("#ipaymentdaysMin").val();
		ipaymentdaysMax = $("#ipaymentdaysMax").val();
		drecorddateMin = $("#drecorddateMin").val();
		drecorddateMax = $("#drecorddateMax").val();
		customerTable.setParm("ucustomertypeid",searchCustomerTypeUid);
		customerTable.setParm("cname",searchCname);
		if(!isNaN(searchIsex))
			customerTable.setParm("isex",searchIsex);
		customerTable.setParm("ccontactnumber",searchCcontactnumber);
		customerTable.setParm("cwechat",searchCwechat);
		customerTable.setParm("dbirthdayStrMin",searchDbirthdayMin);
		customerTable.setParm("dbirthdayStrMax",searchDbirthdayMax);
		customerTable.setParm("iintegralMin",iintegralMin);
		customerTable.setParm("iintegralMax",iintegralMax);
		customerTable.setParm("ipaymentdaysMin",ipaymentdaysMin);
		customerTable.setParm("ipaymentdaysMax",ipaymentdaysMax);
		customerTable.setParm("drecorddateStrMin",drecorddateMin);
		customerTable.setParm("drecorddateStrMax",drecorddateMax);
		customerTable.loadData();
		$('input[name="searchIsex"]').removeAttr("checked");
	}
}