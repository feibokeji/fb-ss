/**
 * 供应商商品单据查看页面
 */
//修改供应商单据
function modifySupplierOrder(){
	if(parseInt(istatus) == 1){
		$.ligerDialog.confirm("确定要修改吗？",function(yes){
			if(yes){
				window.parent.openPage('supplierOrderModify'+cno,"修改"+cno+"单据",contextPath+'/bpr/supplierOrder/modify?uorderid='+uorderid);
				top.tab.removeTabItem("supplierOrderView"+cno);
			}
		});
	}else{
		$.ligerDialog.warn("此单据已审核不能修改！");
	}
}
//审核供应商单据
function auditSupplierOrder(){
	if(parseInt(istatus) == 1){
		$.ligerDialog.confirm("确定要审核吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据审核中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/supplierOrder/audit",
					data:{'uid':uorderid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据审核失败!");
						else if(data == "success"){
							$.ligerDialog.success("数据审核成功!");
							top.tab.reload("supplierOrderList");
							window.location.href = window.location.href;
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("此单据已审核！");
	}
}
//反审核供应商单据
function reverseAuditSupplierOrder(){
	if(parseInt(istatus) == 0){
		$.ligerDialog.confirm("确定要反审核吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据反审核中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/supplierOrder/unAudit",
					data:{'uid':uorderid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据反审核失败!");
						else if(data == "success"){
							$.ligerDialog.success("数据反审核成功!");
							top.tab.reload("supplierOrderList");
							window.location.href = window.location.href;
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("此单据未审核！");
	}
}
//删除供应商单据
function deleteSupplierOrder(){
	if(parseInt(istatus) == 1){
		$.ligerDialog.confirm("确定要删除吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据删除中,请稍候...');
				$.ajax({
					type:"post",
					async:false,
					cache:false,
					url:contextPath+"/bpr/supplierOrder/delete",
					data:{'uid':uorderid},
					dataType:"html",
					success:function(data){
						waitting.close();
						if(data == "fail")
							$.ligerDialog.error("数据删除失败!");
						else if(data == "success"){
							$.ligerDialog.success("数据删除成功!");
							top.tab.reload("supplierOrderList");
							top.tab.removeTabItem("supplierOrderView"+cno);
						}else{
							$.ligerDialog.error(data);
						}
					}
				});
			}
		});
	}else{
		$.ligerDialog.warn("此单据已审核！不能删除。");
	}
}
//关闭
function closeViewPage(){
	top.tab.removeTabItem("supplierOrderView"+cno);
}