$(function() {
});
/**
 * 编辑公司信息
 * 
 * @param uid
 */
function editCorp(uid) {
	var url = contextPath + "/corp/edit?uid=" + uid;
	$.ligerDialog.open({height:550,width:700,title:'公司信息编辑',url:url});
}
/**
 * 删除公司信息
 * 
 * @param uid
 */
function deleteCorp(uid) {
	$.ligerDialog.confirm('您确定要删除此公司信息吗？', function (yes){
		if(yes){
			$.ajax({
				type:"post",
				async:false,
				url:contextPath+"/corp/delete",
				data:{'uid':uid},
				dataType:"json",
				success:function(data){
					if(data){
						$.ligerDialog.success("删除成功!");
						$("#searchCorpForm").submit();
					}else{
						$.ligerDialog.error("请检查此公司下是否存在部门,不能删除!");
					}
				}
			});
		}
	});
}