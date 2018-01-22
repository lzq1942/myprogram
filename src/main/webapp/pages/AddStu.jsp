<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/24
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h2>添加学生</h2>
<div id="msg"></div>
    <c:if test="${param.stype==1}">
        <div style="color: green;">添加学生成功！</div>
    </c:if>
    <c:if test="${param.stype==2}">
        <div style="color: green">添加学生失败！</div>
    </c:if>
    <fmt:formatDate var="intime"  value="${backStu.stime}" pattern="yyyy-MM-dd"/>
    <form id="myform" action="${pageContext.request.contextPath}/stuAction/addStu" method="post" enctype="multipart/form-data">
        学生姓名：<input name="sname" /><br/>
        学生年龄：<input name="sage" /><br />
        学生性别：<input type="radio" name="ssex" value="男" checked />男
        <input type="radio" name="ssex" value="女" />女<br />
        入学时间：<input name="stime" /><br />
        电话号码：<input name="sphone"/><br />
        选择图片：<input type="file" name="sfile"/><br/>

        <input type="submit" value="添加学生">
    </form>
</body>
</html>
<script>
    var select = document.getElementsByName("cno");
    //绑定班级
    for(var i = 0; i < select[0].options.length; i ++){
        var p = select[0].options[i];
        if(p.value == "${cls.cno}"){
            p.selected = true;
            break;
        }
    }
</script>
