<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/11/8
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
    </script>

    <style type="text/css">

        #input_1{
            border: 1px solid #1E9FFF;
        }

        #input_2{
            border: 1px solid #1E9FFF;
            margin-top: 5px;
        }
    </style>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
        <div id="cloud1" class="cloud"></div>
        <div id="cloud2" class="cloud"></div>
    </div>


    <div class="logintop">
        <span>欢迎登录学生管理平台</span>
        <ul>
            <li><a href="#">帮助</a></li>
            <li><a href="#">关于</a></li>
        </ul>
    </div>

    <div class="loginbody">

        <span class="systemlogo"></span>

        <div class="loginbox">
            <div class="login-left"></div>
            <div class="login-right">
                <div style="font-size: 18px">
                    <c:if test="${param.rtype==-1}">
                        <p style="color:red;">登录失败!请检查账号、密码是否正确！</p>
                    </c:if>
                </div>
                <form id="myform" method="post" action="${pageContext.request.contextPath}/userAction/doLogin">
                    <input id="input_1" class="input2" onfocus="clearTips()" name="uname" placeholder="账户"/><br/>
                    <input id="input_2" class="input2" onfocus="clearTips()" name="upwd" type="password" placeholder="密码"/><br/>
                    <span id="mySpan" style="color:red;"></span><br/>
                    <input type="button" class="input2" value="登录"/>
                </form>
                还没账号？点这里：<a href="${pageContext.request.contextPath}/pages/register.jsp" style="color: #1E9FFF;">注册</a>
            </div>
        </div>
    </div>
    <div class="loginbm">博学笃志，德才兼备</div>
</body>
<script type="text/javascript">

    $("input[type='button']").click(function(){
        if(!$("input[name='uname']").val() || !$("input[name='upwd']").val()){
            $("#mySpan").text("账号或密码不能为空");
        }else{
            var param=$("#myform").serialize();
            $.post("userAction/doLogin",param,function(data){
                if(data){
                    location.href="pages/main.jsp";
                }else{
                    $("#mySpan").text("用户名或密码错误");
                }
            });
        }
    });
    function clearTips(){
        $("#mySpan").text("");
    }

    //注册成功则弹框
    <c:if test="${param.rtype==1}">
        alert("注册成功");
    </c:if>

    $(document).keyup(function(event){
        if(event.keyCode == 13){
            //模拟点击登陆按钮，触发上面的 Click 事件
            $("input[type='button']").click();
        }
    });

</script>
</html>
