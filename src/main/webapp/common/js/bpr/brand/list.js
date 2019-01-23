/**
 * 品牌信息操作JavaScript
 */
var brandDialog,brandTable;
var searchCname;
$(function(){
	$("#searchTable").validationEngine('attach', { 
		 promptPosition: 'bottomRight',scroll:false
	});
	brandTable = window['maingrid'] = $("#maingrid").ligerGrid({
		height:'100%',
        columns: [
            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
            { display: '品牌名称', name: 'cname', width: 120, minWidth: 100 },
            { display: '官方网站', name: 'curl', width: 120,minWidth: 100 },
            { display: '描述', name: 'cdesc', width: 120,minWidth: 100 }
            ],
        toolbar: { items: [
	            { text: '增加', click: addBrand, icon: 'add' },
	            { line: true },
	            { text: '修改', click: modifyBrand, icon: 'modify' },
	            { line: true },
	            { text: '删除', click: deleteBrand, icon:'delete' }
            ]
        },
		url:contextPath + "/bpr/brand/getBrandJSON",
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
function searchBrand()
{
	if($("#searchTable").validationEngine("validate")){
		searchCname = $("#searchCname").val();
		brandTable.setParm("cname",searchCname);
		brandTable.loadData();
	}
}
function addBrand()
{
	brandDialog = $.ligerDialog.open({url:contextPath+"/bpr/brand/add",title:"新增品牌",allowClose:true,width:640,height:500});
}
function modifyBrand()
{
	var rows = brandTable.getCheckedRows();
	if(rows != null && rows != ""){
		brandDialog = $.ligerDialog.open({url:contextPath+"/bpr/brand/modify?uid="+rows[0].uid,title:"修改品牌",allowClose:true,width:640,height:500});
	}
	else
	{
		$.ligerDialog.warn("请选择需要修改的品牌信息!");
	}
}
function deleteBrand()
{
	var rows = brandTable.getCheckedRows();
	if(rows != null && rows != ""){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/brand/delete",
					data:{'uid':rows[0].uid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							brandTable.loadData();
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
		$.ligerDialog.warn("请选择需要删除的同行信息!");
	}
}