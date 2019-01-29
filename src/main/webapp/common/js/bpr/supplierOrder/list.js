/**
 * 供应商单据管理页面JavaScript
 */
var supplierOrderDialog = null;
var supplierOrderTable = null;
//下拉框
var supplierComboBox,itypeComboBox,istatusComboBox;
/**
 * 加载函数
 * @returns
 */
$(function(){
	$("#searchDrecorddateStrMin,#searchDrecorddateStrMax").ligerDateEditor();
	supplierOrderTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'供应商表外键', name : 'usupplierid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'部门表外键', name : 'uuserid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'部门表外键', name : 'udeptid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'单据类型', name : 'itype', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'单据状态', name : 'istatus', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '单据编号', name: 'cno', width: 140,minWidth: 120 },
            { display: '供应商', name: 'csuppliername', width: 120, minWidth: 100 },
            { display: '单据类型', name: 'itypeStr', width: 100,minWidth: 80 },
            { display: '单据状态', name: 'istatusStr', width: 100,minWidth: 80 },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120 }
            ],
        toolbar: { items: [
        		{ text: '详细', click: viewSupplierOrder, icon: 'view'},
            	{ line: true },
	            { text: '增加', click: addSupplierOrder, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifySupplierOrder, icon: 'modify' },
	            { line: true },
	            { text: '审核', click: auditSupplierOrder, icon: 'ok'},
	            { line: true },
	            { text: '反审核', click: reverseAuditSupplierOrder, icon: 'refresh'},
	            { line: true },
	            { text: '删除', click: deleteSupplierOrder, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/supplierOrder/getSupplierOrderJSON",
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
	supplierComboBox = $("#searchCsuppliername").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/supplier/getSupplierJSON",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#searchUsupplierid").val(value);
		}
	});
	itypeComboBox = $("#searchItypeStr").ligerComboBox({
		data:[
			{text:'入库单',id:'0'},
			{text:'退库单',id:'1'},
			{text:'报损单',id:'2'}
		],valueFieldID:'searchItype'
	});
	istatusComboBox = $("#searchIstatusStr").ligerComboBox({
		data:[
			{text:'已审核',id:'0'},
			{text:'未审核',id:'1'}
		],valueFieldID:'searchIstatus'
	});
});
//查询供应商单据
function searchSupplierOrder()
{
	var _cno = $("#searchCno").val();
	var _itype = $("#searchItype").val();
	var _istatus = $("#searchIstatus").val();
	var _drecorddateStrMin = $("#searchDrecorddateStrMin").val();
	var _drecorddateStrMax = $("#searchDrecorddateStrMax").val();
	
	supplierOrderTable.setParm("usupplierid",supplierComboBox.getValue());
	supplierOrderTable.setParm("cno",_cno);
	if(_itype.isInteger()){
		supplierOrderTable.setParm("itype",_itype);
	}else{
		supplierOrderTable.setParm("itype",-1);
	}
	if(_istatus.isInteger()){
		supplierOrderTable.setParm("istatus",_istatus);
	}else{
		supplierOrderTable.setParm("istatus",-1);
	}
	supplierOrderTable.setParm("drecorddateStrMin",_drecorddateStrMin);
	supplierOrderTable.setParm("drecorddateStrMax",_drecorddateStrMax);
	supplierOrderTable.loadData();
}
//查看供应商单据
function viewSupplierOrder(){
	
}
//新增供应商单据
function addSupplierOrder()
{
	//supplierDialog = $.ligerDialog.open({url:contextPath+"/bpr/supplier/add",title:"新增供应商",allowClose:true,width:640,height:500});
}
//修改供应商单据
function modifySupplierOrder()
{
	//var rows = supplierTable.getCheckedRows();
	//if(rows != null && rows != ""){
		//supplierDialog = $.ligerDialog.open({url:contextPath+"/bpr/supplier/modify?uid="+rows[0].uid,title:"修改供应商",allowClose:true,width:640,height:500});
	//}
	//else
	//{
		//$.ligerDialog.warn("请选择需要修改的供应商信息!");
	//}
}
//审核供应商单据
function auditSupplierOrder(){
	
}
//反审核供应商单据
function reverseAuditSupplierOrder(){
	
}
//删除供应商单据
function deleteSupplierOrder()
{
//	var rows = supplierTable.getCheckedRows();
//	if(rows != null && rows != ""){
//		$.ligerDialog.confirm("确定要删除吗？",function(yes){
//			if(yes){
//				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
//				$.ajax({
//					type:"post",
//					async:false,
//					cache:false,
//					url:contextPath+"/bpr/supplier/delete",
//					data:{'uid':rows[0].uid},
//					dataType:"html",
//					success:function(data){
//						waitting.close();
//						if(data == "fail")
//							$.ligerDialog.error("数据删除失败!");
//						else if(data == "success"){
//							supplierTable.loadData();
//							$.ligerDialog.success("数据删除成功!");
//						}else{
//							$.ligerDialog.error(data);
//						}
//					}
//				});
//			}
//		});
//	}
//	else
//	{
//		$.ligerDialog.warn("请选择需要删除的供应商信息!");
//	}
}