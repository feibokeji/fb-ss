/**
 * 商品销售 
 */
var customerTable = null,goodsTable = null,checkStandDialog = null;
$(function(){
	$("#goodsSellMainLayout").ligerLayout({rightWidth: 300});
	goodsTable = window['goodsMaingrid'] = $("#goodsMaingrid").ligerGrid({
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '类别', name: 'ccategoryname', width: 80, minWidth: 60, align:'left' },
            { display: '品牌', name: 'cbrandname', width: 80,minWidth: 60, align:'left' },
            { display: '条形码', name: 'cbarcode', width: 120,minWidth: 100, align:'left' },
            { display: '名称', name: 'cname', width: 120,minWidth: 100, align:'left' },
            { display: '全称', name: 'cfullname', width: 160,minWidth: 140, align:'left' },
            { display: '助记码', name: 'cmnemoniccode', width: 80,minWidth: 60, align:'left' },
            { display: '规格', name: 'cspecifications', width: 180,minWidth: 160, align:'left' },
            { display: '单位', name: 'cunitname', width: 60,minWidth: 60, align:'left' },
            { display: '销售价(元)', name: 'nretailprice', width: 60,minWidth: 60, align:'left' },
            { display: '库存量', name: 'inventoryQuantity', width: 60,minWidth: 60, align:'left' },
            { display: '保修时间(天)', name: 'iwarrantyday', width: 80,minWidth: 60, align:'left' },
            { display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80, align:'left' },
            { display: '积分', name: 'iintegral', width: 60,minWidth: 60, align:'left' }
            ],
		url:contextPath + "/bpr/otherGoods/getOtherGoodsInventoryJSON",
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],frozen: false,fixedCellHeight:false,
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false
	});
	//客户信息列表
	customerTable = window['customerMaingrid'] = $("#customerMaingrid").ligerGrid({
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
//搜索商品
function searchGoods(){
	var searchGoodsName = $("#searchGoodsNameInput").val();
	var searchGoodsMnemoniccode = $("#searchGoodsMnemoniccodeInput").val();
	var searchGoodsBarcode = $("#searchGoodsBarcodeInput").val();
	goodsTable.setParm("cname",searchGoodsName);
	goodsTable.setParm("cmnemoniccode",searchGoodsMnemoniccode);
	goodsTable.setParm("cbarcode",searchGoodsBarcode);
	goodsTable.loadData();
}
//搜索客户
function searchCustomer(){
	var searchCustomerName = $("#searchCustomerNameInput").val();
	var searchCustomerContactnumber = $("#searchCustomerContactnumberInput").val();
	customerTable.setParm("cname",searchCustomerName);
	customerTable.setParm("ccontactnumber",searchCustomerContactnumber);
	customerTable.loadData();
}
//结账
function settleAccounts(){
	var goodsSelectedRows = goodsTable.getSelectedRows();
	var customerSelectedRow = customerTable.getSelectedRow();
	//console.log(goodsSelectedRows);
	//console.log(customerSelectedRow);
	if(goodsSelectedRows == null || goodsSelectedRows.length == 0){
		$.ligerDialog.warn("请选择需要销售的商品信息!");
	}
	if(customerSelectedRow == null){
		$.ligerDialog.warn("请选择购买商品的客户信息!");
	}
	if(goodsSelectedRows != null && goodsSelectedRows.length > 0 && customerSelectedRow != null){
		//进行结账操作
		var goodsId = new Array();
		for(var i = 0; i < goodsSelectedRows.length; i++){
			goodsId.push(goodsSelectedRows[i].uid);
		}
		//console.log(goodsId);
		var ucustomerid = customerSelectedRow.uid;
		checkStandDialog = $.ligerDialog.open({url:contextPath+"/bpr/customerOrder/checkStand?goodsId="+JSON.stringify(goodsId)+"&ucustomerid="+ucustomerid,title:"商品销售-收银台",allowClose:true,width:800,height:500,
			buttons:[{text:"结账",onclick:function(i,d){
				checkStandDialog.frame.submitForm();
			}},{text:"关闭",onclick:function(i,d){
				d.hide();
			}}]
		});
	}
}