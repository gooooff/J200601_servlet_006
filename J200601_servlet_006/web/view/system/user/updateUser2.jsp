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
    <h1>修改用户</h1>
    <hr>
    <form action="<%=basePath%>userController.do?method=update" method="post">
        <input type="hidden" name="userIdSTR" value=${user_db.userId}>
        <table>

            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" value="${user_db.name}"></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <c:if test="${user_db.sex=='男'}">
                        <input type="radio" name="sex" value="男" checked="checked">男
                        <input type="radio" name="sex" value="女">女
                    </c:if>
                    <c:if test="${user_db.sex=='女'}">
                        <input type="radio" name="sex" value="男">男
                        <input type="radio" name="sex" value="女" checked="checked">女
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="adress" value="${user_db.adress}"></td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><input type="text" name="tel" value="${user_db.tel}"></td>
            </tr>
            <tr>
                <td>登录名：</td>
                <td><input type="text" name="userName" value="${user_db.userName}"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password" value="${user_db.password}"></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"></td>
                <td><input type="submit" value="修改"></td>
            </tr>
        </table>

    </form>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a

</body>
</html>
