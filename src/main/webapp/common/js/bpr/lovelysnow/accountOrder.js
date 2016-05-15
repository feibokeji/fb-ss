/**
 * 可爱雪-财务单据
 */
var orderTableTr = null;
var orderData = null;
var combobox = null;
var comboboxData = null;
var dialog = null;
$(function(){
	f_getOrderData();
	f_getComboboxData();
	orderTableTr = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { dispaly:'主键', name : 'uid', align: 'left', width:60, minWidth: 60,hide: true},
            { display: '编码', name: 'ccode', align: 'left', width: 120, minWidth: 60 },
            { display: '名称', name: 'cname', align: 'left', width: 280, minWidth: 120 },
            { display: '类别', name: 'ctype', width: 80,minWidth: 60 },
            { display: '类型', name: 'caccounttypename', width: 80,minWidth: 60 },
            { display: '用户', name: 'cusername',align: 'right', width: 80,minWidth: 60 },
            { display: '备注', name: 'cmemo', align: 'right',width: 300,minWidth: 120 },
            { display: '时间', name: 'dcreatetime', align: 'right',width: 100,minWidth: 60 },
            { display: '审核', name: 'iaudit', align: 'right',width: 60,minWidth: 60 }
            ],
        toolbar: { items: [
            { text: '高级自定义查询', click: itemclick, icon: 'search2'},
            { line: true },
            { text: '新增', click: f_add, icon: 'add'},
            { line: true },
            { text: '删除', click: itemclick, img: contextPath + '/common/liger/images/skins/icons/delete.gif'},
            { line: true },
            { text: '审核', click: itemclick, icon: 'ok'}
        ]},
        data: $.extend(true,{},orderData),
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
	    		this.unselect(rowid);
	    	}
	    }
	});
	$("#orderDate").text((new Date()).pattern("yyyy年MM月dd日"));
	combobox = $("#combobox").ligerComboBox({
		data:comboboxData,
		addRowButton: '新增',
		addRowButtonClick: function (){
			combobox.clear();
            dialog = $.ligerDialog.open({
                height: 300,
                width: 400,
                title: '新增' + ctype + "类型",
                target: $("#addAccountTypeDiv"),
                showMax: false,
                showToggle: true,
                showMin: false,
                isResize: true,
                slide: false
            });
		},
		onSelected: function (value){$("#uaccounttypeid").val(value);}
	});
});
function f_getOrderData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountOrder",
		data:{'ctype':ctype},
		dataType:"json",
		success:function(data){
			orderData = data;
		}
	});
}
function f_getComboboxData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountTypeJSONArray",
		data:{'ctype':ctype},
		dataType:"json",
		success:function(data){
			comboboxData = data;
		}
	});
}
function itemclick(){
	orderTableTr.options.data = $.extend(true,{}, orderData);
	orderTableTr.showFilter();
}
function f_add(){
	_ligerDialog = $.ligerDialog.open({ target: $("#addDiv"),title:"新增"+ctype+"单据",width:680,height:290,
		buttons:[{text:"保存",onclick:function(i,d){submitForm($("#addForm"));}},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}

