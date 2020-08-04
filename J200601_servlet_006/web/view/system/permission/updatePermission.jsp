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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>resource/css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>resource/css/admin.css">
    <script src="<%=basePath%>resource/js/jquery.js"></script>
    <script src="<%=basePath%>resource/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=basePath%>permissionController.do?method=update">
            <input type="hidden" name="permissionIdSTR" value="${permission_db.permissionId}">
            <div class="form-group">
                <div class="label">
                    <label>父级：</label>
                </div>
                <div class="field">
                    <select name="pIdSTR">
                        <option>------请选择父级节点------</option>
                        <c:forEach items="${permissionList_db}" var="permission">
                            <c:if test="${permission.permissionId == permission_db.pId }">
                                <option value="${permission.permissionId}"
                                        selected="selected">${permission.name}</option>
                            </c:if>
                            <c:if test="${permission.permissionId != permission_db.pId }">
                                <option value="${permission.permissionId}">${permission.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${permission_db.name}" name="name"
                           data-validate="required:请输入名称"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>类型：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${permission_db.type}" name="type"
                           data-validate="required:请输入类型"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>url：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${permission_db.url}" name="url"
                           data-validate="required:请输入url"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>状态：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${permission_db.state}" name="state"
                           data-validate="required:请输入状态"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input class="button bg-main icon-check-square-o" type="submit" value="提交">
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>