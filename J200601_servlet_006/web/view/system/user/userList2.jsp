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
    <%--  删除用户  --%>
    <script>
        function deleteUser(userIdSTR) {
            //刪除数据安全判定
            if (confirm("你确定要删除数据吗？")) {
                //请求路径
                location.href = "<%=basePath%>userController.do?method=delete&userIdSTR=" + userIdSTR;
            }
        }
    </script>
</head>
<body>
<div align="center">
    <h1>用户列表</h1>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
        href="<%=basePath%>view/system/user/addUser.jsp">增加</a>&nbsp;&nbsp;<a href="#">批量删除</a>&nbsp;&nbsp;
姓名<input type="text" name="">地址<input type="text" name=""><input type="button" value="查询">
<hr>
<div align="center">
    <table width="80%" border="1">
        <tr>
            <td><input type="checkbox" id="tableHeadCheckBox"></td>
            <td>用户ID</td>
            <td>姓名</td>
            <td>性别</td>
            <td>地址</td>
            <td>电话</td>
            <td>登录名</td>
            <td>密码</td>
            <td colspan="3">操作</td>
        </tr>
        <c:forEach items="${userList_db}" var="user">
            <tr>
                <td><input type="checkbox" name="userIdTRs" value="${user.userId}"></td>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.adress}</td>
                <td>${user.tel}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td><a href="<%=basePath%>userController.do?method=updateUI&userIdSTR=${user.userId}">修改</a></td>
                    <%--                <td><a href="<%=basePath%>userController.do?method=delete&userIdSTR=${user.userId}">删除</a></td>--%>
                <td><a href="javascript:deleteUser(${user.userId})">刪除</a></td>
                <td><a href="<%=basePath%>roleController.do?method=FPRoleUI&userIdSTR=${user.userId}">分配角色</a></td>
            </tr>
        </c:forEach>

    </table>
    <p>&nbsp;</p>
    <input type="button" value="首页">
    <input type="button" value="下一页">
    <input type="button" value="1">
    <input type="button" value="2">
    <input type="button" value="3">
    <input type="button" value="4">
    <input type="button" value="5">
    <input type="button" value="6">
    <input type="button" value="7">
    <input type="button" value="8">
    <input type="button" value="9">
    <input type="button" value="10">
    <input type="button" value="上一页">
    <input type="button" value="尾页">
</div>
</body>
</html>
