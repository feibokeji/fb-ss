/**
 * 单位信息操作JavaScript
 */
var unitDialog,unitTable;
$(function(){
	unitTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '单位名称', name: 'cname', width: 120, minWidth: 100, align:'left' }
            ],
        toolbar: { items: [
	            { text: '增加', click: addUnit, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyUnit, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteUnit, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/unit/getUnitJSON",
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
function addUnit()
{
	unitDialog = $.ligerDialog.open({url:contextPath+"/bpr/unit/add",title:"新增单位",allowClose:true,width:640,height:500});
}
function modifyUnit()
{
	var rows = unitTable.getCheckedRows();
	if(rows != null && rows != ""){
		unitDialog = $.ligerDialog.open({url:contextPath+"/bpr/unit/modify?uid="+rows[0].uid,title:"修改单位",allowClose:true,width:640,height:500});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的单位信息!");
	}
}
function deleteUnit()
{
	var rows = unitTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/unit/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							unitTable.loadData();
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
		$.ligerDialog.warn("请选择需要删除的单位信息!");
	}
}