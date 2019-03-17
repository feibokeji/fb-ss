/**
 * 供应商-商品类-应收或应付单据页面
 */
var supplierComboBox = null,statusComboBox = null,receivableGrid = null,addReceiptsDialog = null;
$(function(){
	//供应商下拉框
	supplierComboBox = $("#searchSupplierInput").ligerComboBox({
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
		}
	});
	//状态下拉框
	statusComboBox = $("#searchIstatusInput").ligerComboBox({
		data:[
			{text:'未结算',id:'0'},
			{text:'已结算',id:'1'}
		]
	});
	//日期控件
	$("#searchDrecorddateStrMinInput,#searchDrecorddateStrMaxInput").ligerDateEditor();
	//工具栏
	var toolBarName = "付款";
	if(ctype == "AR")
		toolBarName = "收款";
	$("#receivableToolBar").ligerToolBar({
		items:[
		    { text: toolBarName, click: addReceipts, icon: 'add' },
		    { line: true },
		    { text: "结算", click: settlement, icon: 'ok' }
		]
	});
	//列表
	receivableGrid = window['receivableGrid'] = $("#receivableGrid").ligerGrid({
		columns: [
		    { display:'主键',name:'uid',hide:true},
		    { display:'供应商表外键',name:'usupplierid',hide:true},
		    { display:'供应商名称',name:'csuppliername',width:80,minWidth:60,align:'left'},
		    { display:'单据编号',name:'corderno',width:140,minWidth:120,align:'left'},
		    { display:'单据类型',name:'ctypeStr',width:60,minWidth:40,align:'left'},
		    { display:'原有金额(元)',name:'nactualamount',width:80,minWidth:60,align:'left'},
		    { display:'折扣',name:'ndiscount',width:60,minWidth:40,align:'left'},
		    { display:'折扣金额(元)',name:'namount',width:80,minWidth:60,align:'left'},
		    { display:'单据状态',name:'istatus',width:80,minWidth:60,align:'left',hide:true},
		    { display:'单据状态',name:'istatusStr',width:60,minWidth:40,align:'left'},
		    { display:'操作员',name:'cusername',width:60,minWidth:40,align:'left'},
		    { display:'记录日期',name:'drecorddateStr',width:140,minWidth:120,align:'left'},
		    { display:'更新日期',name:'dupdatedateStr',width:140,minWidth:120,align:'left'}
		],url:contextPath + "/bpr/supplier/financial/goods/receivableListJSON?ctype=" + ctype,
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
	    },detail:{height:'auto',onShowDetail:showReceipts}
	});
});
//对应实收或实付明细
function showReceipts(row, detailPanel,callback){
	var div1 = document.createElement('div');
	$(div1).attr("tabid","tabDiv1");
	if(ctype == "AR")
		$(div1).attr("title",row.corderno+"-实收款项");
	else if(ctype = "AP")
		$(div1).attr("title",row.corderno+"-实付款项");
	var tabDiv = document.createElement('div');
	$(tabDiv).attr("id","navtab");
	$(tabDiv).css('margin',10);
	$(tabDiv).append(div1);
	$(tabDiv).ligerTab();
	$(detailPanel).append(tabDiv);
	var receiptsGrid = document.createElement('div');
	$(div1).append(receiptsGrid);
	$(receiptsGrid).ligerGrid({
		columns:[
		        	{ display: '主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
		        	{ display: '供应商名称', name: 'csuppliername', width: 100,minWidth: 80, align:'left' },
		            { display: '单据编号', name: 'corderno', width: 140, minWidth: 120, align:'left'},
		            { display: '支付方式', name: 'cpaymentmethodname', width: 100,minWidth: 80, align:'left' },
			        { display: '类型', name: 'ctypeStr', width: 100,minWidth: 80, align:'left' },
			        { display: '金额(元)', name: 'namount', width: 100,minWidth: 80, align:'left' },
			        { display: '状态', name: 'istatusStr', width: 100,minWidth: 80, align:'left' },
			        { display: '操作员',name:'cusername',width:60,minWidth:40,align:'left'},
			        { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120, align:'left' },
			        { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120, align:'left' }
		        ], 
		url:contextPath + "/bpr/supplier/financial/goods/receiptsListByReceivableJSON?ureceivableid=" + row.uid,
		isScroll: false, showToggleColBtn: false,showTitle: false,
		rownumbers:true,frozen: false,usePager:false,
		onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
		enabledEdit: true, clickToEdit: true
	});
}
//新增收付款
function addReceipts(){
	var rows = receivableGrid.getCheckedRows();
	if(rows.length == 0)
		$.ligerDialog.warn("请选择需要操作的信息!");
	else{
		if(parseInt(rows[0].istatus) == 1){
			$.ligerDialog.warn("此款项已结算,不能进行操作！");
		}else{
			var title = "-付款单";
			var btnValue = "付款";
			if(ctype == "AR"){
				title = "-收款单";
				btnValue = "收款";
			}
			var waitting = $.ligerDialog.waitting('数据验证中,请稍候...');
			$.ajax({
				type:"post",
				async:false,
				cache:false,
				url:contextPath+"/bpr/supplier/financial/goods/getOutstandingAmount",
				data:{'ureceivableid':rows[0].uid},
				dataType:"html",
				success:function(data){
					waitting.close();
					var outstandingAmount = parseFloat(data);
					if(outstandingAmount > 0){
						addReceiptsDialog = $.ligerDialog.open({url:contextPath+"/bpr/supplier/financial/goods/addReceipts?ureceivableid="+rows[0].uid,title:rows[0].corderno+title,allowClose:true,width:800,height:257,
							buttons:[{text:btnValue,onclick:function(i,d){
								addReceiptsDialog.frame.submitForm();
							}},{text:"关闭",onclick:function(i,d){
								d.hide();
							}}]
						});
					}else{
						$.ligerDialog.warn("该款项金额已满足结算标准,不能再进行"+btnValue);
					}
				}
			});
		}
	}
}
//搜索
function search(){
	var corderno = $("#searchOrderNoInput").val();
	var drecorddateStrMin = $("#searchDrecorddateStrMinInput").val();
	var drecorddateStrMax = $("#searchDrecorddateStrMaxInput").val();
	receivableGrid.setParm("usupplierid",supplierComboBox.getValue());
	receivableGrid.setParm("corderno",corderno);
	receivableGrid.setParm("istatus",statusComboBox.getValue());
	receivableGrid.setParm("drecorddateStrMin",drecorddateStrMin);
	receivableGrid.setParm("drecorddateStrMax",drecorddateStrMax);
	receivableGrid.loadData();
}
//结算
function settlement(){
	
}