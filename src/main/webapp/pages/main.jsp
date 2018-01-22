<%--
  Created by IntelliJ IDEA.
  User: hjk
  Date: 2017/11/8
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生管理系统</title>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
        }
        #myiframe{
            width: 1150px;
            border-radius: 5px;
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">关于学校</a></li>
            <li class="layui-nav-item"><a href="">公告</a></li>
            <li class="layui-nav-item"><a href="">我的异议</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它</a>
                <dl class="layui-nav-child">
                    <dd><a href="">用户管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${param.uname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index.jsp">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;toAddStu();">学生录入</a></dd>
                        <dd><a href="javascript:;toStuInfo();">学生管理</a></dd>
                        <dd><a href="javascript:;toAddCls();">添加班级</a></dd>
                        <dd><a href="javascript:;toClassInfo();">班级管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">教务中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;toGrade();">成绩管理</a></dd>
                        <dd><a href="javascript:;toAddGrade();">添加成绩</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">其他</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;toReward();">奖励管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe id="myiframe" src="Context.jsp" style="width: 100%;height: 100%;"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });

    //跳转到学生录入页面
    function toAddStu(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/stuAction/findClsList");
    }
    //跳转到学生信息页面
    function toStuInfo(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/StuInfo.jsp");
    }
    //跳转到班级录入页面
    function toAddCls(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/AddCls.jsp");
    }
    //跳转到班级信息页面
    function toClassInfo(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/ClassInfo.jsp");
    }

    //跳转到成绩管理页面
    function toGrade(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/Grade.jsp");
    }

    //跳转到添加成绩页面
    function toAddGrade(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/gradeAction/findStuList");
    }

    //跳转到奖励页面
    function toReward(){
        $("#myiframe").attr("src","${pageContext.request.contextPath}/pages/Reward.jsp");
    }

</script>
</body>
</html>