/**
 * 其它商品信息页面JavaScript
 */
var otherGoodsDialog = null;
var otherGoodsTable = null;
var categoryComboBox,brandComboBox;
var searchUcategoryId,searchUbrandId,searchCno,searchCbarcode,searchCname,searchCmnemoniccode,searchDrecorddateStrMin,searchDrecorddateStrMax;
/**
 * 加载函数
 * @returns
 */
$(function(){
	$("#searchDrecorddateStrMin,#searchDrecorddateStrMax").ligerDateEditor();
	otherGoodsTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '类别', name: 'ccategoryname', width: 100, minWidth: 80 },
            { display: '品牌', name: 'cbrandname', width: 100,minWidth: 80 },
            { display: '编号', name: 'cno', width: 120,minWidth: 100 },
            { display: '条形码', name: 'cbarcode', width: 120,minWidth: 100 },
            { display: '名称', name: 'cname', width: 120,minWidth: 100 },
            { display: '全称', name: 'cfullname', width: 160,minWidth: 140 },
            { display: '助记码', name: 'cmnemoniccode', width: 100,minWidth: 80 },
            { display: '规格', name: 'cspecifications', width: 180,minWidth: 160 },
            { display: '单位', name: 'cunitname', width: 100,minWidth: 80 },
            { display: '进货价(元)', name: 'ncostprice', width: 100,minWidth: 80 },
            { display: '销售价(元)', name: 'nretailprice', width: 100,minWidth: 80 },
            { display: '保修时间(天)', name: 'iwarrantyday', width: 100,minWidth: 80 },
            { display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80 },
            { display: '积分', name: 'iintegral', width: 80,minWidth: 60 },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120 }
            ],
        toolbar: { items: [
	            { text: '增加', click: addOtherGoods, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyOtherGoods, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteOtherGoods, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/otherGoods/getOtherGoodsJSON",
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
	    detail:{onShowDetail:f_showPriceRecord,height:'auto'}
	});
	categoryComboBox = $("#searchCcategoryName").ligerComboBox({
		selectBoxWidth: 300, selectBoxHeight: 240,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/lovelysnow/listCategory",
		    rownumbers:true,usePager:false,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#searchUcategoryId").val(value);
		}
	});
	brandComboBox = $("#searchCbrandName").ligerComboBox({
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
			$("#searchUbrandId").val(value);
		}
	});
});
//商品价格记录
function f_showPriceRecord(row, detailPanel,callback){
	var grid = document.createElement('div');
	$(detailPanel).append(grid);
	$(grid).css('margin',10).ligerGrid({
        columns:[
        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { display: '进货价', name: 'ncostprice', width: 100, minWidth: 80 },
            { display: '零售价', name: 'nretailprice', width: 100, minWidth: 80 },
            { display: '状态', name: 'istatusStr', width: 100,minWidth: 80 },
            { display: '用户', name: 'cusername', width: 100,minWidth: 80 },
            { display: '记录日期', name: 'drecorddateStr', align: 'left',width: 120,minWidth: 100 }
        ], 
        url:contextPath + "/bpr/otherGoods/getOtherGoodsPriceRecordJSON?uothergoodsid=" + row.uid,
        isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
        pageSize:10 ,rownumbers:true,pageSizeOptions:[10],frozen: false,
        onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
        enabledEdit: true, clickToEdit: true
    });
}
//查询商品信息
function searchOtherGoods()
{
	searchCno = $("#searchCno").val();
	searchCbarcode = $("#searchCbarcode").val();
	searchCname = $("#searchCname").val();
	searchCmnemoniccode = $("#searchCmnemoniccode").val();
	searchDrecorddateStrMin = $("#searchDrecorddateStrMin").val();
	searchDrecorddateStrMax = $("#searchDrecorddateStrMax").val();
	
	otherGoodsTable.setParm("ucategoryid",categoryComboBox.getValue());
	otherGoodsTable.setParm("ubrandid",brandComboBox.getValue());
	otherGoodsTable.setParm("cno",searchCno);
	otherGoodsTable.setParm("cbarcode",searchCbarcode);
	otherGoodsTable.setParm("cname",searchCname);
	otherGoodsTable.setParm("cmnemoniccode",searchCmnemoniccode);
	otherGoodsTable.setParm("drecorddateStrMin",searchDrecorddateStrMin);
	otherGoodsTable.setParm("drecorddateStrMax",searchDrecorddateStrMax);
	otherGoodsTable.loadData();
}
//新增其它商品
function addOtherGoods()
{
	otherGoodsDialog = $.ligerDialog.open({url:contextPath+"/bpr/otherGoods/add",title:"新增商品信息",allowClose:true,width:840,height:600});
}
//修改其它商品
function modifyOtherGoods()
{
	var rows = otherGoodsTable.getCheckedRows();
	if(rows != null && rows != ""){
		otherGoodsDialog = $.ligerDialog.open({url:contextPath+"/bpr/otherGoods/modify?uid="+rows[0].uid,title:"修改商品信息",allowClose:true,width:840,height:600});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的商品信息!");
	}
}
//删除其它商品
function deleteOtherGoods()
{
	var rows = otherGoodsTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/otherGoods/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							otherGoodsTable.loadData();
							$.ligerDialog.success("数据删除成功!");
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}
	else
	{
		$.ligerDialog.warn("请选择需要删除的商品信息!");
	}
}