<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/11/6
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
            background-color: skyblue;
        }
        #register{
            width: 420px;
            height: 400px;
            margin: 0 auto;
            margin-top: 10%;
            background-color: #d5ebf3;
            border-radius: 5px;
            text-align: center;
        }
        #login_top{
            height: 50px;
            font-size: 32px;
            color: #1499F7;
            padding: 20px;
        }
        #login_input input{
            width: 75%;
            height: 40px;
            margin-top: 10px;
            margin-bottom: 5px;
            border-radius:3px;
            border:1px;
            padding-left:5px;
        }

        .button_style{
            background-color: #1499F7;color:#ffffff;font-size: 20px;
        }
    </style>
</head>
<body>

    <div id="register">
        <div id="login_top">学生管理系统</div>
        <div id="login_input">
            <form action="${pageContext.request.contextPath}/userAction/RegisterUser" method="post">
                <input onfocus="clearTips()" type="text" name="uname" placeholder="账号"><br/>
                <input onfocus="clearTips()" type="password" name="upwd" placeholder="密码"><br/>
                <input onfocus="clearTips()" type="password" name="qupwds" placeholder="密码"><br/>
                <span id="mySpan" style="color:red;"></span><br/>
                <input type="submit" value="注册" class="button_style"><br/>
            </form>
            <div style="font-size: 18px">
                <c:if test="${param.rtype==-1}">
                    <p style="color:red;">注册失败!</p>
                </c:if>
            </div>
            如果您已经注册，请点击<a href="${pageContext.request.contextPath}/index.jsp">登录</a>。
        </div>
    </div>

</body>
<script type="text/javascript">
    $("input[type='submit']").click(function(){
        var name = $("input[name='uname']").val();
        var pwd = $("input[name='upwd']").val();
        var qpwd = $("input[name='qupwds']").val();
        if(name == null || name.length <= 0 || pwd == null || pwd.length <= 0){
            $("#mySpan").text("账号或者密码不能为空！");
            return false;
        }else if(pwd != qpwd){
            $("#mySpan").text("两次密码不一致！");
            return false;
        }else{
            if(name.length < 1 || name.length > 20){
                $("#mySpan").text("用户名必须在1~20位之间");
                return false;
            }
            //使用正则表达式验证密码长度
            var reg=/^.{6,20}$/;
            if(!reg.test(pwd)){
                $("#mySpan").text("密码必须在6~20位之间");
                return false;
            }
//            if(pwd.length < 6 || pwd.length > 12){
//                $("#mySpan").text("密码必须在6~12位之间");
//                return false;
//            }
        }
        //return true;
    });
    function clearTips(){
        $("#mySpan").text("");
    }

    <c:if test="${param.rtype==-1}">
    alert("注册失败");
    </c:if>
</script>
</html>