<%--
  Created by IntelliJ IDEA.
  permission: zhulingfeng
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, permission-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>resource/css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>resource/css/admin.css">
    <script src="<%=basePath%>resource/js/jquery.js"></script>
    <script src="<%=basePath%>resource/js/pintuer.js"></script>
    <%--  删除用户  --%>
    <script>
        function deletepermission(permissionIdSTR) {
            //刪除数据安全判定
            if (confirm("你确定要删除数据吗？")) {
                //请求路径
                location.href = "<%=basePath%>permissionController.do?method=delete&permissionIdSTR=" + permissionIdSTR;
            }
        }
    </script>
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
        <div class="padding border-bottom">
            <ul class="search">
                <li>
                    <button type="button" class="button border-green" id="checkall"><span class="icon-check"></span> 全选
                    </button>
                    <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
<%--                    <a href="<%=basePath%>view/system/permission/addPermission.jsp" class="button border-red"><span class="icon-trash-o"></span> 增加</a>--%>
                    <a href="<%=basePath%>permissionController.do?method=addUI" class="button border-red"><span class="icon-trash-o"></span> 增加</a>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th><input type="checkbox" id="tableHeadCheckBox"></th>
                <th>权限ID</th>
                <th>父ID</th>
                <th>名称</th>
                <th>类型</th>
                <th>url</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${permissionList_db}" var="permission">
                <tr>
                    <td><input type="checkbox" name="permissionIdTRs" value="${permission.permissionId}"></td>
                    <td>${permission.permissionId}</td>
                    <td>${permission.pId}</td>
                    <td>${permission.name}</td>
                    <td>${permission.type}</td>
                    <td>${permission.url}</td>
                    <td>${permission.state}</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-red" href="<%=basePath%>permissionController.do?method=updateUI&permissionIdSTR=${permission.permissionId}"><span class="icon-trash-o"></span> 修改</a>
                            <a class="button border-blue" href="javascript:deletepermission(${permission.permissionId})"><span class="icon-trash-o"></span> 刪除</a>
                            <a class="button border-red" href="<%=basePath%>roleController.do?method=FPRoleUI&permissionIdSTR=${permission.permissionId}"><span class="icon-trash-o"></span> 分配权限</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="11">
                    <div class="pagelist"><a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
                            href="">3</a><a href="">下一页</a><a href="">尾页</a></div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">

    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>