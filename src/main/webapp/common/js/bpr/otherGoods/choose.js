/**
 * 商品选择窗口控制JavaScript
 * @author liubo
 */
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
		url:contextPath + "/bpr/otherGoods/getOtherGoodsJSON",
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],frozen: false,fixedCellHeight:false,
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false
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