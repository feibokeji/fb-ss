var phoneMaingrid = null,customerMaingrid = null,brandComboBox = null,colorComboBox = null,checkStandDialog = null;
$(function(){
	$("#phoneSellMainLayout").ligerLayout({rightWidth: 300});
	brandComboBox = $("#searchBrand").ligerComboBox({
		selectBoxWidth: 200, selectBoxHeight: 240,slide:false,isShowCheckBox:false,valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' }
	        ],
	        url:contextPath + "/bpr/brand/getBrandJSON",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		}
	});
	colorComboBox = $("#searchCcolorname").ligerComboBox({
		selectBoxWidth: 200, selectBoxHeight: 240,slide:false,isShowCheckBox:false,valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' }
	        ],
	        url:contextPath + "/bpr/color/getColorJSON",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		}
	});
	//手机信息列表
	phoneMaingrid = window['phoneMaingrid'] = $("#phoneMaingrid").ligerGrid({
        columns: [
            { display: '品牌', name: 'cbrandname', width: 80, minWidth: 60, align:'left' },
            { display: '型号', name: 'cphonemodelname', width: 120, minWidth: 100, align:'left' },
            { display: '手机串号(IMEI)', name: 'imei', width: 120, minWidth: 100, align:'left' },
            { display: '颜色', name: 'ccolorname', width: 80, minWidth: 60, align:'left' },
            { display: '销售价(元)', name: 'nretailprice', width: 60, minWidth: 60, align:'left' },
            { display: '运行内存(RAM)', name: 'cram', width: 120, minWidth: 100, align:'left' },
            { display: '存储内存(ROM)', name: 'crom', width: 120, minWidth: 100, align:'left' },
            { display: '处理器(CPU)', name: 'ccpu', width: 120, minWidth: 100, align:'left' },
            { display: '摄像头', name: 'ccamera', width: 120, minWidth: 100, align:'left' },
            { display: '屏幕', name: 'cscreen', width: 120, minWidth: 100, align:'left' },
            { display: '电池', name: 'cbattery', width: 120, minWidth: 100, align:'left' }
            ],
		url:contextPath + "/bpr/customerPhoneOrder/getPhoneSellJSON",
		pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],frozen: false,fixedCellHeight:false,
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false
	});
	//客户信息列表
	customerMaingrid = window['customerMaingrid'] = $("#customerMaingrid").ligerGrid({
		columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '客户名称', name: 'cname', width: 120,minWidth: 100, align:'left'},
            { display: '联系电话', name: 'ccontactnumber', width: 120,minWidth: 100, align:'left'}
            ],
		url:contextPath + "/bpr/customer/getCustomerJSON",
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
//搜索手机
function searchPhoneOrder(){
	var imei = $("#searchIMEI").val();
	var cphonemodelname = $("#searchCphonemodelname").val();
	phoneMaingrid.setParm("imei",imei);
	phoneMaingrid.setParm("ubrandid",brandComboBox.getValue());
	phoneMaingrid.setParm("cphonemodelname",cphonemodelname);
	phoneMaingrid.setParm("ccolorname",colorComboBox.getText());
	phoneMaingrid.loadData();
}
//搜索客户
function searchCustomer(){
	var searchCustomerName = $("#searchCustomerNameInput").val();
	var searchCustomerContactnumber = $("#searchCustomerContactnumberInput").val();
	customerMaingrid.setParm("cname",searchCustomerName);
	customerMaingrid.setParm("ccontactnumber",searchCustomerContactnumber);
	customerMaingrid.loadData();
}
//结账
function settleAccounts(){
	var phoneSelectedRows = phoneMaingrid.getSelectedRows();
	var customerSelectedRow = customerMaingrid.getSelectedRow();
	if(phoneSelectedRows == null || phoneSelectedRows.length == 0){
		$.ligerDialog.warn("请选择需要销售的手机信息!");
	}
	if(customerSelectedRow == null){
		$.ligerDialog.warn("请选择购买商品的客户信息!");
	}
	if(phoneSelectedRows != null && phoneSelectedRows.length > 0 && customerSelectedRow != null){
		//进行结账操作
		var phoneIMEI = new Array();
		for(var i = 0; i < phoneSelectedRows.length; i++){
			phoneIMEI.push(phoneSelectedRows[i].imei);
		}
		var ucustomerid = customerSelectedRow.uid;
		checkStandDialog = $.ligerDialog.open({url:contextPath+"/bpr/customerPhoneOrder/checkStand?phoneIMEI="+JSON.stringify(phoneIMEI)+"&ucustomerid="+ucustomerid,title:"手机销售-收银台",allowClose:true,width:800,height:500,
			buttons:[{text:"结账",onclick:function(i,d){
				checkStandDialog.frame.submitForm();
			}},{text:"关闭",onclick:function(i,d){
				d.hide();
			}}]
		});
	}
}