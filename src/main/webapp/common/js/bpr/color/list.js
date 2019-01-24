/**
 * 颜色信息操作JavaScript
 */
var colorDialog,colorTable;
$(function(){
	colorTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '颜色', name: 'cname', width: 120, minWidth: 100 }
            ],
        toolbar: { items: [
	            { text: '增加', click: addColor, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyColor, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteColor, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/color/getColorJSON",
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
function addColor()
{
	colorDialog = $.ligerDialog.open({url:contextPath+"/bpr/color/add",title:"新增颜色",allowClose:true,width:640,height:500});
}
function modifyColor()
{
	var rows = colorTable.getCheckedRows();
	if(rows != null && rows != ""){
		colorDialog = $.ligerDialog.open({url:contextPath+"/bpr/color/modify?uid="+rows[0].uid,title:"修改颜色",allowClose:true,width:640,height:500});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的颜色信息!");
	}
}
function deleteColor()
{
	var rows = colorTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/color/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							colorTable.loadData();
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
		$.ligerDialog.warn("请选择需要删除的颜色信息!");
	}
}