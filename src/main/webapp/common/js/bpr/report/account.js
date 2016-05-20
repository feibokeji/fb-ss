/**
 * 账务报表
 */
var ctype = null;

var comboboxAccount = null;
var comboboxAccountData = null;

var comboboxAccountType = null;
var comboboxAccountTypeData = null;

$(function(){
	$("#searchForm").validationEngine();
	var search_ctype = $("#search_ctype").val()
	var search_caccountname = $("#search_caccountname").val();
	var search_caccounttypename = $("#search_caccounttypename").val();
	
	if(search_ctype != null && search_ctype != ""){
		$("#ctype").val(search_ctype);
	}
	ctype = $("#ctype").val();
	f_getComboboxAccountData();
	f_getComboboxAccountTypeData();
	$("#ctype").change(function(){
		ctype = $("#ctype").val();
		f_getComboboxAccountTypeData();
		comboboxAccountType.clearContent();
		comboboxAccountType.setData(comboboxAccountTypeData);
	});
	
	comboboxAccount = $("#caccountname").ligerComboBox({
		data:comboboxAccountData,
		onSelected: function (value){$("#uaccountid").val(value);}
	});
	comboboxAccountType = $("#caccounttypename").ligerComboBox({
		data:comboboxAccountTypeData,
		onSelected: function (value){$("#uaccounttypeid").val(value);}
	});
	
	$("#beganTime").ligerDateEditor({initValue:$("#search_beganTime").val()});
	$("#endTime").ligerDateEditor({initValue:$("#search_endTime").val()});
	$("#caccountname").val(search_caccountname);
	$("#caccounttypename").val(search_caccounttypename);
	
});
function submitSearch(){
	if($("#searchForm").validationEngine("validate")){$("#searchForm").submit();}
}
function f_getComboboxAccountData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountJSONArray",
		dataType:"json",
		success:function(data){
			comboboxAccountData = data;
		}
	});
}
function f_getComboboxAccountTypeData(){
	$.ajax({
		type:"post",
		async:false,
		cache:false,
		url:contextPath+"/bpr/lovelysnow/getAccountTypeJSONArray",
		data:{'ctype':ctype},
		dataType:"json",
		success:function(data){
			comboboxAccountTypeData = data;
		}
	});
}