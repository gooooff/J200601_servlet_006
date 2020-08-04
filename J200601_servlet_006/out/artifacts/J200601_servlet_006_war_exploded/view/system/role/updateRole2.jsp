<%--
  Created by IntelliJ IDEA.
  User: zhulingfeng
  Date: 2020/7/29
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>修改角色</h1>
    <hr>
    <form action="<%=basePath%>roleController.do?method=update" method="post">
        <input type="hidden" name="roleIdSTR" value="${role_db.roleId}">
        <table>

            <tr>
                <td>名称：</td>
                <td><input type="text" name="name" value="${role_db.name}"></td>
            </tr>
            <tr>
                <td>状态：</td>
                <td><input type="text" name="state" value="${role_db.state}"></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"></td>
                <td><input type="submit" value="增加"></td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
