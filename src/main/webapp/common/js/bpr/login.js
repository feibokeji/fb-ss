var loginDiv = null;
$(function(){
	loginDiv = $("#loginDiv");
	loginDiv.css("margin-top",($(document).height()/2 - loginDiv.height()/2));
	$("#pageloading").hide();
	//回车事件
	document.onkeydown = function(e){
		var ev = document.all ? window.event : e;
		if(ev.keyCode == 13){
			login();
		}
	};
	getRemember();
});
/**
 * 获取记录的用户信息
 */
function getRemember(){
	$.ajax({
		type:"post",
		async:false,
		url:contextPath+"/ajax/getCookies",
		dataType:"json",
		success:function(data){
			if(data.remember == "true"){
				$("#remember").attr("checked","checked");
				$("#code").val(data.code);
			}
		}
	});
}
/**
 * 登录操作
 */
function login(){
	var code = $("#code").val();
	var password = $("#password").val();
	var verifyCode = $("#verifyCode").val();
	var remember = $("#remember").attr("checked") == "checked" ? true : false ;
	if(code == ""){
		$.ligerDialog.error('请正确输入登录账号!');
		$("#code").focus();
		return;
	}
	if(password == ""){
		$.ligerDialog.error('请正确输入登录密码!');
		$("#password").focus();
		return;
	}
	if(verifyCode == ""){
		$.ligerDialog.error('请正确输入验证码!');
		$("#verifyCode").focus();
		return;
	}
	$("#pageloading").show(0.1,function(){
		$("#pageloading").focus();
		$.ajax({
			type:"post",
			async:true,
			url:contextPath+"/ajax/login",
			data:{'code':code,'password':password,'verifyCode':verifyCode,'remember':remember},
			dataType:"json",
			success:function(data){
				if(data.isSuccess){
					window.location.href = contextPath + "/bpr/index";
				}else{
					$.ligerDialog.error(data.info);
					$("#pageloading").hide();
				}
			}
		});
	});
}
/**
 * 用户注册
 */
function register(){
	alert("开发过程中......");
}
/**
 * 重新加载验证码
 * @param o
 */
function show(o){
	var timenow = new Date().getTime();
	o.src= contextPath + "/image.jsp?d=" + timenow;
}