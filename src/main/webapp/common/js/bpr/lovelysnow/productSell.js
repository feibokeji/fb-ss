/**
 * 可爱雪-销售单据
 */
var actionNodeID = null;
var uid = null;
//左侧树形数据
var menu = $.ligerMenu({
	top: 100,
	left: 100, 
	width: 120, 
	items:[{text:'查看',click:f_View,icon:'view'}]
});
$(function(){
	//页面布局
	$("#layout1").ligerLayout({ leftWidth: 240});
	//开始日期
	$("#beganTime").ligerDateEditor();
	//结束日期
	$("#endTime").ligerDateEditor();
	var tree = $("#tree1").ligerTree({
    	url:contextPath+"/bpr/lovelysnow/getOrderProductGroup",
    	nodeWidth:180,
        idFieldName :'id',
        slide : false,
        parentIDFieldName :'pid',
        checkbox: false,
        onContextmenu: function (node, e){
        	actionNodeID = node.data.id;
        	if(node.data.pid != '0'){
        		menu.show({ top: e.pageY, left: e.pageX });
        	}
            return false;
        }
    });
    manager = $("#tree1").ligerGetTreeManager();
    f_show_img();
    uid = $("#uid").val();
});

/**
 * 显示审核/未审核图标
 */
function f_show_img(){
	var cstatus = $("#cstatus").val();
	var img_url = "";
	if(cstatus == "00"){
		img_url = contextPath+"/common/images/not_audit.png";
	}else if(cstatus == "01"){
		img_url = contextPath+"/common/images/audit.png";
	}
	$("#seal").attr("src",img_url).show();
}

/**
 * 查看
 * @param item
 * @param i
 */
function f_View(item,i){
	window.location.href = contextPath + "/bpr/lovelysnow/productSell?uid="+actionNodeID;
}
/**
 * 删除订单
 */
function f_Delete(){
	$.ligerDialog.confirm("确定要删除吗？",function(yes){
		if(yes){
			if(_delete(uid)){
				$.ligerDialog.success("删除成功!");
				window.location.href = contextPath + "/bpr/lovelysnow/productSell";
			}
			else
				$.ligerDialog.error("删除失败!");
		}
	});
}
/**
 * 删除方法
 * @param uid
 * @param cstatus
 * @returns {Boolean}
 */
function _delete(uid){
	var result = false;
	var waitting;
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/deleteOrder",
		data:{'uid':uid},
		dataType:"html",
		beforeSend:function(){
			waitting = $.ligerDialog.waitting('删除数据中,请稍候...');
		},
		success:function(data){
			waitting.close();
			result = data;
		}
	});
	return result;
}
/**
 * 审核订单
 * @param item
 * @param i
 */
function f_Audit(item,i){
	$.ligerDialog.confirm("确定要审核吗？",function(yes){
		if(yes){
			if(audit(uid,'01')){
				$.ligerDialog.success("审核成功!");
				window.location.href = window.location.href;
			}
			else
				$.ligerDialog.error("审核失败!");
		}
	});
}
/**
 * 反审核
 * @param item
 * @param i
 */
function f_n_Audit(item,i){
	$.ligerDialog.confirm("确定要反审核吗？",function(yes){
		if(yes){
			if(audit(uid,'00')){
				$.ligerDialog.success("反审核成功!");
				window.location.href = window.location.href;
			}
			else
				$.ligerDialog.error("反审核失败!");
		}
	});
}
/**
 * 审核方法
 * @param uid
 * @param cstatus
 * @returns {Boolean}
 */
function audit(uid,cstatus){
	var result = false;
	var waitting;
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/auditOrder",
		data:{'uid':uid,'cstatus':cstatus},
		dataType:"html",
		beforeSend:function(){
			waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
		},
		success:function(data){
			waitting.close();
			result = data;
		}
	});
	return result;
}
