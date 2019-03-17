/**
 * 查看单据明细
 */
var returnGoodsDialog = null;
//退货
function returnGoods(){
	returnGoodsDialog = $.ligerDialog.open({url:contextPath+'/bpr/customerOrder/returnGoods?uorderid='+uorderid,title:"客户商品"+cno+"单据退货",allowClose:true,width:800,height:500,
		buttons:[{text:"退货",onclick:function(i,d){
			returnGoodsDialog.frame.submitForm();
		}},{text:"关闭",onclick:function(i,d){
			d.hide();
		}}]
	});
}
//关闭
function closeViewPage(){
	top.tab.removeTabItem("customerOrderView"+cno);
}