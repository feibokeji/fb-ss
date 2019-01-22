/**
 * 同行信息操作JavaScript
 */
var counterPartsDialog,counterPartsTable;
var searchCshopname,searchCoperator,searchCtelephone,searchCwechat,searchCbusinessscope,searchIbusinessstatus,searchIpaymentdaysMin,searchIpaymentdaysMax,searchDrecorddateMin,searchDrecorddateMax;
$(function(){
	$("#searchTable").validationEngine('attach', { 
		 promptPosition: 'bottomRight',scroll:false
	});
	$("#searchDrecorddateMin,#searchDrecorddateMax").ligerDateEditor();
	counterPartsTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'用户表外键', name : 'uuserid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'部门表外键', name : 'udeptid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '商铺名称', name: 'cshopname', width: 120, minWidth: 100 },
            { display: '经营者', name: 'coperator', width: 120,minWidth: 100 },
            { display: '联系电话', name: 'ctelephone', width: 120,minWidth: 100 },
            { display: '微信', name: 'cwechat', width: 120,minWidth: 100 },
            { display: '地址', name: 'caddress', width: 200,minWidth: 120 },
            { display: '经营范围', name: 'cbusinessscope', width: 200,minWidth: 120 },
            { display: '经营状态', name: 'ibusinessstatusStr', width: 80,minWidth: 60 },
            { display: '账期(天数)', name: 'ipaymentdays', width: 80,minWidth: 60 },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 80 },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 80 }
            ],
        toolbar: { items: [
	            { text: '增加', click: addCounterParts, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyCounterParts, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteCounterParts, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/counterParts/getCounterPartsJSON",
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
function searchCounterParts()
{
	if($("#searchTable").validationEngine("validate")){
		searchCshopname = $("#searchCshopname").val();
		searchCoperator = $("#searchCoperator").val();
		searchCtelephone = $("#searchCtelephone").val();
		searchCwechat = $("#searchCwechat").val();
		searchCbusinessscope = $("#searchCbusinessscope").val();
		searchIbusinessstatus = $("#searchIbusinessstatus").val();
		searchIpaymentdaysMin = $("#searchIpaymentdaysMin").val();
		searchIpaymentdaysMax = $("#searchIpaymentdaysMax").val();
		searchDrecorddateMin = $("#searchDrecorddateMin").val();
		searchDrecorddateMax = $("#searchDrecorddateMax").val();
		counterPartsTable.setParm("cshopname",searchCshopname);
		counterPartsTable.setParm("coperator",searchCoperator);
		counterPartsTable.setParm("ctelephone",searchCtelephone);
		counterPartsTable.setParm("cwechat",searchCwechat);
		counterPartsTable.setParm("cbusinessscope",searchCbusinessscope);
		counterPartsTable.setParm("ibusinessstatus",searchIbusinessstatus);
		counterPartsTable.setParm("ipaymentdaysMin",searchIpaymentdaysMin);
		counterPartsTable.setParm("ipaymentdaysMax",searchIpaymentdaysMax);
		counterPartsTable.setParm("drecorddateStrMin",searchDrecorddateMin);
		counterPartsTable.setParm("drecorddateStrMax",searchDrecorddateMax);
		counterPartsTable.loadData();
	}
}
function addCounterParts()
{
	counterPartsDialog = $.ligerDialog.open({url:contextPath+"/bpr/counterParts/add",title:"新增同行",allowClose:true,width:640,height:500});
}
function modifyCounterParts()
{
	var rows = counterPartsTable.getCheckedRows();
	if(rows != null && rows != ""){
		counterPartsDialog = $.ligerDialog.open({url:contextPath+"/bpr/counterParts/modify?uid="+rows[0].uid,title:"修改同行",allowClose:true,width:640,height:500});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的同行信息!");
	}
}
function deleteCounterParts()
{
	var rows = counterPartsTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/counterParts/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							counterPartsTable.loadData();
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
		$.ligerDialog.warn("请选择需要删除的同行信息!");
	}
}