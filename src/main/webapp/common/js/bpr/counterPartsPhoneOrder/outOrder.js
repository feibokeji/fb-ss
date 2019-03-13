/*可被调出的手机信息页面*/
var listTable = null,supplierComboBox = null,brandComboBox = null;
$(function(){
	$("#searchDrecorddateStrMin,#searchDrecorddateStrMax").ligerDateEditor();
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
	brandComboBox = $("#searchBrand").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' }
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
	$("#outOrderToolBar").ligerToolBar({
		items:[
		    { text: '调出', click: outOrder, icon: 'up'}
		]
	});
	listTable = window['maingrid'] = $("#maingrid").ligerGrid({
        columns: [
            { display: '供应商', name: 'csuppliername', width: 120, minWidth: 100, align:'left' },
            { display: '品牌', name: 'cbrandname', width: 80, minWidth: 60, align:'left' },
            { display: '型号', name: 'cphonemodelname', width: 120, minWidth: 100, align:'left' },
            { display: '手机串号(IMEI)', name: 'imei', width: 120, minWidth: 100, align:'left' },
            { display: '颜色', name: 'ccolorname', width: 80, minWidth: 60, align:'left' },
            { display: '进货价(元)', name: 'ncostprice', width: 60, minWidth: 60, align:'left' },
            { display: '销售价(元)', name: 'nretailprice', width: 60, minWidth: 60, align:'left' },
            { display: '类型', name: 'itypeStr', width: 60,minWidth: 60, align:'left' },
            { display: '状态', name: 'istatusStr', width: 60,minWidth: 60, align:'left' },
            { display: '运行内存(RAM)', name: 'cram', width: 120, minWidth: 100, align:'left' },
            { display: '存储内存(ROM)', name: 'crom', width: 120, minWidth: 100, align:'left' },
            { display: '处理器(CPU)', name: 'ccpu', width: 120, minWidth: 100, align:'left' },
            { display: '摄像头', name: 'ccamera', width: 120, minWidth: 100, align:'left' },
            { display: '屏幕', name: 'cscreen', width: 120, minWidth: 100, align:'left' },
            { display: '电池', name: 'cbattery', width: 120, minWidth: 100, align:'left' },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120, align:'left' },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120, align:'left' }
            ],
		url:contextPath + "/bpr/counterPartsPhoneOrder/outOrderJSON",
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
	    }
	});
});
//查询功能
function searchPhoneOrder(){
	var imei = $("#searchIMEI").val();
	var cphonemodelname = $("#searchCphonemodelname").val();
	var ccolorname = $("#searchCcolorname").val();
	var drecorddateStrMin = $("#searchDrecorddateStrMin").val();
	var drecorddateStrMax = $("#searchDrecorddateStrMax").val();
	listTable.setParm("usupplierid",supplierComboBox.getValue());
	listTable.setParm("imei",imei);
	listTable.setParm("ubrandid",brandComboBox.getValue());
	listTable.setParm("cphonemodelname",cphonemodelname);
	listTable.setParm("ccolorname",ccolorname);
	listTable.setParm("drecorddateStrMin",drecorddateStrMin);
	listTable.setParm("drecorddateStrMax",drecorddateStrMax);
	listTable.loadData();
}
//手机调出
function outOrder(){
	var rows = listTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ajax({
			type:"post",
			async:false,
			cache:false,
			url:contextPath+"/bpr/counterPartsPhoneOrder/validOutOrder",
			data:{'imei':rows[0].imei},
			dataType:"html",
			success:function(data){
				if(data == "y"){
					var ligerDialog = $.ligerDialog.open({url:contextPath+"/bpr/counterParts/choose",title:"手机调出->同行",allowClose:true,width:1000,height:480,
						buttons:[{text:"调出",onclick:function(i,d){
							var selectedRows = ligerDialog.frame.counterPartsTable.getSelectedRows();
							if(selectedRows.length > 0){
								$.ligerDialog.confirm("确定要进行同行调出手机业务吗？",function(yes){
									if(yes){
										var waitting = $.ligerDialog.waitting('数据执行中,请稍候...');
										$.ajax({
											type:"post",
											async:false,
											cache:false,
											url:contextPath+"/bpr/counterPartsPhoneOrder/executeOutOrder",
											data:{'ucounterpartsid':selectedRows[0].uid,'imei':rows[0].imei},
											dataType:"html",
											success:function(data){
												waitting.close();
												if(data == "fail")
													$.ligerDialog.error("数据执行失败!");
												else if(data == "success"){
													listTable.loadData();
													$.ligerDialog.success("数据执行成功!");
												}else{
													$.ligerDialog.error(data);
												}
											}
										});
									}
								});
							}else
								$.ligerDialog.error("请选择同行信息后，再进行调出业务！");
						}},
						{text:"关闭",onclick:function(i,d){d.hide();}}]
					});
				}else{
					$.ligerDialog.error("此手机信息不能办理同行调出业务！");
				}
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要调出的手机信息!");
	}
}