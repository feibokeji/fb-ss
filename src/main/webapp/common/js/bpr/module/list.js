/**
 * 功能模块管理--列表页面
 */
$(function(){
	
});
/**
 * 新增功能模块
 */
function addModule(){
	var _parent = $(":checkbox[name=_checkbox]:checked");
	var _parent_id = _parent.attr("id");
	var _parent_val = _parent.val();
	var url = contextPath + "/bpr/module/add?uid=" + _parent_id;
	var _title = "";
	if(_parent_val != null && _parent_val != '')
		_title = "[" + _parent_val + "]添加子功能模块";
	else
		_title = "新增一级功能模块";
	$.ligerDialog.open({height:300,width:700,title:_title,url:url});
}
/**
 * 删除功能模块
 * @param uid
 */
function deleteModule(uid){
	$.ligerDialog.confirm('您确定要删除此功能模块吗?',function(yes){
		if(yes){
			$.ajax({
				type:"post",
				async:false,
				cache:false,
				url:contextPath+"/bpr/module/delete",
				data:{'uid':uid},
				dataType:"json",
				success:function(data){
					var _msg = "共删除" + data + "条记录!";
					$.ligerDialog.tip({title:"提示信息",content:_msg});
					setTimeout(function(){$("#moduleListForm").submit();}, 1000)
				}
			});
		}
	});
}
/**
 * 编辑功能模块
 * @param uid
 */
function editModule(uid){
	$.ligerDialog.open({height:300,width:700,title:"编辑",url:contextPath + "/bpr/module/edit?uid=" + uid});
}
