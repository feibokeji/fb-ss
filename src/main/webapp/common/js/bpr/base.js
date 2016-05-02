$(function(){
	mouseMoveStyle();
	singleSelection();
});
/**
 * 列表表格鼠标悬浮后行数据样式
 */
function mouseMoveStyle(){
	$(".listTable tr:gt(0):not(:last):nth-child(2n+1)").each(function(){
		($(this).children().not($(this).children().first())).addClass("list-table-tr-even");
	});
	$(".listTable tr:gt(0):not(:last)").each(function(){
		$(this).children().first().addClass("list-table-tr-td1");
		var oldClass = $(this).children().last().attr("class");
		$(this).mousemove(function(){
			($(this).children().not($(this).children().first())).removeClass(oldClass).addClass("list-table-tr-hover");
		}).mouseout(function(){
			($(this).children().not($(this).children().first())).removeClass("list-table-tr-hover").addClass(oldClass);
		});
	});
	$(".listTableAll tr:gt(0)").each(function(){
		$(this).children().first().addClass("list-table-tr-td1");
		var oldClass = $(this).children().last().attr("class");
		$(this).mousemove(function(){
			($(this).children().not($(this).children().first())).removeClass(oldClass).addClass("list-table-tr-hover");
		}).mouseout(function(){
			($(this).children().not($(this).children().first())).removeClass("list-table-tr-hover").addClass(oldClass);
		});
	});
}
/**
 * 验证数据的唯一性
 * @param table
 * @param column
 * @param value
 * @param msg
 * @returns {String}
 */
function checkData(table,column,value,msg){
	var result = "";
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/auxiliary/checkDataRepeat",
		data:{'table':table,'column':column,'value':value},
		dataType:"html",
		success:function(data){
			if(data == 'true'){
				result = msg;
			}
		}
	});
	if(result != ""){
		return result;
	}
}
/**
 * 关闭页面
 * @param page
 */
function closePage(page){
	window.parent.closeTag(page);
}
/**
 * checkbox单选
 */
function singleSelection(){
	$(":checkbox[name=_checkbox]").each(function(){
		$(this).click(function(){
			if($(this).attr("checked")){
				$(":checkbox[name=_checkbox]").removeAttr("checked");
				$(this).attr("checked","checked");
			}
		});
	});
}