<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/12/17
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <h2>成绩管理</h2>
    <div id="msg"></div>
    <table id="mytb" border="1">
        <table id="gradeTab" border="1" width="500" style="text-align: center;">
            <tr>
                <td>编号</td><td>姓名</td><td>语文</td><td>数学</td><td>英语</td>
                <td>物理</td><td>化学</td><td>生物</td><td>总分</td>
            </tr>

            <c:forEach items="${gradeList}" var="g" varStatus="ids">
                <tr>
                    <td>${ids.count}</td><td>${g[1].sname}</td><td>${g[0].gchinese}</td><td>${g[0].gmath}</td>
                    <td>${g[0].genglish}</td><td>${g[0].gphysical}</td><td>${g[0].pchemistry}</td><td>${g[0].pbiology}</td>
                    <td>${g[0].gchinese+g[0].gmath+g[0].genglish+g[0].gphysical+g[0].pchemistry+g[0].pbiology}</td>
                </tr>
            </c:forEach>

        </table>

    </table>
</body>
</html>
