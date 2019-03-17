/**
 * 客户手机单据列表页面
 */
var statusComboBox = null,orderListGrid = null;
$(function(){
	statusComboBox = $("#searchStatusInput").ligerComboBox({
		data:[
			{text:'未审核',id:'0'},
			{text:'已审核',id:'1'}
		]
	});
	$("#searchDrecorddateStrMin,#searchDrecorddateStrMax").ligerDateEditor();
	$("#orderListToolBar").ligerToolBar({
		items:[
		    {text:'详细',click:viewOrderDetail,icon:'view'}
		]
	});
	loadOrderListGrid();
});
//加载单据列表
function loadOrderListGrid(){
	orderListGrid = window['orderListGrid'] = $("#orderListGrid").ligerGrid({
		columns: [
		    { display:'主键',name:'uid',hide:true},
		    { display:'客户表外键',name:'ucustomerid',hide:true},
		    { display:'客户名称',name:'ccustomername',width:80,minWidth:60,align:'left'},
		    { display:'单据编号',name:'cno',width:140,minWidth:120,align:'left'},
		    { display:'单据类型',name:'itypeStr',width:60,minWidth:40,align:'left'},
		    { display:'单据状态',name:'istatusStr',width:60,minWidth:40,align:'left'},
		    { display:'操作员',name:'cusername',width:60,minWidth:40,align:'left'},
		    { display:'记录日期',name:'drecorddateStr',width:140,minWidth:120,align:'left'},
		    { display:'更新日期',name:'dupdatedateStr',width:140,minWidth:120,align:'left'}
		],url:contextPath + "/bpr/customerPhoneOrder/getCustomerPhoneOrderListJSON?itype=" + itype,
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
	});
}
//单据明细
function viewOrderDetail(){
	var rows = orderListGrid.getCheckedRows();
	if(rows.length == 0)
		$.ligerDialog.warn("请选择需要查看的单据信息!");
	else{
		window.parent.openPage('customerPhoneOrderView'+rows[0].cno,"查看客户手机"+rows[0].cno+"单据",contextPath+'/bpr/customerPhoneOrder/view?uid='+rows[0].uid);
	}
}