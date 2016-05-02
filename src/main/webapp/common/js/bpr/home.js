/**
 * 首页javascript控制
 */
$(function(){
	//添加日历控件
	$("#uploadTime").ligerDateEditor();
	$("#uploadForm").ajaxForm().submit(function(){
		var reg = new RegExp("^.*\\.(?:xls|xlsx|XLS)$");
		var con = $("#excelFrontDeskSalesProduct");
		var obj = con.val().substring(con.val().lastIndexOf("\\") + 1);
		if(!reg.test(obj)){
			$.ligerDialog.error("您选择的文件不是正确的Excel文件!请重新选择。");
		}else{
			$.ligerDialog.confirm("确定要上传吗?",function(yes){
				if(yes){
					var waitting = $.ligerDialog.waitting('文件上传中,请稍候...');
					$("#uploadForm").ajaxSubmit(function(data){
						con.val("");
						waitting.close();
						$.ligerDialog.open({ target: data });
					});
				}
			});
		}
	});
});
