/**
 * 调入手机信息管理
 * @author Liu Bo
 */
var ligerGrid = null,counterpartsComboBox = null,brandComboBox = null;

$(function(){
	//同行下拉框功能
	counterpartsComboBox = $("#counterparts_combobox").ligerComboBox({
		selectBoxWidth: 500, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cshopname',
		grid:{
			columns:[
			         { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
			         { display: '商铺名称', name: 'cshopname', width: 120, minWidth: 100 },
			         { display: '经营者', name: 'coperator', width: 120,minWidth: 100 },
			         { display: '联系电话', name: 'ctelephone', width: 120,minWidth: 100 },
			         { display: '经营状态', name: 'ibusinessstatusStr', width: 80,minWidth: 60 }
			],url:contextPath+"/bpr/counterParts/getCounterPartsJSON",
			rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		}
	});
	//品牌下拉框功能
	brandComboBox = $("#brand_combobox").ligerComboBox({
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
		}
	});
	//日历控件
	$("#drecorddateStrMin,#drecorddateStrMax").ligerDateEditor();
	//已调出手机信息列表信息
	ligerGrid = window['hasInMainGrid'] = $("#hasInMainGrid").ligerGrid({
		height:'100%',
		columns: [
		          { display: 'uid', name: 'uid', width: 120, minWidth: 100 ,hide:true},
		          { display: 'ucounterpartsid', name: 'ucounterpartsid', width: 120, minWidth: 100 ,hide:true},
		          { display: '同行信息', name: 'ccounterpartsname', width: 80, minWidth: 60 },
		          { display: 'ubrandid', name: 'ubrandid', width: 120, minWidth: 100 ,hide:true},
		          { display: '品牌信息', name: 'cbrandname', width: 80, minWidth: 60 },
		          { display: 'uphonemodelid', name: 'uphonemodelid', width: 120, minWidth: 100 ,hide:true},
		          { display: '型号信息', name: 'cphonemodelname', width: 120, minWidth: 100 },
		          { display: '手机串号(IMEI)', name: 'imei', width: 120, minWidth: 100 },
		          { display: 'ucolorid', name: 'ucolorid', width: 120, minWidth: 100 ,hide:true},
		          { display: '颜色', name: 'ccolorname', width: 80, minWidth: 60 },
		          { display: '同行价(元)', name: 'namount', width: 60, minWidth: 60 },
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
		   	            { text: '审核', click: auditOrder, icon: 'ok'},
		   	            { line: true },
		   	            { text: '反审核', click: reverseAuditOrder, icon: 'refresh'}
		               ]
		},
		url:contextPath + "/bpr/counterPartsPhoneOrder/getCounterPartsPhoneOrderJSON?itype=5",
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
	    },detail:{height:'auto',onShowDetail:showDetail}
	});
});
function showDetail(row, detailPanel,callback){
	var div1 = document.createElement('div');
	$(div1).attr("tabid","tabDiv1");
	$(div1).attr("title","应收/应付款")
	
	var tabDiv = document.createElement('div');
	$(tabDiv).attr("id","navtab");
	$(tabDiv).append(div1);
	
	$(tabDiv).ligerTab();
	$(detailPanel).append(tabDiv);
	
	var rpUrl = contextPath + "/bpr/counterPartsPhoneOrder/getOrderReceivableListJSON?uorderid=" + row.uid;
	var rpGrid = document.createElement('div');
	$(div1).append(rpGrid);
	$(rpGrid).css('margin',10).ligerGrid({
		columns:[
		        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
		        	{ display: '同行信息', name: 'ccounterpartsname', width: 100,minWidth: 80 },
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
}
//查询功能
function searchOrder(){
	ligerGrid.setParm("ucounterpartsid",counterpartsComboBox.getValue());
	ligerGrid.setParm("ubrandid",brandComboBox.getValue());
	ligerGrid.setParm("cphonemodelname",$("#cphonemodelname").val());
	ligerGrid.setParm("imei",$("#imei").val());
	ligerGrid.setParm("drecorddateStrMin",$("#drecorddateStrMin").val());
	ligerGrid.setParm("drecorddateStrMax",$("#drecorddateStrMax").val());
	ligerGrid.loadData();
}
//审核
function auditOrder(){
	var rows = ligerGrid.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要审核吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据执行中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/counterPartsPhoneOrder/auditOrder",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据执行失败!");
						else if(data == "success"){
							ligerGrid.loadData();
							$.ligerDialog.success("数据执行成功!");
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要审核的手机信息!");
	}
}
//反审核
function reverseAuditOrder(){
	var rows = ligerGrid.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要反审核吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据执行中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/counterPartsPhoneOrder/reverseAuditOrder",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据执行失败!");
						else if(data == "success"){
							ligerGrid.loadData();
							$.ligerDialog.success("数据执行成功!");
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("请选择需要反审核的手机信息!");
	}
}