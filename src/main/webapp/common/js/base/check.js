function InitCheck(a){this.defaults={checkName:"check",multiple:false,multipleValue:null,splitChar:","};this.checked=null;var c=this;$.extend(this.defaults,a);this.checkboxs=$("input[name="+this.defaults.checkName+"]");if(!this.defaults.multiple){this.checkboxs.click(function(){b(c,this)})}else{this.checkboxs.click(function(){d(c,this)});$("input[name="+this.defaults.checkName+"All]").click(function(){var e=$(this);if(e.is(":checked")){c.checkboxs.attr("checked","checked")}else{c.checkboxs.removeAttr("checked")}})}function b(f,e){$o=$(e);if($o.is(":checked")){f.checkboxs.removeAttr("checked");$o.attr("checked","checked")}d(f)}function d(e){e.checked=null}if(!InitCheck._initialized){$.extend(InitCheck.prototype,{verifyCheck:function(e){this.checked=this.checkboxs.filter(":checked");if(this.checked.length==0){if(this.defaults.multiple){e=e!=false}alert("提示:您必须选择"+(this.defaults.multiple&&e?"至少":"")+"一条记录，才能执行当前操作！");return false}else{if(this.checked.length>1&&(!this.defaults.multiple||e==false)){alert("提示:您只能选择一条记录执行当前操作！");return false}else{if(this.defaults.multipleValue!=null&&this.defaults.multipleValue instanceof Array&&this.checked.val().split(this.defaults.splitChar).length!=this.defaults.multipleValue.length){alert("错误：multipleValue与选项值不对应！");return false}}}return true},getCheckValue:function(h,g){if(this.checked==null){alert("警告：调用getCheckValue()方法前未调用verifyCheck()进行验证！请勿在调用verifyCheck()后反复调用getCheckValue()方法");this.checked=this.checkboxs.filter(":checked")}if(typeof(h)=="boolean"){g=h!=false;h=""}h=typeof(h)=="undefined"?"":h;g=g!=false;var l=-1;if(h!=""){$.each(this.defaults.multipleValue,function(j,m){if(m==h){l=j;return false}});if(l==-1){alert("参数值"+h+"不在指定属性["+this.defaults.multipleValue+"]中！")}}if(this.defaults.multiple&&g){var k=new Array(this.checked.length);if(this.defaults.multipleValue==null){$.each(this.checked,function(j,m){k[j]=m.value})}else{if(l>-1){$.each(this.checked,(function(j,n){var m=n.value.split(this.defaults.splitChar);k[j]=m[l]}).domain(this))}else{$.each(this.checked,(function(o,q){var p=q.value.split(this.defaults.splitChar);var n={};for(var m=this.defaults.multipleValue.length-1;m>=0;m--){n[this.defaults.multipleValue[m]]=p[m]}k[o]=n}).domain(this))}}d(this);return k}else{if(this.defaults.multipleValue==null){var k=this.checked.val();d(this);return k}else{var i=this.checked.val().split(this.defaults.splitChar),k;if(l>-1){k=i[l]}else{var f={};for(var e=this.defaults.multipleValue.length-1;e>=0;e--){f[this.defaults.multipleValue[e]]=i[e]}k=f}d(this);return k}}}});InitCheck._initialized=true}};