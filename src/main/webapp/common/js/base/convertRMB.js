function convertRMB(g){var c=999999999999.99;var e="零";var B="壹";var o="贰";var v="叁";var w="肆";var H="伍";var E="陆";var s="柒";var K="捌";var q="玖";var h="拾";var D="佰";var y="仟";var J="万";var n="亿";var l="元";var G="角";var k="分";var m="整";var b;var j;var x="";var C;var u,a,A,L;var t;var F,z,I;var f,r;g=g.toString();if(g==""){alert("Empty input!");return""}if(g.substring(0,1)=="-"){g=g.substring(1);x="负"}if(g.match(/[^,.\d]/)!=null){alert("Invalid characters in the input string!");return""}if((g).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/)==null){alert("Illegal format of digit number!");return""}g=g.replace(/,/g,"");g=g.replace(/^0+/,"");if(Number(g)>c){alert("Too large a number to convert!");return""}C=g.split(".");if(C.length>1){b=C[0];j=C[1];j=j.substr(0,2)}else{b=C[0];j=""}u=new Array(e,B,o,v,w,H,E,s,K,q);a=new Array("",h,D,y);A=new Array("",J,n);L=new Array(G,k);if(Number(b)>0){t=0;for(F=0;F<b.length;F++){z=b.length-F-1;I=b.substr(F,1);f=z/4;r=z%4;if(I=="0"){t++}else{if(t>0){x+=u[0]}t=0;x+=u[Number(I)]+a[r]}if(r==0&&t<4){x+=A[f]}}x+=l}if(!j.match(/^[0]*$/)){for(F=0;F<j.length;F++){I=j.substr(F,1);if(I!="0"){x+=u[Number(I)]+L[F]}}}if(x==""){x=e+l}if(j.match(/^[0]*$/)){x+=m}return x};