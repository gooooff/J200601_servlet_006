<%--
  Created by IntelliJ IDEA.
  role: zhulingfeng
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
    <h1>分配角色</h1>
</div>
分配角色用户：<font color="red">${user_db.name}</font>&nbsp;${message}
<hr>
<form action="<%=basePath%>roleController.do?method=FPRole" method="post">
    <input type="hidden" name="userIdStr" value="${user_db.userId}">
    <c:forEach items="${roleList_db}" var="role">
        <input type="radio" name="roleIdStr" value="${role.roleId}" <c:if test="${role.roleId==role_db_XZ.roleId}">checked="checked"</c:if>>${role.name}
    </c:forEach>
    <p>&nbsp;</p>
    <input type="submit" value="分配角色">
</form>
</body>
</html>
