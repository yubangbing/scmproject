<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <!--  <meta name="viewport" content="minimum-scale=0.5,maximum-scale=1.0,user-scalable=no, initial-scale=1.0" /> -->
    <title>注册系统账号</title>
    <link href="${pageContext.request.contextPath }/css/register.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/register.js"></script>
    <noscript>您的浏览器不支持JavaScript,请使用其它浏览器</noscript>
</head>
<body style="min-height: 569px; max-width: 100%;">
<div style="position:absolute; left:0; top:0; width:100%; height:100%"></div>  
<img src="images/background.jpg" width=100% height=100%>
<style>
    body{min-height: 457px;background:#fff;}
    :-moz-placeholder,::-webkit-input-placeholder{color: #cccccc;}
    .secrecyText{width:210px;font-size:12px;color:#646464;text-align:center;display:block;position:absolute;bottom:0px;left:50%;margin-left:-105px;}
    .secrecyText span{color:#42beff;text-decoration: none;}
    header{position:relative;background:#42beff;width:100%;padding:10px 0}
    header .title{width:94%;margin:0 auto;text-align:center;color:#ffffff;position:relative}
    header span{position:absolute;top:6px;left:0;text-indent:-9999px;width:8px;height:15px;background:url("//img09.zhaopin.cn/2012/other/mobile/images/collection.png") 0 0 no-repeat;background-size:16px 133px}
    header strong{position:absolute;text-indent:-9999px;top:6px;right:0;width:16px;height:16px;background:url("//img09.zhaopin.cn/2012/other/mobile/images/collection.png") 0 -21px no-repeat;background-size:16px 133px}
    header h3{font-size:18px;font-weight:normal}
    header .pokerface{position:absolute;top:0;left:0;height:40px;width:40px;text-indent:-9999px}

    .log_reg_item a{ width: 96%;margin: 0 auto;border-bottom: none;}    
    .log_reg_item a input#MobilePhone,input#MobilePhonePwd,input#nickname,input#MobilePhoneCheak{ margin-left: 24px; }
    .log_reg_item a em.new_cellphone{ position:absolute;top:16px;left:0;text-indent:-9999px;width:12px;height:16px;background:url("images/collection.png") 0 -90px no-repeat;background-size:16px 133px } 
    .log_reg_item a em.new_password{ position:absolute;top:16px;left:0;text-indent:-9999px;width:14px;height:16px;background:url("images/collection.png") 0 -74px no-repeat;background-size:16px 133px } 
    .log_reg_item a em.new_message{ position:absolute;top:16px;left:0;text-indent:-9999px;width:16px;height:12px;background:url("images/collection.png") 0 -51px no-repeat;background-size:16px 133px } 
    .log_reg_item a em.new_nickname{ position:absolute;top:16px;left:0;text-indent:-9999px;width:14px;height:16px;background:url("images/img_login_1_16325.png") center no-repeat;background-size:14px 16px } 

    .log_reg_item .show_hide_pass{ zoom: 0; top: 18px;right: 12px;}
    .log_reg_item .show_hide_pass.icon_visible{ width:16px;height:11px;background:url("images/collection.png") 0 -63px no-repeat;background-size:16px 133px }
    .log_reg_item .show_hide_pass.icon_invisible{top: 18px; right: 12px;width:16px;height:6px;background:url("images/collection.png") 0 -15px no-repeat;background-size:16px 133px }
    .log_reg_item a .mobileCheak{ background: #ffffff;right:0; }
    .log_reg_item a .mobileCheak .text{ color:#42beff;font-size: 14px;text-align: right;line-height: 26px; }
    .log_reg_item a .mobileCheak .text.hover{ border: none;color:#42beff; }
    .log_reg_item a .mobileCheak .countdown{ text-align: right; }
    .other_operation .btn{ width: 92%; }
    .other_operation .login_tip{ color:#42beff;}
    .wiser{ text-indent: -9999px; padding: 25% 0; }
    .darcy-bottom{ width: 80%;margin: 0 auto;padding: 12px 0; font-size: 12px; text-align: center;color: #646464; line-height: 24px;}
    .darcy-bottom p{ text-align: center; font-size: 14px; color: #2287ff;text-decoration: underline;}  
    .darcy-bottom span{color:#42beff;text-decoration: none;}
    .line{ border: none;background-image: -webkit-gradient(linear,left top,left bottom,color-stop(0%,#e6e6e6),color-stop(50%,#e6e6e6),color-stop(50%,transparent)); background-image: -webkit-linear-gradient(top,#e6e6e6 0,#e6e6e6 50%,transparent 50%); background-image: linear-gradient(to bottom,#e6e6e6 0,#e6e6e6 50%,transparent 50%); -webkit-background-size: 100% 1px;background-size: 100% 1px;background-repeat: no-repeat;background-position: bottom;}
    .logRegTabCon .log_reg_item {padding-right: 12px;} 
    .log_reg_item .show_hide_pass{right:0;}
    .log_reg_item .show_hide_pass.icon_invisible{right:0;}
</style>
<div class="searchMain" style="max-width:400px;margin-top:-36.2%;margin-left:30%" >
    <div class="container" id="BodyContainer">
        <header style="background-color: rgb(176, 192, 254);">
            <div class="title" style="color: rgb(0,0,0)">
                 <h1>注册scm系统账号</h1>
            </div>
        </header>
        <section class="r_content logRegTabCon">
            <div class="log_reg_item">
                <a class="line">
                    <em class="new_cellphone"></em>
                    <input id=MobilePhone name="MobilePhone" placeholder="手机号" type="text" value="">
                </a>
                <a class="line">
                    <em class="new_message"></em>
                    <input id="MobilePhoneCheak" maxlength="8" name="MobilePhoneCheak" placeholder="短信确认码" type="text" value="">
                    <div class="mobileCheak">
                        <div class="text" onclick="GetMobileVerification();">获取确认码</div>
                        <div class="countdown"><b class="num">60s</b>后重发</div>
                    </div>
                </a>
                <a class="line">
                    <em class="new_password"></em>
                    <input id="MobilePhonePwd" name="MobilePhonePwd" placeholder="密码(6-20位字母数字组合)" type="text">
                    <i class="show_hide_pass icon_visible"></i>
                </a>            
              
                <a class="line">
                    <em class="new_nickname"></em>
                    <input id="nickname" name="nickname" placeholder="姓名" type="text">
                </a> 
            </div>
            
            <section class="j_employmentBox pt12 other_operation">
                <div class="btn save __ga__resume_zhuce_001"  style="cursor:pointer" onclick="CheckMobileVerification();">注册</div>
                <p>已有帐号，<a href="${pageContext.request.contextPath }/login.jsp" class="login_tip" >立即登录</a></p>
            </section>
        </section>
    </div>
</div>
<div style="margin:0,auto;text-align:center;font-size:28px">可使用账号：13162219002,密码：ybb1234 登录</div>
<script>
    //获取验证码,并且。。s后重发
    function GetMobileVerification() {
    	  var username = $("#MobilePhone").val();

          if (username == undefined || username == "") {
              alert('请输入手机账号');
              return;
          } 
            //验证手机号
          if(!(/^1[34578]\d{9}$/.test(username))){ 
               alert("手机号码格式有误，请重填");  
               return; 
          } 
            
          //这段有用,访问url获取验证码，并且调用函数减少时间
          var url = "${pageContext.request.contextPath}/account/sendcode.action";
          var sendData = {
                 "accLogin" : username
             };
         $.ajax({
             type: "POST",
             url: "${pageContext.request.contextPath}/account/sendcode.action",
             dataType:'json',
             data:  JSON.stringify(sendData),
             contentType: 'application/json',
             success: function(data){
                     if(data.isabnormal==0){
                  	   handlePrompt("系统服务出错！");
                       return false;
                     }
                  	//alert(JSON.stringify(data));
                  	SwitchingCheak();
              }
          }); 
    }

    //====处理反馈完成后弹出提示====
    var handlePromptTime;
    function handlePrompt(val) {
        $("body").append("<div class='handlePrompt' >" + val + "</div>");
        clearTimeout(handlePromptTime);
        handlePromptTime = setTimeout(function () {
            $(".handlePrompt").remove();
        }, 2000);
    }


    //验证手机发送验证码
    function CheckMobileVerification() {
        var username = $("#MobilePhone").val();
        var pwd = $("#MobilePhonePwd").val();
        var cheak = $("#MobilePhoneCheak").val();
        var nickname = $("#nickname").val();
        if (username == undefined || username == "") {
            alert('请输入手机号');
            return;
        }
        var phonereg = /^1[3|4|5|7|8][0-9]\d{8}$/;
        if (!phonereg.test(username)) {
            alert('请输入正确的手机号');
            return;
        }

        if (pwd == undefined || pwd == "") {
            alert('请输入密码');
            return;
        }

        var pwdreg = /^[a-zA-Z0-9\_]{6,25}$/;
        if (!pwdreg.test(pwd)) {
            alert('输入有误，密码必须为6-20位字母、数字组合,特殊字符只包含_');
            return;
        }

        if ((cheak == undefined || cheak == "")) {
            alert('请输入短信确认码');
            return;
        }
        if ((nickname == undefined || nickname == "")) {
            alert('请输入您的昵称');
            return;
        }
   
        var sendData = {
                "accLogin" : username,
                "accName":nickname,
                "accPass": pwd,
                "vcode" : cheak
            };
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/account/insert.action",
            dataType:'json',
            data: JSON.stringify(sendData),
            contentType :'application/json',
            success: function(data){
            	//alert(JSON.stringify(data));
            	if(data.isabnormal==1){
            		handlePrompt("注册成功！");
               	    setTimeout(function(){window.location.href = "${pageContext.request.contextPath}/login.jsp";}, 2000);
            	}else{
                    if(data.isabnormal==2)
                 	   handlePrompt("手机号已被注册！");
                    if(data.isabnormal==3)
                  	   handlePrompt("验证码过期或者不正确！");
                    if(data.isabnormal==4)
                 	   handlePrompt("验证码过期或者不正确！");
                    if(data.isabnormal==5)
                   	   handlePrompt("服务器出错，请检查网络并重试！");
                    return false;
            	} 
             }
         }); 

    }

    //切换验证码状态
    function SwitchingCheak() {
        var $mobileCheak = $(".log_reg_item a .mobileCheak");
        var $getCheakBtn = $(".log_reg_item a .mobileCheak .text");
        var $countdownBtn = $(".log_reg_item a .mobileCheak .countdown");
        var $countdownBtnNum = $(".log_reg_item a .mobileCheak .countdown .num");

        if (!$mobileCheak.hasClass("hover")) {
            $mobileCheak.addClass("hover");
            var num = 60;
            var t;
            var time = setInterval(function () {
                if (num == 0) {
                    clearInterval(time);
                    $mobileCheak.removeClass("hover");
                    $countdownBtnNum.text("60s");
                } else {
                    num--;
                    t = num + "s";
                    $countdownBtnNum.text(t);
                }
            }, 1000);

        }
    }

    $(function () {
        //切换输入密码明暗文
        $password = $('#MobilePhonePwd');
        $show_hide_pass = $('.log_reg_item a .show_hide_pass');
        $show_hide_pass.click(function (event) {
            $(this).hasClass("icon_invisible") ? ($(this).removeClass("icon_invisible").addClass("icon_visible"),
             $password.attr("type", "text")) : $(this).hasClass("icon_visible") && ($(this).removeClass("icon_visible").addClass("icon_invisible"),
             $password.attr("type", "password"));
        });
    })
    $(function () {
        $("body").css("min-height", $(window).height() - 30);
    })
    
</script>

</body></html>