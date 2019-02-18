/**
 * 首页javascript控制
 */
$(function(){
//	//添加日历控件
//	var _date = (new Date()).pattern("yyyy-MM-dd");
//	$("#uploadTime").ligerDateEditor({initValue:_date});
//	$("#uploadForm").ajaxForm().submit(function(){
//		var reg = new RegExp("^.*\\.(?:xls|xlsx|XLS)$");
//		var file = $("#excelFrontDeskSalesProduct");
//		var obj = file.val().substring(file.val().lastIndexOf("\\") + 1);
//		var time = $("#uploadTime");
//		if(!reg.test(obj)){
//			$.ligerDialog.error("您选择的文件不是正确的Excel文件!\n请重新选择。");
//		}else if(time.val() == null || time.val() == ""){
//			$.ligerDialog.error("请选择日期!");
//		}else{
//			$.ligerDialog.confirm("确定要上传吗?",function(yes){
//				if(yes){
//					var waitting = $.ligerDialog.waitting('文件上传中,请稍候...');
//					$("#uploadForm").ajaxSubmit(function(data){
//						waitting.close();
//						if(typeof(data.success) != undefined && data.success != null && data.success != ""){
//							$.ligerDialog.open({title:'读取成功',width:1100,height:500,target:data.success});
//							file.after(file.clone().val(""));   
//							file.remove();
//						}else if(typeof(data.fail != undefined && data.fail != null && data.fail != "")){
//							$.ligerDialog.open({title:'错误',width:400,target:data.fail});
//						}
//					});
//				}
//			});
//		}
//	});
//	$.ajax({
//		type:"post",
//		async:false,
//		url:contextPath+"/bpr/crawler/capture",
//		dataType:"html",
//		success:function(data){
//			alert(data);
//			$("#crawlerDiv").html(data);
//		}
//	});
});
