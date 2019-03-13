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
	$("#supplierOrderToolBar").ligerToolBar({
		items:[
		    { text: '查看', click: viewSupplierOrder, icon: 'view'},
            { line: true },
	        { text: '修改', click: modifySupplierOrder, icon: 'modify' },
	        { line: true },
	        { text: '审核', click: auditSupplierOrder, icon: 'ok'},
	        { line: true },
	        { text: '反审核', click: reverseAuditSupplierOrder, icon: 'refresh'},
	        { line: true },
	        { text: '删除', click: deleteSupplierOrder, icon:'delete' }
		]
	});
	supplierOrderTable = window['maingrid'] = $("#maingrid").ligerGrid({
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'供应商表外键', name : 'usupplierid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'部门表外键', name : 'uuserid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'部门表外键', name : 'udeptid', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'单据类型', name : 'itype', align: 'left', width:100, minWidth: 60,hide: true},
            { display:'单据状态', name : 'istatus', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '单据编号', name: 'cno', width: 140,minWidth: 120, align:'left' },
            { display: '供应商', name: 'csuppliername', width: 120, minWidth: 100, align:'left' },
            { display: '单据类型', name: 'itypeStr', width: 70,minWidth: 50, align:'left' },
            { display: '单据状态', name: 'istatusStr', width: 70,minWidth: 50, align:'left' },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120, align:'left' },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120, align:'left' }
            ],
		url:contextPath + "/bpr/supplierOrder/getSupplierOrderJSON",
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
	    detail:{height:'auto',onShowDetail:showDetailAndAP}
	});
	supplierComboBox = $("#searchCsuppliername").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' }
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
function showDetailAndAP(row, detailPanel,callback){
	var div1 = document.createElement('div');
	$(div1).attr("tabid","tabDiv1");
	$(div1).attr("title","单据明细")
	var div2 = document.createElement('div');
	$(div2).attr("tabid","tabDiv2");
	$(div2).attr("title","应收/应付")
	var tabDiv = document.createElement('div');
	$(tabDiv).attr("id","navtab");
	$(tabDiv).append(div1);
	$(tabDiv).append(div2);
	$(tabDiv).ligerTab();
	$(detailPanel).append(tabDiv);
	
	var detailGrid = document.createElement('div');
	$(div1).append(detailGrid);
	$(detailGrid).css('margin',10).ligerGrid({
		columns:[
		        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
		        	{ display: '商品类别', name: 'ccategoryname', width: 100,minWidth: 80, align:'left' },
		            { display: '商品编号', name: 'cno', width: 100, minWidth: 80, align:'left'},
		            { display: '商品条形码', name: 'cbarcode', width: 100, minWidth: 80, align:'left'},
		            { display: '品牌', name: 'cbrandname', width: 100,minWidth: 80, align:'left' },
		            { display: '商品名称', name: 'cname', width: 100,minWidth: 80, align:'left' },
		            { display: '单位', name: 'cunitname', width: 100,minWidth: 80, align:'left' },
		            { display: '数量', name: 'nquantity', width: 100,minWidth: 80, align:'left' },
		            { display: '价格', name: 'nprice', width: 100,minWidth: 80, align:'left' },
		            { display: '金额', name: 'namount', width: 100,minWidth: 80, align:'left' }
		        ], 
		url:contextPath + "/bpr/supplierOrder/getSupplierOrderDetailJSON?uorderid=" + row.uid,
		isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
		rownumbers:true,frozen: false,usePager:false,
		onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
		enabledEdit: true, clickToEdit: true
	});
	var apGrid = document.createElement('div');
	$(div2).append(apGrid);
	$(apGrid).css('margin',10).ligerGrid({
		columns:[
		         { display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
		         { display: '供应商', name: 'csuppliername', width: 120,minWidth: 100, align:'left' },
		         { display: '单据编号', name: 'corderno', width: 140,minWidth: 120, align:'left' },
		         { display: '操作员', name: 'cusername', width: 100,minWidth: 80, align:'left' },
		         { display: '类型', name: 'ctypeStr', width: 100,minWidth: 80, align:'left' },
		         { display: '原有金额', name: 'nactualamount', width: 100,minWidth: 80, align:'left' },
		         { display: '折扣', name: 'ndiscount', width: 100,minWidth: 80, align:'left' },
		         { display: '实际金额', name: 'namount', width: 100,minWidth: 80, align:'left' },
		         { display: '状态', name: 'istatusStr', width: 100,minWidth: 80, align:'left' },
		         { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120, align:'left' },
		         { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120, align:'left' },
		         ],
		url:contextPath + "/bpr/supplierOrder/getSupplierReceivableJSON?uorderid=" + row.uid,
		isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
		rownumbers:true,frozen: false,usePager:false,
		onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
		enabledEdit: true, clickToEdit: true
	});
}
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
	var rows = supplierOrderTable.getCheckedRows();
	if(rows != null && rows != ""){
		window.parent.openPage('supplierOrderView',"查看供应商单据",contextPath+'/bpr/supplierOrder/view?uorderid='+rows[0].uid);
	}else{
		$.ligerDialog.warn("请选择需要查看的单据信息!");
	}
}
//修改供应商单据
function modifySupplierOrder()
{
	var rows = supplierOrderTable.getCheckedRows();
	if(rows != null && rows != ""){
		var _itype = rows[0].itype;
		var _istatus = rows[0].istatus;
		if(parseInt(_istatus) == 1){
			var _title = "";
			switch (parseInt(_itype)) {
			case 0:
				_title = "商品入库单修改";
				break;
			case 1:
				_title = "商品退库单修改";
				break;
			case 2:
				_title = "商品报损单修改";
				break;
			}
			window.parent.openPage('supplierOrderModify',_title,contextPath+'/bpr/supplierOrder/modify?uorderid='+rows[0].uid);
		}else{
			$.ligerDialog.warn("此单据已审核不能修改！");
		}
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的单据信息!");
	}
}
//审核供应商单据
function auditSupplierOrder(){
	var rows = supplierOrderTable.getCheckedRows();
	if(rows != null && rows != ""){
		var _istatus = rows[0].istatus;
		if(parseInt(_istatus) == 1){
			$.ligerDialog.confirm("确定要审核吗？",function(yes){
				if(yes){
					var waitting = $.ligerDialog.waitting('数据审核中,请稍候...');
					$.ajax({
						type:"post",
						async:false,
						cache:false,
						url:contextPath+"/bpr/supplierOrder/audit",
						data:{'uid':rows[0].uid},
						dataType:"html",
						success:function(data){
							waitting.close();
							if(data == "fail")
								$.ligerDialog.error("数据审核失败!");
							else if(data == "success"){
								supplierOrderTable.loadData();
								$.ligerDialog.success("数据审核成功!");
							}else{
								$.ligerDialog.error(data);
							}
						}
					});
				}
			});
		}else{
			$.ligerDialog.warn("此单据已审核！");
		}
	}else{
		$.ligerDialog.warn("请选择需要审核的单据信息!");
	}
}
//反审核供应商单据
function reverseAuditSupplierOrder(){
	var rows = supplierOrderTable.getCheckedRows();
	if(rows != null && rows != ""){
		var _istatus = rows[0].istatus;
		if(parseInt(_istatus) == 0){
			$.ligerDialog.confirm("确定要反审核吗？",function(yes){
				if(yes){
					var waitting = $.ligerDialog.waitting('数据反审核中,请稍候...');
					$.ajax({
						type:"post",
						async:false,
						cache:false,
						url:contextPath+"/bpr/supplierOrder/unAudit",
						data:{'uid':rows[0].uid},
						dataType:"html",
						success:function(data){
							waitting.close();
							if(data == "fail")
								$.ligerDialog.error("数据反审核失败!");
							else if(data == "success"){
								supplierOrderTable.loadData();
								$.ligerDialog.success("数据反审核成功!");
							}else{
								$.ligerDialog.error(data);
							}
						}
					});
				}
			});
		}else{
			$.ligerDialog.warn("此单据未审核！");
		}
	}else{
		$.ligerDialog.warn("请选择需要反审核的单据信息!");
	}
}
//删除供应商单据
function deleteSupplierOrder()
{
	var rows = supplierOrderTable.getCheckedRows();
	if(rows != null && rows != ""){
		var _istatus = rows[0].istatus;
		if(parseInt(_istatus) == 1){
			$.ligerDialog.confirm("确定要删除吗？",function(yes){
				if(yes){
					var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
					$.ajax({
						type:"post",
						async:false,
						cache:false,
						url:contextPath+"/bpr/supplierOrder/delete",
						data:{'uid':rows[0].uid},
						dataType:"html",
						success:function(data){
							waitting.close();
							if(data == "fail")
								$.ligerDialog.error("数据删除失败!");
							else if(data == "success"){
								supplierOrderTable.loadData();
								$.ligerDialog.success("数据删除成功!");
							}else{
								$.ligerDialog.error(data);
							}
						}
					});
				}
			});
		}else{
			$.ligerDialog.warn("此单据已审核！不能删除。");
		}
	}else{
		$.ligerDialog.warn("请选择需要删除的单据信息!");
	}
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