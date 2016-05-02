var closeHistory = new Array;
var tagList = new Array;
var iframeHeight;
var loadURL = (typeof (contextPath) == "undefined" ? "" : contextPath) + "/page/common/loading?url=";
var win, sliderbarUL, sliderbar, bodybox, mainContent, inited = false;
var scrollEvent;
$(function() {
	initDomCache();
	mainOuterHeight = typeof (mainOuterHeight) == "undefined" ? ($("header").height() + $("footer").height() + 10) : mainOuterHeight;
	resetView();
	sliderbarUL.mousedown(clickBar).find("li span").live({
		dblclick : function() {
			if($(this).parents("li")[0].id != "商品销售"){
				closeTag($(this).parents("li")[0].id);
			}
		},
		click : function() {
			turnTag($(this).parents("li")[0].id);
		}
	});
	sliderbarUL.find("li a").live("click", function() {
		closeTag($(this).parents("li")[0].id);
	});
	$("a.mainTag").live("click", function() {
		return openLinkTag(this);
	});
	$("form.mainTag").live("submit", function() {
		return openFormTag(this);
	});
	$(".leftslider, .rightslider").bind({
		mousedown : function() {
			setScroll(this.className == "leftslider" ? -30 : 30);
		},
		mouseup : stopScroll,
		mouseout : stopScroll,
		focus : function() {
			this.blur();
		}
	});
});
function initDomCache() {
	if (!inited) {
		win = $(window);
		sliderbarUL = $("#sliderbarUL");
		sliderbar = $("#sliderbar");
		bodybox = $("#bodybox");
		mainContent = $(".mainContent");
		inited = true;
	}
}
function resetView() {
	sliderbar.width(mainContent.width() - 35);
	iframeHeight = win.height() - mainOuterHeight - 27;
	$("#bodybox iframe").attr("height", iframeHeight);
}
function setUlWidth() {
	var b = sliderbarUL.children("li");
	sliderbarUL.css("width", b.length * 1000);
	var a = 10;
	for ( var c = b.length - 1; c >= 0; c--) {
		a += b[c].offsetWidth;
	}
	sliderbarUL.css("width", a);
}
function openTag(c, e, b) {
	initDomCache();
	e = formatTitle(e);
	b = typeof (b) == "boolean" ? b : true;
	c = loadURL + escape(encodeURIComponent(c));
	if (tagList["t" + e]) {
		turnTag(e);
		tagList["t" + e].body.children("iframe").attr("src", c);
		return
	}
	var a = tagList["t" + e] = {
		tag : $('<li id="' + e + '"><span>' + e + "</span>"
				+ (b ? '<a href="javascript:void(0)"></a>' : "") + "</li>"),
		body : $('<div id="'
				+ e
				+ '_body" style="display:none"><iframe height="'
				+ iframeHeight
				+ '" width="100%" allowTransparency="true" frameborder="0" id="'
				+ e + '_frame" name="' + e + '" src="' + c
				+ '"></iframe></div>')
	};
	var d = sliderbarUL.find(".hover");
	if (d.size() == 0) {
		sliderbarUL.append(a.tag);
	} else {
		d.after(a.tag);
	}
	bodybox.append(a.body);
	setUlWidth();
	turnTag(e);
}
function closeActiveTag() {
	closeTag(getTitle());
}
function getTitle() {
	return sliderbarUL.find(".hover").attr("id");
}
function reloadActiveFrame() {
	reloadFrame(getTitle());
}
function reloadFrame(b) {
	b = formatTitle(b);
	try {
		if (tagList["t" + b]) {
			tagList["t" + b].body.find("iframe").get(0).contentWindow.location.reload();
		}
	} catch (a) {
	}
}
function closeTag(c) {
	c = formatTitle(c);
	if (tagList["t" + c]) {
		var b = tagList["t" + c].tag;
		if (b.hasClass("hover")) {
			var a;
			if (b.prevAll("li")[0]) {
				a = b.prevAll("li").attr("id");
			} else {
				if (b.nextAll("li")[0]) {
					a = b.nextAll("li").attr("id");
				}
			}
			if (a) {
				turnTag(a);
			}
		}
		closeHistory.push({
			u : tagList["t" + c].body.children("iframe").attr("src"),
			t : c
		});
		b.remove();
		tagList["t" + c].body.remove();
		tagList["t" + c] = undefined;
		setUlWidth();
	}
}
function historyTag() {
	var a = closeHistory.pop();
	if (a != null) {
		openTag(a.u, a.t);
	}
}
function historyIndexTag(a) {
	var b = closeHistory[a];
	if (b != null) {
		openTag(b.u, b.t);
	}
	closeHistory.splice(a, 1);
}
function getCloseHistory() {
	return closeHistory;
}
function turnTag(c) {
	c = formatTitle(c);
	if (tagList["t" + c]) {
		var b = sliderbarUL.find(".hover");
		var a = b.attr("id");
		if (a != c) {
			if (b.size() > 0) {
				b.removeClass("hover");
				tagList["t" + formatTitle(a)].body.hide();
			}
			tagList["t" + c].tag.addClass("hover");
			tagList["t" + c].body.show();
		}
	}
}
function setScroll(a) {
	sliderbar.get(0).scrollLeft += a;
	scrollEvent = setTimeout("setScroll(" + a + ")", 30);
}
function stopScroll() {
	clearTimeout(scrollEvent);
}
var _isDrag = false;
var _scrollLeft, _x;
function clickBar(a) {
	var b = a || window.event;
	_scrollLeft = $(window).scrollLeft();
	_x = _scrollLeft + b.clientX;
	_isDrag = true;
	if (document.addEventListener) {
		document.addEventListener("mousemove", dragBar, false);
		document.addEventListener("mouseup", unclickBar, false);
	} else {
		document.attachEvent("onmousemove", dragBar);
		document.attachEvent("onmouseup", unclickBar);
	}
}
function dragBar(a) {
	if (_isDrag) {
		var b = a || window.event;
		sliderbar.get(0).scrollLeft -= b.clientX - _x;
		_scrollLeft = $(window).scrollLeft();
		_x = _scrollLeft + b.clientX;
	}
}
function unclickBar() {
	_isDrag = false;
	if (document.removeEventListener) {
		document.removeEventListener("mousemove", dragBar, false);
		document.removeEventListener("mouseup", unclickBar, false);
	} else {
		document.detachEvent("onmousemove", dragBar);
		document.detachEvent("onmouseup", unclickBar);
	}
}
function formatTitle(a) {
	return a.replace(new RegExp('"', "gm"), "&quot;");
}
function openLinkTag(c) {
	try {
		var d = $(c);
		var a = d.attr("title");
		if (null == a || a == "") {
			a = d.text();
		}
		openTag(d.attr("href"), a);
	} catch (b) {
		alert(b.message);
	}
	return false;
}
function openFormTag(b) {
	var d = $(b);
	var a = b.action;
	if (a.contains("?")) {
		a += "&";
	} else {
		a += "?";
	}
	var c = b.title;
	a += addURL(d.find(":text"));
	a += addURL(d.find(":hidden"));
	a += addURL(d.find(":checked"));
	a += addURL(d.find("select"));
	a += addURL(d.find("textarea"));
	a = a.substring(0, a.length - 1);
	c = c.replace(/@\{.+?}/g, function(e) {
		e = e.substring(2, e.length - 1);
		var l = d.find("[name='" + e + "']");
		var n = "";
		for ( var g = 0; g < l.length; g++) {
			var f = $(l[g]);
			if ($(l[g]).is("select")) {
				var k = f.children(":selected");
				var j = k.length;
				for ( var h = 0; h < j; h++) {
					n += $(k[h]).text().trim() + ",";
				}
			} else {
				if (f.is(":checked")) {
					n += f.val() + ",";
				} else {
					if (!f.is(":checkbox") && !f.is(":radio")) {
						n += f.val() + ",";
					}
				}
			}
		}
		return n.length == 0 ? n : n.substring(0, n.length - 1);
	});
	openTag(a, c, d.attr("canclose") != "false");
	return false;
}
function addURL(d) {
	var a = d.length;
	var b = "";
	for ( var c = 0; c < a; c++) {
		if ($(d[c]).is("select")) {
			var g = $(d[c]).children(":selected");
			var f = g.length;
			for ( var e = 0; e < f; e++) {
				b += d[c].name + "=" + g[e].value + "&";
			}
		} else {
			b += d[c].name + "=" + d[c].value + "&";
		}
	}
	return b;
};