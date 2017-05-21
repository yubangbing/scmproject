<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta name="viewport"
	content="minimum-scale=0.5,maximum-scale=1.0,user-scalable=no, initial-scale=1.0" /> -->
<title>登录系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/login.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<noscript>您的浏览器不支持JavaScript,请使用其它浏览器</noscript>
</head>
<body style="max-width: 100%;">
<div style="position:absolute; left:0; top:0; width:100%; height:100%"></div>  
<img src="images/background.jpg" width=100% height=100%>
	<%-- openId是：${param.openId} --%>
	<script type="text/javascript">
     //处理反馈完成后弹出提示函数
    var handlePromptTime;
    function handlePrompt(val) {
         $("body").append("<div class='handlePrompt'>" + val + "</div>");
         clearTimeout(handlePromptTime);
         handlePromptTime = setTimeout(function () {
             $(".handlePrompt").remove();
           }, 2000);
       };
    
    function login() {
    	
        var name = $("#userName").val();
        var pwd = $("#password").val();
        

        //验证账号
        if (name == undefined || name == '') {
            alert("请输入手机账号");
            return;
        }
        //验证手机号
        if(!(/^1[34578]\d{9}$/.test(name))){ 
        alert("手机号码格式有误，请重填");  
        return; 
        } 

        if (pwd == undefined || pwd == '') {
            alert("请输入密码");
            return;
        }
       var sendData = {
               "accLogin" : name,
               "accPass"  :  pwd,
           };
       $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/account/login.action",
           dataType:'json',
           data: JSON.stringify(sendData),
           contentType : 'application/json',
           success: function(data){
        	  // alert(JSON.stringify(data));
        	   if(data.isabnormal==1){
        		   handlePrompt("登录成功！");
              	    setTimeout(function(){
              		   window.location.href = "${pageContext.request.contextPath}/base/goURL/jsp/main.action";},
              		   500); 
        	   }else{
                   if(data.isabnormal==6)
                	   handlePrompt("没有此用户，请先注册！");
                   if(data.isabnormal==7)
                	   handlePrompt("密码错误！");
                   if(data.isabnormal==5)
                	   handlePrompt("系统服务出错，请重新加载！");
                   return false;
                }
        	   //登陆成功后 1设置cookie或session(跳过)2 存储openid和userid(后端实现)3 2秒后跳转到成功页面
        	   //进入main.jsp
            },
       
        }); 
        
      }
</script>

	<style>
body {
	min-height: 457px;
	background: #fff;
}

.log_reg_item .show_hide_pass {
	zoom: 0;
	top: 18px;
	right: 12px;
}

.log_reg_item .show_hide_pass.icon_visible {
	width: 16px;
	height: 11px;
	background: url("images/collection.png") 0 -63px no-repeat;
	background-size: 16px 133px
}

.log_reg_item .show_hide_pass.icon_invisible {
	top: 18px;
	right: 12px;
	width: 16px;
	height: 6px;
	background: url("images/collection.png") 0 -15px no-repeat;
	background-size: 16px 133px
}
</style>

	<div class="searchMain" style="max-width:500px;margin-top:-34.5%;margin-left:30%">
		<div class="container" id="BodyContainer">
			<header id="r_header" class="r_title" style="height:70px;background-color: #aec0fe;font-size:40px;color: rgb(0,0,0)"> 登录进销存系统 </header>
			<div class="warn_message" style="text-align: center">我们会保障您的隐私，请放心绑定</div>

			<section class="r_content logRegTabCon">
			<form action="${pageContext.request.contextPath }/bind.jsp"
				method="post">
				<div class="log_reg_item">
					<a> <img
						src="${pageContext.request.contextPath }/images/img_login_1_16325.png"
						width="17" height="20"> <input id="userName" name="userName"
						placeholder="手机号" type="text" value="">
					</a> <a> <img src="./images/img_login_2_16325.png" width="17"
						height="20"> <input id="password" name="pwd"
						placeholder="密码" type="password"> <i
						class="show_hide_pass icon_invisible"></i>
					</a>
				</div>
				<section class="j_employmentBox other_operation">
				<div class="btn" style="cursor:pointer" onclick="login();">登 录</div>
				<p>
					没有帐号,<a href="${pageContext.request.contextPath }/register.jsp"
						class="login_tip">立即注册</a>
				</p>
				</section>
			</form>
			</section>
		</div>
	</div>
	<script>
    //切换输入密码明暗文
    $password = $('#password');
    $('.log_reg_item a .show_hide_pass').click(function (event) {
        $(this).hasClass("icon_invisible") ? ($(this).removeClass("icon_invisible").addClass("icon_visible"),
         $password.attr("type", "text")) : $(this).hasClass("icon_visible") && ($(this).removeClass("icon_visible").addClass("icon_invisible"),
         $password.attr("type", "password"));
    });
</script>
</body>
</html>