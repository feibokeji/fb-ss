(function(a) {
	a.fn.autopoint = function() {
		var c = "#D9D9D9";
		var b = this.filter(":input");
		a(b).each(function() {
			var e = a(this).css("color");
			var g = a(this).attr("type");
			var f = function() {
				if (a(this).isEmpty()) {
					a(this).css("color", c);
					a(this).val(this.defaultValue);
					if (g == "password") {
						try {
							this.type = "text"
						} catch (h) {
						}
					}
				}
			};
			var d = function() {
				if (a(this).val() == a(this)[0].defaultValue) {
					a(this).css("color", e);
					this.type = g;
					a(this).val("")
				}
			};
			a(this).bind("blur", f);
			a(this).bind("focus", d);
			f.apply(this)
		})
	};
	a.fn.isEmpty = function() {
		return !a(this).val() || a(this).val() == a(this)[0].defaultValue
	}
})(jQuery);