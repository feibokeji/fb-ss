/**
 * 付款方式操作JavaScript
 */
var paymentMethodDialog,paymentMethodTable;
$(function(){
	$("#paymentMethodToolBar").ligerToolBar({
		items:[
		    { text: '增加', click: addPaymentMethod, icon: 'add' },
	        { line: true },
	        { text: '修改', click: modifyPaymentMethod, icon: 'modify' },
	        { line: true },
	        { text: '删除', click: deletePaymentMethod, icon:'delete' }
		]
	});
	paymentMethodTable = window['maingrid'] = $("#maingrid").ligerGrid({
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '付款方式', name: 'cname', width: 120, minWidth: 100, align:'left' },
            { display: '代码', name: 'ccode', width: 120, minWidth: 100, align:'left' },
            { display: '描述', name: 'cdesc', width: 120, minWidth: 100, align:'left' }
            ],
		url:contextPath + "/bpr/paymentMethod/getPaymentMethodJSON",
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
function addPaymentMethod()
{
	paymentMethodDialog = $.ligerDialog.open({url:contextPath+"/bpr/paymentMethod/add",title:"新增付款方式",allowClose:true,width:540,height:320});
}
function modifyPaymentMethod()
{
	var rows = paymentMethodTable.getCheckedRows();
	if(rows != null && rows != ""){
		paymentMethodDialog = $.ligerDialog.open({url:contextPath+"/bpr/paymentMethod/modify?uid="+rows[0].uid,title:"修改付款方式",allowClose:true,width:540,height:320});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的付款方式!");
	}
}
function deletePaymentMethod()
{
	var rows = paymentMethodTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/paymentMethod/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							paymentMethodTable.loadData();
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
		$.ligerDialog.warn("请选择需要删除的付款方式!");
	}
}