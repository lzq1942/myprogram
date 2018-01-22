<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/17 0017
  Time: 上午 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h2>修改学生</h2>
<div id="msg"></div>
<form action="${pageContext.request.contextPath}/stuAction/updateStu" method="post" enctype="multipart/form-data">
              <input type="hidden" name="sno" value="${stu.sno}">
    学生姓名：<input name="sname" value="${stu.sname}" /><br />
    学生年龄：<input name="sage" value="${stu.sage}" /><br />
    学生性别：<input type="radio" name="ssex"/>男
              <input type="radio" name="ssex"/>女<br />
              <img border="1" src="${pageContext.request.contextPath}/images/${stu.simage}" width="100" height="100" /><br />
              <input type="hidden" name="simage" value="${stu.simage}" />
    学生图像：<input type="file" name="sfile"><br />
    入学时间：<input name="stime" value="${stu.stime.toString().substring(0,10)}" /><br />
    选择班级：<select name="cls.cno">
                <option value="">请选择班级</option>
                <c:forEach items="${requestScope.clsList}" var="o" varStatus="ids">
                    <option value="${o.cno}">${o.cname}</option>
                </c:forEach>
              </select><br />
              <input type="submit" value="修改学生">
</form>
<a href="${pageContext.request.contextPath}/pages/StuInfo.jsp">学生列表</a>
</body>
</html>
<script>
    var sex = document.getElementsByName("ssex");
    var select = document.getElementsByName("cls.cno");
    //绑定性别
    console.log("${stu.ssex}")
    "${stus.ssex}" == "男" ? sex[0].checked = true : sex[1].checked = true;

    //绑定班级
    for(var i = 0; i < select[0].options.length; i ++){
        var p = select[0].options[i];
        if(p.value == "${stu.cls.cno}"){
            p.selected = true;
            break;
        }
    }
</script>