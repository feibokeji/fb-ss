/**
 * 新增商品信息JavaScript
 */
$(function(){
	$("#addForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
	$("#addCcategoryname").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/lovelysnow/listCategory",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addUcategoryid").val(value);
		}
	});
	$("#addCbrandname").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/brand/getBrandJSON",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addUbrandid").val(value);
		}
	});
	$("#addCunitname").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/unit/getUnitJSON",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addUunitid").val(value);
		}
	});
	$("#addWarranty").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,
		valueField:'uid',textField:'iday',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '保修天数', name: 'iday', width: 120,minWidth: 100 },
	            { display: '保修内容', name: 'ccontent', width: 120,minWidth: 100 },
	        ],
	        url:contextPath + "/bpr/warranty/getWarrantyJSON",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:false,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addUwarrantyid").val(value);
		}
	});
});
function ajaxCno(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_other_goods','cno',field.val(),'*编号重复');
	}
}
function ajaxCbarcode(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_other_goods','cbarcode',field.val(),'*条形码重复');
	}
}
function ajaxCname(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_other_goods','cname',field.val(),'*名称重复');
	}
}
function ajaxCfullname(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_other_goods','cfullname',field.val(),'*全称重复');
	}
}
function validateCostPrice(field,rules,i,options){
	var ncostprice = parseFloat(field.val());
	var nretailprice = parseFloat($("#addNretailprice").val());
	if(ncostprice >= nretailprice){
		return "*进货价不能高于或等于销售价";
	}
}
function validateRetailPrice(field,rules,i,options){
	var ncostprice = parseFloat($("#addNcostprice").val());
	var nretailprice = parseFloat(field.val());
	if(ncostprice >= nretailprice){
		return "*销售价不能低于或等于进货价";
	}
}
function closeDialog()
{
	$.ligerDialog.confirm("您确定要关闭比窗口吗?",function(yes){
		if(yes){
			frameElement.dialog.close();
		}
	});
}
function submitForm()
{
	if($("#addForm").validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				$("#addForm").ajaxSubmit(function(data){
					waitting.close();
					if(data == "fail")
						$.ligerDialog.error("保存失败!");
					else{
						$.ligerDialog.success("保存成功!");
						window.parent.otherGoodsTable.loadData();
					}
				});
			}
		})
	}
}