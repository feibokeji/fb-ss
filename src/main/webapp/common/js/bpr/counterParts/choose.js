/**
 * 同行信息操作JavaScript
 */
var counterPartsTable;
var searchCshopname,searchCoperator,searchCtelephone,searchCwechat,searchCbusinessscope,searchIpaymentdaysMin,searchIpaymentdaysMax,searchDrecorddateMin,searchDrecorddateMax;
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
		url:contextPath + "/bpr/counterParts/getCounterPartsJSON?ibusinessstatus=0",
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
		searchIpaymentdaysMin = $("#searchIpaymentdaysMin").val();
		searchIpaymentdaysMax = $("#searchIpaymentdaysMax").val();
		searchDrecorddateMin = $("#searchDrecorddateMin").val();
		searchDrecorddateMax = $("#searchDrecorddateMax").val();
		counterPartsTable.setParm("cshopname",searchCshopname);
		counterPartsTable.setParm("coperator",searchCoperator);
		counterPartsTable.setParm("ctelephone",searchCtelephone);
		counterPartsTable.setParm("cwechat",searchCwechat);
		counterPartsTable.setParm("cbusinessscope",searchCbusinessscope);
		counterPartsTable.setParm("ipaymentdaysMin",searchIpaymentdaysMin);
		counterPartsTable.setParm("ipaymentdaysMax",searchIpaymentdaysMax);
		counterPartsTable.setParm("drecorddateStrMin",searchDrecorddateMin);
		counterPartsTable.setParm("drecorddateStrMax",searchDrecorddateMax);
		counterPartsTable.loadData();
	}
}