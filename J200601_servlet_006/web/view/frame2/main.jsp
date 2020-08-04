<%--
  Created by IntelliJ IDEA.
  User: zhulingfeng
  Date: 2020/7/29
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>主页面</h1>
    <font color="red">${message}</font>
    <hr>
</div>
欢迎您,<p style="color: red;display: inline-block" >${username}</p>
<%--<a href="<%=basePath%>view/system/user/userList.jsp">用户管理</a><br>--%>
<a href="<%=basePath%>userController.do?method=list">用户管理</a><br>
<a href="<%=basePath%>roleController.do?method=list">角色管理</a><br>
<a href="<%=basePath%>permissionController.do?method=list">权限管理</a><br>
</body>
</html>
