/**
 * 可爱雪-物料类管理
 */
var _materialTableTr = null;
var InventoryData = null;
$(function(){
	f_getInventoryData();
	_materialTableTr = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { dispaly:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '编码', name: 'cno', align: 'left', width: 100, minWidth: 60 },
            { display: '名称', name: 'cname', width: 200,minWidth: 120 },
            { display: '规格', name: 'cspecifications', width: 200,minWidth: 120 },
            { display: '价格', name: 'nprice',align: 'right', width: 100,minWidth: 60 },
            { display: '采购数量', name: 'nqty', align: 'right',width: 100,minWidth: 60 },
            { display: '销售数量', name: 'nsqty', align: 'right',width: 100,minWidth: 60 },
            { display: '实盘数量', name: 'nreal', align: 'right',width: 100,minWidth: 60 },
            { display: '盘点差异', name: 'ndiff', align: 'right',width: 100,minWidth: 60 },
            { display: '库存数量', name: 'inventory', align: 'right',width: 100,minWidth: 60 }
            ],
        toolbar: { items: [{ text: '高级自定义查询', click: itemclick, icon: 'search2'}]},
        data: $.extend(true,{},InventoryData),
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],
	    onReload:false,dataAction:"local"
	});
});
function f_getInventoryData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/listMaterialInventory",
		dataType:"json",
		success:function(data){
			InventoryData = data;
		}
	});
}
function itemclick(){
	_materialTableTr.options.data = $.extend(true,{}, InventoryData);
	_materialTableTr.showFilter();
}

