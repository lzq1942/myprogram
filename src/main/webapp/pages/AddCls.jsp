<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/24
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AddCls</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>添加班级</h2>

<c:if test="${ctype==1}">
    <div id="msg" style="color:green;"></div>
</c:if>
<c:if test="${ctype==-1}">
    <div id="msg" style="color:red;"></div>
</c:if>
<form id="addForm"  action="" onsubmit="return false">
    班级名称：<input name="cname" />
    <!--<input type="button" value="添加班级">-->
    <button type="button" class="btn btn-primary" onclick="addCls()">添加班级</button>
</form>
<a href="${pageContext.request.contextPath}/pages/ClassInfo.jsp">班级列表</a>
</body>
</html>
<script type="text/javascript">
    function addCls(){
        var param = $("#addForm").serialize();
        $.post("${pageContext.request.contextPath}/clsAction/addCls", param, function (data) {
            if(data=="1"){
                $("#addForm")[0].reset();
                alert("添加班级成功!");
            }else{
                alert("添加班级失败!");
            }
        },"json");
    }
</script>