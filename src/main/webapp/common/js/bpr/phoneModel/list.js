/**
 * 手机型号信息页面JavaScript
 */
var phoneModelDialog = null;
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
            { display: '品牌', name: 'cbrandname', width: 100,minWidth: 80, align:'left' },
            { display: '型号', name: 'cname', width: 100,minWidth: 80, align:'left' },
            { display: '运行内存(RAM)', name: 'cram', width: 100,minWidth: 80, align:'left' },
            { display: '存储内存(ROM)', name: 'crom', width: 100,minWidth: 80, align:'left' },
            { display: '进货价(元)', name: 'ncostprice', width: 100,minWidth: 80, align:'left' },
            { display: '销售价(元)', name: 'nretailprice', width: 100,minWidth: 80, align:'left' },
            { display: '处理器(CPU)', name: 'ccpu', width: 120,minWidth: 100, align:'left' },
            { display: '屏幕', name: 'cscreen', width: 120,minWidth: 100, align:'left' },
            { display: '摄像头', name: 'ccamera', width: 180,minWidth: 160, align:'left' },
            { display: '电池', name: 'cbattery', width: 100,minWidth: 80, align:'left' },
            { display: '网络模式', name: 'cnetwork', width: 100,minWidth: 80, align:'left' },
            { display: '亮点描述', name: 'chighlightdesc', width: 160,minWidth: 140, align:'left' },
            { display: '保修时间(天)', name: 'iwarrantyday', width: 100,minWidth: 80, align:'left' },
            { display: '保修内容', name: 'cwarrantycontent', width: 100,minWidth: 80, align:'left' },
            { display: '记录日期', name: 'drecorddateStr', width: 140,minWidth: 120, align:'left' },
            { display: '更新日期', name: 'dupdatedateStr', width: 140,minWidth: 120, align:'left' }
            ],
        toolbar: { items: [
	            { text: '增加', click: addPhoneModel, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyPhoneModel, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deletePhoneModel, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/phoneModel/getPhoneModelJSON",
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
	    detail:{height:'auto',onShowDetail:f_showPriceRecord}
	});
	brandComboBox = $("#searchCbrandName").ligerComboBox({
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
			$("#searchUbrandId").val(value);
		}
	});
});
//手机型号价格记录
function f_showPriceRecord(row, detailPanel,callback){
	var div1 = document.createElement('div');
	$(div1).attr("tabid","tabDiv1");
	$(div1).attr("title","拥有颜色")
	var div2 = document.createElement('div');
	$(div2).attr("tabid","tabDiv2");
	$(div2).attr("title","价格记录")
	var tabDiv = document.createElement('div');
	$(tabDiv).attr("id","navtab");
	$(tabDiv).append(div1);
	$(tabDiv).append(div2);
	$(tabDiv).ligerTab();
	$(detailPanel).append(tabDiv);
	
	var grid1 = document.createElement('div');
	$(div1).append(grid1);
	$(grid1).css('margin',10).ligerGrid({
        columns:[
        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { display: '手机型号表外键', name: 'uphonemodelid', width: 100, minWidth: 80,hide:true },
            { display: '颜色表外键', name: 'ucolorid', width: 100, minWidth: 80,hide:true },
            { display: '颜色', name: 'ccolorname', width: 100,minWidth: 80, align:'left' }
        ], 
        url:contextPath + "/bpr/phoneModel/getPhoneModelColorJSON?uphonemodelid=" + row.uid,
        isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
        rownumbers:true,frozen: false,usePager:false,
        onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false,
        enabledEdit: true, clickToEdit: true
    });
	var grid2 = document.createElement('div');
	$(div2).append(grid2);
	$(grid2).css('margin',10).ligerGrid({
        columns:[
        	{ display:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { display: '进货价', name: 'ncostprice', width: 100, minWidth: 80, align:'left' },
            { display: '零售价', name: 'nretailprice', width: 100, minWidth: 80, align:'left' },
            { display: '状态', name: 'istatusStr', width: 100,minWidth: 80, align:'left' },
            { display: '用户', name: 'cusername', width: 100,minWidth: 80, align:'left' },
            { display: '记录日期', name: 'drecorddateStr', align: 'left',width: 120,minWidth: 100 }
        ], 
        url:contextPath + "/bpr/phoneModel/getPhoneModelPriceRecordJSON?uphonemodelid=" + row.uid,
        isScroll: false, showToggleColBtn: false, width: '90%',showTitle: false,
        rownumbers:true,frozen: false,usePager:false,
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
//新增手机型号
function addPhoneModel()
{
	phoneModelDialog = $.ligerDialog.open({url:contextPath+"/bpr/phoneModel/add",title:"新增手机型号",allowClose:true,width:840,height:600});
}
//修改手机型号
function modifyPhoneModel()
{
	var rows = phoneModelTable.getCheckedRows();
	if(rows != null && rows != ""){
		phoneModelDialog = $.ligerDialog.open({url:contextPath+"/bpr/phoneModel/modify?uid="+rows[0].uid,title:"修改手机型号",allowClose:true,width:840,height:600});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的手机型号!");
	}
}
//删除手机型号
function deletePhoneModel()
{
	var rows = phoneModelTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/phoneModel/deletePhoneModel",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							phoneModelTable.loadData();
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