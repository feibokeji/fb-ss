/*供应商手机单据管理页面*/
var listTable = null,supplierComboBox = null,brandComboBox = null,itypeComboBox = null,istatusComboBox = null;
$(function(){
	$("#searchDrecorddateStrMin,#searchDrecorddateStrMax").ligerDateEditor();
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
	brandComboBox = $("#searchBrand").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/brand/getBrandJSON",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#searchUbrandid").val(value);
		}
	});
	itypeComboBox = $("#searchItypeStr").ligerComboBox({
		data:[
			{text:'入库',id:'0'},
			{text:'退库',id:'1'},
			{text:'销售',id:'2'},
			{text:'退货',id:'3'},
			{text:'调出',id:'4'},
			{text:'调入',id:'5'}
		],valueFieldID:'searchItype'
	});
	istatusComboBox = $("#searchIstatusStr").ligerComboBox({
		data:[
			{text:'未审核',id:'0'},
			{text:'已审核',id:'1'}
		],valueFieldID:'searchIstatus'
	});
	listTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display: '供应商', name: 'csuppliername', width: 120, minWidth: 100 },
            { display: '品牌', name: 'cbrandname', width: 80, minWidth: 60 },
            { display: '型号', name: 'cphonemodelname', width: 120, minWidth: 100 },
            { display: '手机串号(IMEI)', name: 'imei', width: 120, minWidth: 100 },
            { display: '颜色', name: 'ccolorname', width: 80, minWidth: 60 },
            { display: '进货价(元)', name: 'ncostprice', width: 60, minWidth: 60 },
            { display: '销售价(元)', name: 'nretailprice', width: 60, minWidth: 60 },
            { display: '类型', name: 'itypeStr', width: 60,minWidth: 60 },
            { display: '状态', name: 'istatusStr', width: 60,minWidth: 60 },
            { display: '运行内存(RAM)', name: 'cram', width: 120, minWidth: 100 },
            { display: '存储内存(ROM)', name: 'crom', width: 120, minWidth: 100 },
            { display: '处理器(CPU)', name: 'ccpu', width: 120, minWidth: 100 },
            { display: '摄像头', name: 'ccamera', width: 120, minWidth: 100 },
            { display: '屏幕', name: 'cscreen', width: 120, minWidth: 100 },
            { display: '电池', name: 'cbattery', width: 120, minWidth: 100 },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120 }
            ],
        toolbar: { items: [
                { text: '退库', click: returnOrder, icon: 'back'},
				{ line: true },
	            { text: '审核', click: auditOrder, icon: 'ok'},
	            { line: true },
	            { text: '反审核', click: reverseAuditOrder, icon: 'refresh'},
	            { line: true },
	            { text: '删除', click: deleteOrder, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/supplierPhoneOrder/getOrderListJSON",
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
	    detail:{height:'auto',onShowDetail:showDetail}
	});
});
//查询功能
function searchSupplierPhoneOrder(){
	var imei = $("#searchIMEI").val();
	var cphonemodelname = $("#searchCphonemodelname").val();
	var ccolorname = $("#searchCcolorname").val();
	var itype = $("#searchItype").val();
	var istatus = $("#searchIstatus").val();
	var drecorddateStrMin = $("#searchDrecorddateStrMin").val();
	var drecorddateStrMax = $("#searchDrecorddateStrMax").val();
	
	listTable.setParm("usupplierid",supplierComboBox.getValue());
	listTable.setParm("imei",imei);
	listTable.setParm("ubrandid",brandComboBox.getValue());
	listTable.setParm("cphonemodelname",cphonemodelname);
	listTable.setParm("ccolorname",ccolorname);
	if(itype.isInteger()){
		listTable.setParm("itype",itype);
	}else{
		listTable.setParm("itype",-1);
	}
	if(istatus.isInteger()){
		listTable.setParm("istatus",istatus);
	}else{
		listTable.setParm("istatus",-1);
	}
	listTable.setParm("drecorddateStrMin",drecorddateStrMin);
	listTable.setParm("drecorddateStrMax",drecorddateStrMax);
	listTable.loadData();
}
//应收应付记录+状态记录
function showDetail(row, detailPanel,callback){
	var div1 = document.createElement('div');
	$(div1).attr("tabid","tabDiv1");
	$(div1).attr("title","应收/应付款")
	var div2 = document.createElement('div');
	$(div2).attr("tabid","tabDiv2");
	$(div2).attr("title","状态记录")
	var tabDiv = document.createElement('div');
	$(tabDiv).attr("id","navtab");
	$(tabDiv).append(div1);
	$(tabDiv).append(div2);
	$(tabDiv).ligerTab();
	$(detailPanel).append(tabDiv);
	
	var rpUrl = contextPath + "/bpr/supplierPhoneOrder/getOrderReceivableListJSON?phoneimei=" + row.imei;
	var statusUrl = contextPath + "/bpr/supplierPhoneOrder/getOrderStatusListJSON?phoneimei=" + row.imei;
	
	var rpGrid = document.createElement('div');
	$(div1).append(rpGrid);
	$(rpGrid).css('margin',10).ligerGrid({
		columns:[
		        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
		        	{ display: '供应商', name: 'csuppliername', width: 100,minWidth: 80 },
		            { display: '手机串号(IMEI)', name: 'imei', width: 100, minWidth: 80},
		            { display: '操作员', name: 'cusername', width: 100,minWidth: 80 },
			        { display: '类型', name: 'ctypeStr', width: 100,minWidth: 80 },
			        { display: '原有金额', name: 'nactualamount', width: 100,minWidth: 80 },
			        { display: '折扣', name: 'ndiscount', width: 100,minWidth: 80 },
			        { display: '实际金额', name: 'namount', width: 100,minWidth: 80 },
			        { display: '状态', name: 'istatusStr', width: 100,minWidth: 80 },
			        { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 },
			        { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120 }
		        ], 
		url:rpUrl,
		isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
		rownumbers:true,frozen: false,usePager:false,
		onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
		enabledEdit: true, clickToEdit: true
	});
	var statusGrid = document.createElement('div');
	$(div2).append(statusGrid);
	$(statusGrid).css('margin',10).ligerGrid({
		columns:[
		        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
		            { display: '手机串号(IMEI)', name: 'imei', width: 100, minWidth: 80},
			        { display: '类型', name: 'itypeStr', width: 100,minWidth: 80 },
			        { display: '状态', name: 'istatusStr', width: 100,minWidth: 80 },
			        { display: '操作员', name: 'cusername', width: 100,minWidth: 80 },
			        { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 }
		        ], 
		url:statusUrl,
		isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
		rownumbers:true,frozen: false,usePager:false,
		onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
		enabledEdit: true, clickToEdit: true
	});
}
//手机退库
function returnOrder(){
	//退库功能满足条件：单据状态-入库
	var rows = listTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ajax({
			type:"post",
			async:false,
			cache:false,
			url:contextPath+"/bpr/supplierPhoneOrder/validReturn",
			data:{'imei':rows[0].imei},
			dataType:"html",
			success:function(data){
				if(data == "y"){
					$.ligerDialog.confirm("确定要进行退库吗？",function(yes){
						if(yes){
							var waitting = $.ligerDialog.waitting('数据退库中,请稍候...');
							$.ajax({
								type:"post",
								async:false,
								cache:false,
								url:contextPath+"/bpr/supplierPhoneOrder/returnOrder",
								data:{'imei':rows[0].imei},
								dataType:"html",
								success:function(data){
									waitting.close();
									if(data == "fail")
										$.ligerDialog.error("数据退库失败!");
									else if(data == "success"){
										listTable.loadData();
										$.ligerDialog.success("数据退库成功!");
									}else{
										$.ligerDialog.error(data);
									}
								}
							});
						}
					});
				}else{
					$.ligerDialog.error("此手机信息不能办理退库。");
				}
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要退库的手机信息!");
	}
}
//审核
function auditOrder(){
	var rows = listTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ajax({
			type:"post",
			async:false,
			cache:false,
			url:contextPath+"/bpr/supplierPhoneOrder/validAudit",
			data:{'imei':rows[0].imei},
			dataType:"html",
			success:function(data){
				if(data == "y"){
					$.ligerDialog.confirm("确定要审核吗？",function(yes){
						if(yes){
							var waitting = $.ligerDialog.waitting('数据审核中,请稍候...');
							$.ajax({
								type:"post",
								async:false,
								cache:false,
								url:contextPath+"/bpr/supplierPhoneOrder/audit",
								data:{'imei':rows[0].imei},
								dataType:"html",
								success:function(data){
									waitting.close();
									if(data == "fail")
										$.ligerDialog.error("数据审核失败!");
									else if(data == "success"){
										listTable.loadData();
										$.ligerDialog.success("数据审核成功!");
									}else{
										$.ligerDialog.error(data);
									}
								}
							});
						}
					});
				}else{
					$.ligerDialog.error("此手机已审核！不能重复审核。");
				}
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要审核的手机信息!");
	}
}
//反审核
function reverseAuditOrder(){
	var rows = listTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ajax({
			type:"post",
			async:false,
			cache:false,
			url:contextPath+"/bpr/supplierPhoneOrder/validReverseAudit",
			data:{'imei':rows[0].imei},
			dataType:"html",
			success:function(data){
				if(data == "y"){
					$.ligerDialog.confirm("确定要反审核吗？",function(yes){
						if(yes){
							var waitting = $.ligerDialog.waitting('数据反审核中,请稍候...');
							$.ajax({
								type:"post",
								async:false,
								cache:false,
								url:contextPath+"/bpr/supplierPhoneOrder/reverseAudit",
								data:{'imei':rows[0].imei},
								dataType:"html",
								success:function(data){
									waitting.close();
									if(data == "fail")
										$.ligerDialog.error("数据反审核失败!");
									else if(data == "success"){
										listTable.loadData();
										$.ligerDialog.success("数据反审核成功!");
									}else{
										$.ligerDialog.error(data);
									}
								}
							});
						}
					});
				}else{
					$.ligerDialog.error("此手机不能进行反审核！");
				}
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要反审核的手机信息!");
	}
}
//删除
function deleteOrder(){
	var rows = listTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ajax({
			type:"post",
			async:false,
			cache:false,
			url:contextPath+"/bpr/supplierPhoneOrder/validDelete",
			data:{'imei':rows[0].imei},
			dataType:"html",
			success:function(data){
				if(data == "y"){
					$.ligerDialog.confirm("确定要删除吗？",function(yes){
						if(yes){
							var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
							$.ajax({
								type:"post",
								async:false,
								cache:false,
								url:contextPath+"/bpr/supplierPhoneOrder/delete",
								data:{'imei':rows[0].imei},
								dataType:"html",
								success:function(data){
									waitting.close();
									if(data == "fail")
										$.ligerDialog.error("数据删除失败!");
									else if(data == "success"){
										listTable.loadData();
										$.ligerDialog.success("数据删除成功!");
									}else{
										$.ligerDialog.error(data);
									}
								}
							});
						}
					});
				}else{
					$.ligerDialog.error("此手机不能进行删除！");
				}
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要删除的手机信息!");
	}
}