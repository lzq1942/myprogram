<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/21 0021
  Time: 下午 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>添加成绩页面</h2>
<c:if test="${param.gtype==1}">
    <div style="color: green;">添加学生成功！</div>
</c:if>
<c:if test="${param.gtype==2}">
    <div style="color: green">添加学生失败！</div>
</c:if>
<form id="myform" action="${pageContext.request.contextPath}/gradeAction/addGrade" method="post">
    学生名字：<select name="stu.sno">
                <option value="">请选择学生</option>
                <c:forEach items="${requestScope.stuList}" var="s" varStatus="ids">
                    <option value="${s[0].sno}">${s[0].sname}</option>
                </c:forEach>
              </select>
    <br />
    语文成绩：<input name="gchinese"/><br/>
    数学成绩：<input name="gmath"/><br/>
    英语成绩：<input name="genglish"/><br/>
    物理成绩：<input name="gphysical"/><br/>
    化学成绩：<input name="pchemistry"/><br/>
    生物成绩：<input name="pbiology"/><br/>

    <input type="submit" value="添加成绩"/>
</form>
</body>
</html>
<script>
    var selectstu = document.getElementsByName("sno");

    //绑定学生
    for(var i = 0; i < selectstu[0].options.length; i ++){
        var p = selectstu[0].options[i];
        if(p.value == "${stu.sno}"){
            p.selected = true;
            break;
        }
    }


</script>