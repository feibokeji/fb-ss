/**
 * 新增手机型号JavaScript
 */
$(function(){
	$("#addForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
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
	$("#addPhoneModelColor").ligerComboBox({
		width:580,
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,isMultiSelect:true,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/color/getColorJSON",
		    rownumbers:true,usePager:true,isSingleCheck:true,
		    onReload:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#addPhoneModelColorIds").val(value);
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
function ajaxCname(field,rules,i,options){
	if(field.val().length > 0){
		return checkData('t_phone_model','cname',field.val(),'*名称重复');
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
						window.parent.phoneModelTable.loadData();
					}
				});
			}
		})
	}
}