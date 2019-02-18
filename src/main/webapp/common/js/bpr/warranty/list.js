/**
 * 保修政策操作JavaScript
 */
var warrantyDialog,warrantyTable;
$(function(){
	warrantyTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '保修天数', name: 'iday', width: 120, minWidth: 100 },
            { display: '保修内容', name: 'ccontent', align:'left', width: 300, minWidth: 280 }
            ],
        toolbar: { items: [
	            { text: '增加', click: addWarranty, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyWarranty, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteWarranty, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/warranty/getWarrantyJSON",
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
function addWarranty()
{
	warrantyDialog = $.ligerDialog.open({url:contextPath+"/bpr/warranty/add",title:"新增保修政策",allowClose:true,width:640,height:500});
}
function modifyWarranty()
{
	var rows = warrantyTable.getCheckedRows();
	if(rows != null && rows != ""){
		warrantyDialog = $.ligerDialog.open({url:contextPath+"/bpr/warranty/modify?uid="+rows[0].uid,title:"修改保修政策",allowClose:true,width:640,height:500});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的保修政策!");
	}
}
function deleteWarranty()
{
	var rows = warrantyTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/warranty/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							warrantyTable.loadData();
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
		$.ligerDialog.warn("请选择需要删除的保修政策!");
	}
}