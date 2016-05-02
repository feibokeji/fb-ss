var tab = null;
var accordion = null;
var tabItems = [];

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