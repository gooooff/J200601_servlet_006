package com.hqyj.emb.system.controller;

import com.hqyj.emb.system.model.Permission;
import com.hqyj.emb.system.model.Permission;
import frame.controller.BaseController2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(value = "/permissionController.do")
public class PermissionController extends BaseController2 {
    public String list(HttpServletRequest req, HttpServletResponse resp) {

        List<Permission> permissionList_db = permissionService.queryAllPermission();

        req.setAttribute("permissionList_db", permissionList_db);
        return "view/system/permission/permissionList.jsp";
    }
    public String addUI(HttpServletRequest req, HttpServletResponse resp) {
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        req.setAttribute("permissionList_db", permissionList_db);

        return "view/system/permission/addPermission.jsp";
    }
    public String add(HttpServletRequest req, HttpServletResponse resp) {

        //1.接受数据
        String pIdSTR = req.getParameter("pIdSTR");
        int pId = Integer.parseInt(pIdSTR);
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String url = req.getParameter("url");
        String state = req.getParameter("state");

        //封裝
        Permission permission = new Permission();
        permission.setName(name);
        permission.setpId(pId);
        permission.setState(state);
        permission.setUrl(url);
        permission.setType(type);
        System.out.println(permission);

        //3.调用业务
        int n = permissionService.addPermissionByPermission(permission);


        //##########################
        //返回所有數據
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        req.setAttribute("permissionList_db", permissionList_db);

        //2.跳转页面
        return "view/system/permission/permissionList.jsp";
    }
    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String permissionIdSTR = req.getParameter("permissionIdSTR");
        //字符类型转成数字类型
        int permissionId = Integer.parseInt(permissionIdSTR);
//        System.out.println("------------" + permissionId);
        //3.调用业务
        int n = permissionService.deletePermissionByPermissionId(permissionId);

        //##########################
        //返回所有數據
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        //设置返回数据到前台页面
        req.setAttribute("permissionList_db", permissionList_db);
        //2.跳转页面
        return "view/system/permission/permissionList.jsp";
    }


    public String updateUI(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String permissionIdSTR = req.getParameter("permissionIdSTR");
        //字符类型转成数字类型
        int permissionId = Integer.parseInt(permissionIdSTR);

        //3.调用业务
        Permission permission_db = permissionService.queryPermissionByPermissionId(permissionId);
        System.out.println("------------" + permission_db);
        req.setAttribute("permission_db", permission_db);


        //a.准备父级节点数据
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        req.setAttribute("permissionList_db", permissionList_db);

        //2.跳转页面
        return "view/system/permission/updatePermission.jsp";
    }
    public String update(HttpServletRequest req, HttpServletResponse resp) {
        String permissionIdSTR = req.getParameter("permissionIdSTR");
        //字符类型转成数字类型
        int permissionId = Integer.parseInt(permissionIdSTR);
        String pIdSTR = req.getParameter("pIdSTR");
        //字符类型转成数字类型
        int pId = Integer.parseInt(pIdSTR);
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String url = req.getParameter("url");
        String state = req.getParameter("state");

        //封裝
        Permission permission = new Permission();
        permission.setPermissionId(permissionId);
        permission.setName(name);
        permission.setpId(pId);
        permission.setState(state);
        permission.setUrl(url);
        permission.setType(type);
        System.out.println("ppppppppppppppppp"+permission);

        int n = permissionService.updatePermission(permission);
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        req.setAttribute("permissionList_db", permissionList_db);

        return "view/system/permission/permissionList.jsp";
    }
}
