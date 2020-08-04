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
    <%--  删除用户  --%>
    <script>
        function deleteRole(roleIdSTR) {
            //刪除数据安全判定
            if (confirm("你确定要删除数据吗？")) {
                //请求路径
                location.href = "<%=basePath%>roleController.do?method=delete&roleIdSTR=" + roleIdSTR;
            }
        }
    </script>
</head>
<body>
<div align="center">
    <h1>角色列表</h1>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>view/system/role/addRole.jsp">增加</a>&nbsp;&nbsp;<a href="#">批量删除</a>&nbsp;&nbsp;
姓名<input type="text" name="">地址<input type="text" name=""><input type="button" value="查询">
<hr>
<div align="center">
    <table width="80%" border="1">
        <tr>
            <td><input type="checkbox" id="tableHeadCheckBox"></td>
            <td>用户ID</td>
            <td>名称</td>
            <td>状态</td>
            <td colspan="3">操作</td>
        </tr>
        <c:forEach items="${roleList_db}" var="role">
            <tr>
                <td><input type="checkbox" name="roleIdTRs" value="${role.roleId}"></td>
                <td>${role.roleId}</td>
                <td>${role.name}</td>
                <td>${role.state}</td>
                <td><a href="<%=basePath%>roleController.do?method=updateUI&roleIdSTR=${role.roleId}">修改</a></td>
                    <%--                <td><a href="<%=basePath%>roleController.do?method=delete&roleIdSTR=${role.roleId}">删除</a></td>--%>
                <td><a href="javascript:deleteRole(${role.roleId})">刪除</a></td>
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
