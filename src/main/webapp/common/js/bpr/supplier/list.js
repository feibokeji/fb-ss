/**
 * 供应商信息页面JavaScript
 */
var supplierDialog = null;
var supplierTable = null;
var searchCname,searchCfixedtelephone,searchClinkman,searchCcontactnumber,searchCwechat,searchCbandcardnumber,searchIpaymentdaysMin,searchIpaymentdaysMax,searchDrecorddateMin,searchDrecorddateMax;
/**
 * 加载函数
 * @returns
 */
$(function(){
	$("#searchTable").validationEngine('attach', { 
		 promptPosition: 'bottomRight',scroll:false
	});
	$("#searchDrecorddateMin,#searchDrecorddateMax").ligerDateEditor();
	supplierTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'用户表外键', name : 'uuserid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'部门表外键', name : 'udeptid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'cno', align: 'left', width: 40, minWidth: 40 },
            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' },
            { display: '经营范围', name: 'cbusinessscope', width: 200,minWidth: 120, align:'left' },
            { display: '地址', name: 'caddress', width: 200,minWidth: 120, align:'left' },
            { display: '固定电话', name: 'cfixedtelephone', width: 100,minWidth: 80, align:'left' },
            { display: '联系人', name: 'clinkman', width: 100,minWidth: 80, align:'left' },
            { display: '联系电话', name: 'ccontactnumber', width: 100,minWidth: 80, align:'left' },
            { display: 'Email', name: 'cemail', width: 100,minWidth: 80, align:'left' },
            { display: 'QQ', name: 'cqq', width: 100,minWidth: 80, align:'left' },
            { display: '微信', name: 'cwechat', width: 100,minWidth: 80, align:'left' },
            { display: '开户行', name: 'copenbank', width: 100,minWidth: 80, align:'left' },
            { display: '银行卡号', name: 'cbankcardnumber', width: 100,minWidth: 80, align:'left' },
            { display: '账期(天数)', name: 'ipaymentdays', width: 80,minWidth: 60, align:'left' },
            { display: '记录日期', name: 'drecorddateStr', width: 100,minWidth: 80, align:'left' },
            { display: '更新日期', name: 'dupdatedateStr', width: 100,minWidth: 80, align:'left' }
            ],
        toolbar: { items: [
	            { text: '增加', click: addSupplier, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifySupplier, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteSupplier, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/supplier/getSupplierJSON",
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
//查询供应商
function searchSupplier()
{
	if($("#searchTable").validationEngine("validate")){
		searchCname = $("#searchCname").val();
		searchCfixedtelephone = $("#searchCfixedtelephone").val();
		searchClinkman = $("#searchClinkman").val();
		searchCcontactnumber = $("#searchCcontactnumber").val();
		searchCwechat = $("#searchCwechat").val();
		searchCbandcardnumber = $("#searchCbandcardnumber").val();
		searchIpaymentdaysMin = $("#searchIpaymentdaysMin").val();
		searchIpaymentdaysMax = $("#searchIpaymentdaysMax").val();
		searchDrecorddateMin = $("#searchDrecorddateMin").val();
		searchDrecorddateMax = $("#searchDrecorddateMax").val();
		supplierTable.setParm("cname",searchCname);
		supplierTable.setParm("cfixedtelephone",searchCfixedtelephone);
		supplierTable.setParm("clinkman",searchClinkman);
		supplierTable.setParm("ccontactnumber",searchCcontactnumber);
		supplierTable.setParm("cwechat",searchCwechat);
		supplierTable.setParm("cbandcardnumber",searchCbandcardnumber);
		supplierTable.setParm("ipaymentdaysMin",searchIpaymentdaysMin);
		supplierTable.setParm("ipaymentdaysMax",searchIpaymentdaysMax);
		supplierTable.setParm("drecorddateMin",searchDrecorddateMin);
		supplierTable.setParm("drecorddateMax",searchDrecorddateMax);
		supplierTable.loadData();
	}
}
//新增供应商
function addSupplier()
{
	supplierDialog = $.ligerDialog.open({url:contextPath+"/bpr/supplier/add",title:"新增供应商",allowClose:true,width:640,height:500});
}
//修改供应商
function modifySupplier()
{
	var rows = supplierTable.getCheckedRows();
	if(rows != null && rows != ""){
		supplierDialog = $.ligerDialog.open({url:contextPath+"/bpr/supplier/modify?uid="+rows[0].uid,title:"修改供应商",allowClose:true,width:640,height:500});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的供应商信息!");
	}
}
//删除供应商
function deleteSupplier()
{
	var rows = supplierTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/supplier/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							supplierTable.loadData();
							$.ligerDialog.success("数据删除成功!");
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}
	else
	{
		$.ligerDialog.warn("请选择需要删除的供应商信息!");
	}
}