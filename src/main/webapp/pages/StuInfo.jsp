<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/13
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h2>学生信息</h2>
<div id="msg"></div>
<table id="mytb" border="1">
    <table id="stuTab" border="1" width="500" style="text-align: center;">
    <tr>
        <td>编号</td><td>头像</td><td>姓名</td><td>年龄</td><td>性别</td>
        <td>电话</td><td>管理</td>
    </tr>

    </table>

</table>
</body>
</html>
<script type="text/javascript">
    function loadData() {
        $("#stuTab tr:not(:first)").remove();
        $.post("${pageContext.request.contextPath}/stuAction/findStuList", null, function (data) {
            console.log(data);
            if (!(data && data.length > 0)) {
            } else {
                $.each(data, function (i, v) {
                    var tr = "<tr><td>" + (i + 1) + "</td>" +
                        "<td><input type='image' src='${pageContext.request.contextPath}/images/" + v[0].simage + "' width='100' height='100'></td>" +
                        "<td>" + v[0].sname + "</td><td>" + v[0].sage + "</td><td>" + v[0].ssex + "</td><td>" + v[0].sphone + "</td>" +
                        "<td><a href='${pageContext.request.contextPath}/stuAction/getStuById/" + v[0].sno + "'>修改</a> | <a href='javascript:;' onclick = 'deleteStu(" + v[0].sno + ")'>删除</a></td></tr>";
                    $("#stuTab").append(tr);
                });
            }
        }, "json");
    }
    window.onload = loadData;

    function deleteStu(sno) {
        $.post("${pageContext.request.contextPath}/stuAction/deleteStu", "sno=" + sno, function (data) {

            if (data && data == true) {
                loadData();
                $("#msg").html("删除成功！").css("color","green");
            }else{
                $("#msg").html("删除失败！").css("color","red");
            }
        }, "json");
    }

</script>
