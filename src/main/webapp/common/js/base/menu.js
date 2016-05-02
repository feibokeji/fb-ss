function Menu(o, n) {
	this.tree = o;
	this.scrollHeight = n;
	this.childCount = 0;
	var k = this;
	var l, f, a;
	var d = $(".main");
	var c = $("aside", d);
	$.extend(Menu.prototype, {
		setScrollHeight : function(i) {
			this.scrollHeight = i;
			c.find(".submenu").height(this.scrollHeight);
		},
		toLink : function(i) {
			if (!i.e) {
				i.e = "child";
			}
			var m = '<a href="';
			switch (i.e) {
			case "child":
				m += 'javascript:void(0);" childkey="child' + this.childCount;
				this.tree["child" + this.childCount++] = i.v;
				break;
			case "self":
				m += i.v;
				break;
			case "main":
				m += i.v + '" class="mainTag';
				break;
			case "js":
				m += 'javascript:void(0);" onclick="'
						+ i.v.replace(new RegExp('"', "gm"), "&quot;");
				break;
			case "load":
				m += 'javascript:void(0);" load="' + i.v;
				break;
			default:
				m += i.v + '" target="' + i.e;
			}
			if (i.tp) {
				m += '" title="'
						+ i.tp.replace(new RegExp('"', "gm"), "&quot;");
			}
			m += '">' + i.t + "</a>";
			return m;
		}
	});
	var j = "";
	for ( var e = 0; e < this.tree.topMenu.length; e++) {
		var b = this.tree.topMenu[e];
		j += "[ " + this.toLink(b) + " ]&nbsp;&nbsp;";
	}
	$("#topMenu").append(j);
	$("#topMenu, #headMenu").find("a[childKey], a[load]").live("click",
			function() {
				g(this, k);
			});
	var h = "<ul>";
	for ( var e = 0; e < this.tree.headMenu.length; e++) {
		var b = this.tree.headMenu[e];
		h += "<li>" + this.toLink(b) + "</li>";
	}
	h += "</ul>";
	$("#headMenu").append(h).find("a").live(
			"click",
			function() {
				$(this.parentNode).attr("class", "hover").siblings(".hover")
						.removeClass("hover");
			}).eq(0).click();
	$("li.Opened p, li.Closed p", c).live("click", function() {
		$(this.parentNode).toggleClass("Opened Closed");
	});
	$(".scrollL").live({
		mousedown : function() {
			l = setInterval(function() {
				a.scrollTop -= 10;
			}, 10);
		},
		mouseup : function() {
			clearInterval(l);
		},
		mouseout : function() {
			clearInterval(l);
		}
	});
	$(".scrollR").live({
		mousedown : function() {
			f = setInterval(function() {
				a.scrollTop += 10;
			}, 10);
		},
		mouseup : function() {
			clearInterval(f);
		},
		mouseout : function() {
			clearInterval(f);
		}
	});
	function g(u, v) {
		var t = $(u);
		if (t.is("[childKey]")) {
			var s = "<h2>" + t.text() + '</h2><ul class="submenu">';
			var p = v.tree[t.attr("childkey")];
			for ( var r = 0; r < p.length; r++) {
				var q = p[r];
				s += '<li class="Opened"><p>' + q.t + "</p><ul>";
				for ( var m = 0; m < q.c.length; m++) {
					s += "<li>" + v.toLink(q.c[m], v) + "</li>";
				}
				s += "</ul></li>";
			}
			s += "</ul>";
			c.empty().append(s);
		} else {
			if (t.is("[load]")) {
				c.empty().append("<h2>" + t.text() + "</h2>").append(
						$("<div>", {
							"class" : "submenu"
						}).load(t.attr("load")));
			}
		}
		c
				.append('<div class="scrollMenu"><div class="scrollL"></div><div class="scrollR"></div></div>');
		a = c.find(".submenu").get(0);
		v.setScrollHeight(v.scrollHeight);
	}
};