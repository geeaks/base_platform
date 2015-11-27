//页面预加载
$(function(){
	var cookies=document.cookie.split(";");
	for(var i=0;i<cookies.length;i++){
		if(cookies[i].indexOf("loginId")>-1){
			$('input[name="loginId"]').val(cookies[i].split("=")[1]);
			$("#rememberMe").attr({"checked":true});
			break;
		}else{
			$('input[name="loginId"]').val("");
		}
	}
	
});

//重新加载图片验证码
function reloadImgCode(){
	document.getElementById("imgCode").src=document.getElementById("imgCode").src + "?nocache="+new Date().getTime();
}