/**
 * 商品销售 
 */
var customerTable = null,goodsTable = null;
$(function(){
	$("#layout1").ligerLayout({
        rightWidth: 300
    });
	goodsTable = window['goodsMaingrid'] = $("#goodsMaingrid").ligerGrid({
		height:'97%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '类别', name: 'ccategoryname', width: 80, minWidth: 60 },
            { display: '品牌', name: 'cbrandname', width: 80,minWidth: 60 },
            { display: '条形码', name: 'cbarcode', width: 120,minWidth: 100 },
            { display: '名称', name: 'cname', width: 120,minWidth: 100 },
            { display: '全称', name: 'cfullname', width: 160,minWidth: 140 },
            { display: '助记码', name: 'cmnemoniccode', width: 80,minWidth: 60 },
            { display: '规格', name: 'cspecifications', width: 180,minWidth: 160 },
            { display: '单位', name: 'cunitname', width: 60,minWidth: 60 },
            { display: '销售价(元)', name: 'nretailprice', width: 60,minWidth: 60 },
            { display: '库存量', name: 'inventoryQuantity', width: 60,minWidth: 60 },
            { display: '保修时间(天)', name: 'iwarrantyday', width: 100,minWidth: 80 },
            { display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80 },
            { display: '积分', name: 'iintegral', width: 60,minWidth: 60 }
            ],
		url:contextPath + "/bpr/otherGoods/getOtherGoodsInventoryJSON",
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
	//客户信息列表
	customerTable = window['customerMaingrid'] = $("#customerMaingrid").ligerGrid({
		columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '客户名称', name: 'cname', width: 120,minWidth: 100},
            { display: '联系电话', name: 'ccontactnumber', width: 120,minWidth: 100}
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