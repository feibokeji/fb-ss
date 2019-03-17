var tab = null;
var accordion = null;
var tabItems = [];
var _ligerDialog = null;

function getLinkPrevHref(iframeId){
    if (!window.frames[iframeId]) return;
    var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
    var links = $("link:first", head);
    for (var i = 0; links[i]; i++){
        var href = $(links[i]).attr("href");
        if (href && href.toLowerCase().indexOf("ligerui") > 0){
            return href.substring(0, href.toLowerCase().indexOf("lib") );
        }
    }
}

function getQueryString(name){
    var now_url = document.location.search.slice(1), q_array = now_url.split('&');
    for (var i = 0; i < q_array.length; i++){
        var v_array = q_array[i].split('=');
        if (v_array[0] == name){
            return v_array[1];
        }
    }
    return false;
}

function attachLinkToFrame(iframeId, filename){ 
    if(!window.frames[iframeId]) return;
    var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
    var fileref = window.frames[iframeId].document.createElement("link");
    if (!fileref) return;
    fileref.setAttribute("rel", "stylesheet");
    fileref.setAttribute("type", "text/css");
    fileref.setAttribute("href", filename);
    head.appendChild(fileref);
}

//全屏方法
function launchFullScreen() {
	var elem = document.documentElement;
    if (elem.webkitRequestFullScreen) {
        elem.webkitRequestFullScreen();
    } else if (elem.mozRequestFullScreen) {
        elem.mozRequestFullScreen();
    } else if (elem.requestFullScreen) {
        elem.requestFullscreen();
    } else {
        //notice.notice_show("浏览器不支持全屏API或已被禁用", null, null, null, true, true);
    }
}

//退出全屏
function exitFullScreen() {
    var elem = document;
    if (elem.webkitCancelFullScreen) {
        elem.webkitCancelFullScreen();
    } else if (elem.mozCancelFullScreen) {
        elem.mozCancelFullScreen();
    } else if (elem.cancelFullScreen) {
        elem.cancelFullScreen();
    } else if (elem.exitFullscreen) {
        elem.exitFullscreen();
    } else {
        //notice.notice_show("浏览器不支持全屏API或已被禁用", null, null, null, true, true);
    }
}

var financialMenuNodes = [
    {name:"供应商账务",open:true,
    	children:[
    	    {name:"商品类",open:true,
    	    	children:[
    	    	    {name:"应付款项",title:"/bpr/supplier/financial/goods/receivable?ctype=AP"},
    	    	    {name:"应收款项",title:"/bpr/supplier/financial/goods/receivable?ctype=AR"}
    	    	]
    	    },
    	    {name:"手机类",open:true,
    	        children:[
    	            {name:"应付款项",title:"/bpr/supplier/financial/phone/receivable?ctype=AP"},
    	            {name:"应收款项",title:"/bpr/supplier/financial/phone/receivable?ctype=AR"}
    	        ]
    	    },
    	]
    },
    {name:"同行账务",open:true,
    	children:[
            {name:"商品类",open:true,
    	     	children:[
    	     	    {name:"应付款项",title:"/bpr/supplier/financial/goods/receivable?ctype=AP"},
    	    	    {name:"应收款项",title:"/bpr/supplier/financial/goods/receivable?ctype=AR"}
    	        ]
    	    },
    	    {name:"手机类",open:true,
    	        children:[
    	    	    {name:"应付款项",title:"/bpr/supplier/financial/phone/receivable?ctype=AP"},
    	    	    {name:"应收款项",title:"/bpr/supplier/financial/phone/receivable?ctype=AR"}
    	    	]
    	    },
    	]
    },
    {name:"客户账务",open:true,
    	children:[
    	    {name:"商品类",open:true,
    	        children:[
    	    	    {name:"应付款项",title:"/bpr/supplier/financial/goods/receivable?ctype=AP"},
    	    	    {name:"应收款项",title:"/bpr/supplier/financial/goods/receivable?ctype=AR"}
    	    	]
    	    },
    	    {name:"手机类",open:true,
    	        children:[
    	            {name:"应付款项",title:"/bpr/supplier/financial/phone/receivable?ctype=AP"},
    	            {name:"应收款项",title:"/bpr/supplier/financial/phone/receivable?ctype=AR"}
    	        ]
    	    },
    	]
    }
];
var menuSetting = {callback: {onClick: onFinancialClick}};

function onFinancialClick(event, treeId, treeNode, clickFlag){
	if(!treeNode.isParent){
		openPage(treeNode.tId,treeNode.getParentNode().getParentNode().name + "-" + treeNode.getParentNode().name + "-" +treeNode.name,contextPath + treeNode.title);
	}
}

$(function() {
	// 布局
	$("#layout1").ligerLayout({
		leftWidth : 160,
		height : '100%',
		heightDiff : -34,
		space : 4,
		onHeightChanged : f_heightChanged
	});
	
	var height = $(".l-layout-center").height();

	// Tab
	$("#framecenter").ligerTab({
		height : height,
		showSwitchInTab : true,
        showSwitch: true,
        onAfterAddTabItem: function (tabdata){
            tabItems.push(tabdata);
        },
        onAfterRemoveTabItem: function (tabid){ 
            for (var i = 0; i < tabItems.length; i++)
            {
                var o = tabItems[i];
                if (o.tabid == tabid)
                {
                    tabItems.splice(i, 1);
                    break;
                }
            }
        },
        onReload: function (tabdata){
            var tabid = tabdata.tabid;
            addFrameSkinLink(tabid);
        }
	});

	// 面板
	$("#accordion1").ligerAccordion({
		height : height - 24,
		speed : null
	});

	tab = liger.get("framecenter");
    accordion = liger.get("accordion1");
	$("#pageloading").hide();
	
	//财务菜单树形结构数据
	$.fn.zTree.init($("#financialMenu"), menuSetting, financialMenuNodes);
});

function f_heightChanged(options) {
	if (tab)
		tab.addHeight(options.diff);
	if (accordion && options.middleHeight - 24 > 0)
		accordion.setHeight(options.middleHeight - 24);
}

function addFrameSkinLink(tabid){
    var prevHref = getLinkPrevHref(tabid) || "";
    var skin = getQueryString("skin");
    if (!skin) return;
    skin = skin.toLowerCase();
    attachLinkToFrame(tabid, prevHref + skin_links[skin]);
}

//打开新页面
function openPage(tabid, text, url){
	tab.addTabItem({
        tabid: tabid,
        text: text,
        url: url,
        callback:function(){
        	addFrameSkinLink(tabid);
        }
    });
}
/**
 * 登出
 */
function logout(){
	$.ligerDialog.confirm('您是否确定要退出此系统吗？', function (yes){
		if(yes){
			window.location.href = contextPath + "/bpr/logout";
		}
	});
}
function f_User_Info(info){
	$.ligerDialog.open({
		title:'账户信息',
		url: contextPath + '/bpr/user/detail', 
		height: 600,
		width: 500, 
		buttons: [{ text: '关闭', onclick: function (item, dialog) { dialog.close(); } } ] 
	});
}
function f_Mode_Password(){
	_ligerDialog = $.ligerDialog.open({ target: $("#modifyPasswordDiv"),title:"修改密码",width:480,height:340,
		buttons:[{text:"保存",onclick:function(i,d){f_SubmitPassword(); }},{text:"关闭",onclick:function(i,d){d.hide();}}]
	});
}
function f_SubmitPassword(){
	var uid = $("#uid").val();
	var password1 = $("#password1");
	var password2 = $("#password2");
	if(password1.val() == null || password1.val() == ""){
		$.ligerDialog.error("请填写新密码!")
		password1.focus();
		return false;
	}
	if(password2.val() == null || password2.val() == ""){
		$.ligerDialog.error("请再次输入一次密码!")
		password2.focus();
		return false;
	}
	if(password1.val() != "" && password1.val() != null && password2.val() != "" && password2.val() != null){
		if(password1.val() != password2.val()){
			$.ligerDialog.error("两次密码不一致!")
			password2.focus();
			return false;
		}else{
			$.ligerDialog.confirm("确定要修改吗?",function(yes){
				if(yes){
					var waitting = $.ligerDialog.waitting('密码修改中,请稍候...');
					$.ajax({
						type:"post",
						async:false,
						cache:false,
						url:contextPath+"/bpr/user/setPassword",
						data:{'uid':uid,'password':password2.val()},
						dataType:"html",
						success:function(data){
							waitting.close();
							if(data == "fail")
								$.ligerDialog.error("修改失败!");
							else{
								$.ligerDialog.success("修改成功!");
							}
						}
					});
				}
			});
		}
	}
}