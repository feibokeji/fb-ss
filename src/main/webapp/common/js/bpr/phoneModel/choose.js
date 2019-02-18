/**
 * 手机型号信息页面JavaScript
 */
var phoneModelTable = null;
var brandComboBox;
var searchUbrandId,searchCname,searchCram,searchCrom,searchCcpu,searchCscreen,searchCcamera,searchCbattery,searchCnetwork;
/**
 * 加载函数
 * @returns
 */
$(function(){
	phoneModelTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '品牌', name: 'cbrandname', width: 100,minWidth: 80 },
            { display: '型号', name: 'cname', width: 100,minWidth: 80 },
            { display: '运行内存(RAM)', name: 'cram', width: 100,minWidth: 80 },
            { display: '存储内存(ROM)', name: 'crom', width: 100,minWidth: 80 },
            { display: '进货价(元)', name: 'ncostprice', width: 100,minWidth: 80 },
            { display: '销售价(元)', name: 'nretailprice', width: 100,minWidth: 80 },
            { display: '处理器(CPU)', name: 'ccpu', width: 120,minWidth: 100 },
            { display: '屏幕', name: 'cscreen', width: 120,minWidth: 100 },
            { display: '摄像头', name: 'ccamera', width: 180,minWidth: 160 },
            { display: '电池', name: 'cbattery', width: 100,minWidth: 80 },
            { display: '网络模式', name: 'cnetwork', width: 100,minWidth: 80 },
            { display: '亮点描述', name: 'chighlightdesc', width: 160,minWidth: 140 },
            { display: '保修时间(天)', name: 'iwarrantyday', width: 100,minWidth: 80 },
            { display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80 },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120 },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120 }
            ],
		url:contextPath + "/bpr/phoneModel/getPhoneModelJSON",
	    pageSize:30 ,rownumbers:true,pageSizeOptions:[10,20,30],frozen: false,fixedCellHeight:false,
	    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false,
	    detail:{height:'auto',onShowDetail:f_showPriceRecord}
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
//手机型号价格记录
function f_showPriceRecord(row, detailPanel,callback){
	var grid1 = document.createElement('div');
	$(detailPanel).append(grid1);
	$(grid1).css('margin',10).ligerGrid({
        columns:[
        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { display: '手机型号表外键', name: 'uphonemodelid', width: 100, minWidth: 80,hide:true },
            { display: '颜色表外键', name: 'ucolorid', width: 100, minWidth: 80,hide:true },
            { display: '颜色', name: 'ccolorname', width: 100,minWidth: 80 }
        ], 
        url:contextPath + "/bpr/phoneModel/getPhoneModelColorJSON?uphonemodelid=" + row.uid,
        isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
        pageSize:10 ,rownumbers:true,pageSizeOptions:[10],frozen: false,
        onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
        enabledEdit: true, clickToEdit: true
    });
	var grid2 = document.createElement('div');
	$(detailPanel).append(grid2);
	$(grid2).css('margin',10).ligerGrid({
        columns:[
        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { display: '进货价', name: 'ncostprice', width: 100, minWidth: 80 },
            { display: '零售价', name: 'nretailprice', width: 100, minWidth: 80 },
            { display: '状态', name: 'istatusStr', width: 100,minWidth: 80 },
            { display: '用户', name: 'cusername', width: 100,minWidth: 80 },
            { display: '记录日期', name: 'drecorddateStr', align: 'left',width: 120,minWidth: 100 }
        ], 
        url:contextPath + "/bpr/phoneModel/getPhoneModelPriceRecordJSON?uphonemodelid=" + row.uid,
        isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
        pageSize:10 ,rownumbers:true,pageSizeOptions:[10],frozen: false,
        onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
        enabledEdit: true, clickToEdit: true
    });
}
//查询手机型号信息
function searchPhoneModel()
{
	searchUbrandId = $("#searchUbrandId").val();
	searchCname = $("#searchCname").val();
	searchCram = $("#searchCram").val();
	searchCrom = $("#searchCrom").val();
	searchCcpu = $("#searchCcpu").val();
	searchCscreen = $("#searchCscreen").val();
	searchCcamera = $("#searchCcamera").val();
	searchCbattery = $("#searchCbattery").val();
	searchCnetwork = $("#searchCnetwork").val();
	phoneModelTable.setParm("ubrandid",brandComboBox.getValue());
	phoneModelTable.setParm("cname",searchCname);
	phoneModelTable.setParm("cram",searchCram);
	phoneModelTable.setParm("crom",searchCrom);
	phoneModelTable.setParm("ccpu",searchCcpu);
	phoneModelTable.setParm("cscreen",searchCscreen);
	phoneModelTable.setParm("ccamera",searchCcamera);
	phoneModelTable.setParm("cbattery",searchCbattery);
	phoneModelTable.setParm("cnetwork",searchCnetwork);
	phoneModelTable.loadData();
}