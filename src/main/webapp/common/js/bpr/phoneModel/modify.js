/**
 * 修改手机型号
 */
var brandComboBox,warrantyComboBox,phoneModelColorComboBox;
$(function(){
	$("#modifyForm").validationEngine('attach', { 
		 promptPosition: 'topRight',scroll:false
	});
	brandComboBox = $("#modifyCbrandname").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,autocomplete:true,
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
			$("#modifyUbrandid").val(value);
		}
	});
	phoneModelColorComboBox = $("#modifyPhoneModelColor").ligerComboBox({
		width:580,
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,
		valueField:'uid',textField:'cname',
		grid:{
			columns: [
	            { display:'主键', name : 'uid', align: 'left', width:100, minWidth: 60,hide: true},
	            { display: '名称', name: 'cname', width: 120,minWidth: 100 }
	        ],
	        url:contextPath + "/bpr/color/getColorJSON",
		    usePager:true,isSingleCheck:false,dataAction:"local",checkbox:true,selectRowButtonOnly:true,enabledSort:false
		},
		onSelected: function (value)
		{
			$("#modifyPhoneModelColorIds").val(value);
		}
	});
	warrantyComboBox = $("#modifyWarranty").ligerComboBox({
		selectBoxWidth: 280, selectBoxHeight: 200,slide:false,isShowCheckBox:false,autocomplete:true,
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
			$("#modifyUwarrantyid").val(value);
		}
	});
	$("#modifyCbrandname").val(oldCbrandname);
	$("#modifyWarranty").val(oldIwarrantyday);
	var uphonemodelid = $("#modifyUid").val();
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/phoneModel/getPhoneModelColorJSON",
		data:{'uphonemodelid':uphonemodelid},
		dataType:"json",
		success:function(data){
			var defaultColorUids = "";
			var defaultColorNames = "";
			for(var i = 0; i < data.Rows.length; i++)
			{
				defaultColorUids += data.Rows[i].ucolorid + ";";
				defaultColorNames += data.Rows[i].ccolorname + ";";
			}
			if(defaultColorUids.charAt(defaultColorUids.length - 1) == ";")
				defaultColorUids = defaultColorUids.substring(0,defaultColorUids.length - 1);
			if(defaultColorNames.charAt(defaultColorNames.length - 1) == ";")
				defaultColorNames = defaultColorNames.substring(0,defaultColorNames.length - 1);
			phoneModelColorComboBox.selectValue(defaultColorUids);
			phoneModelColorComboBox.setText(defaultColorNames);
			$("#modifyPhoneModelColorIds").val(defaultColorUids);
			//phoneModelColorComboBox.updateStyle();
		}
	});
});
function ajaxCname(field,rules,i,options){
	if(field.val().length > 0){
		if(field.val() != oldCname)
			return checkData('t_phone_model','cname',field.val(),'*名称重复');
	}
}
function validateCostPrice(field,rules,i,options){
	var ncostprice = parseFloat(field.val());
	var nretailprice = parseFloat($("#modifyNretailprice").val());
	if(ncostprice >= nretailprice){
		return "*进货价不能高于或等于销售价";
	}
}
function validateRetailPrice(field,rules,i,options){
	var ncostprice = parseFloat($("#modifyNcostprice").val());
	var nretailprice = parseFloat(field.val());
	if(ncostprice >= nretailprice){
		return "销售价不能低于或等于进货价";
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
	if($("#modifyForm").validationEngine("validate")){
		$.ligerDialog.confirm("确定要保存吗？",function(yes){
			if(yes){
				var waitting = $.ligerDialog.waitting('数据保存中,请稍候...');
				$("#modifyForm").ajaxSubmit(function(data){
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