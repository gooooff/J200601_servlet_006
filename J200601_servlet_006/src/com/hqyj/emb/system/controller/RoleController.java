package com.hqyj.emb.system.controller;

import com.hqyj.emb.system.model.Role;
import com.hqyj.emb.system.model.Role;
import com.hqyj.emb.system.model.User;
import com.hqyj.emb.system.model.UserRole;
import frame.controller.BaseController2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/roleController.do")
public class RoleController extends BaseController2 {
    public String list(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        //3.调用业务
        List<Role> roleList_db = roleService.queryAllRole();
//        for (Role role : roleList_db) {
//            System.out.println("--------------list()---------------" + role);
//        }
        //设置返回数据到前台页面
        System.out.println("roleList_db"+roleList_db);
        req.setAttribute("roleList_db", roleList_db);
        //2.跳转页面
        return "view/system/role/roleList.jsp";
    }
    public String add(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        String state = req.getParameter("state");
        Role role = new Role();
        role.setName(name);
        role.setState(state);
        int n = roleService.addRoleByRole(role);
        List<Role> roleList_db = roleService.queryAllRole();
        req.setAttribute("roleList_db", roleList_db);
        return "view/system/role/roleList.jsp";
    }
    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String roleIdSTR = req.getParameter("roleIdSTR");
        //字符类型转成数字类型
        int roleId = Integer.parseInt(roleIdSTR);
        System.out.println("------------" + roleId);
        //3.调用业务
        int n = roleService.deleteRoleByRoleId(roleId);
        //##########################
        //返回所有數據
        List<Role> roleList_db = roleService.queryAllRole();
        req.setAttribute("roleList_db", roleList_db);

        //2.跳转页面
        return "view/system/role/roleList.jsp";
    }
    public String updateUI(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String roleIdSTR = req.getParameter("roleIdSTR");
        //字符类型转成数字类型
        int roleId = Integer.parseInt(roleIdSTR);

        //3.调用业务
        Role role_db = roleService.queryByRoleID(roleId);
        System.out.println("------------" + role_db);
        req.setAttribute("role_db", role_db);

        //2.跳转页面
        return "view/system/role/updateRole.jsp";
    }
    public String update2(HttpServletRequest req, HttpServletResponse resp){
        String roleIdStr = req.getParameter("roleIdStr");
        int roleId = Integer.parseInt(roleIdStr);
        System.out.println("roleId:"+roleId);
        Role role_db= roleService.queryByRoleID(roleId);
        String name = req.getParameter("name");
        String state = req.getParameter("state");

        //封裝
        Role role = new Role();
        role.setRoleId(roleId);
        role.setName(name);
        role.setState(state);

        int n = roleService.updateRole(role);
        return "view/system/role/roleList.jsp";
    }
    public String update(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String roleIdSTR = req.getParameter("roleIdSTR");
        //字符类型转成数字类型
        int roleId = Integer.parseInt(roleIdSTR);

        String name = req.getParameter("name");
        String state = req.getParameter("state");

        //封裝
        Role role = new Role();
        role.setRoleId(roleId);
        role.setName(name);
        role.setState(state);

        //3.调用业务
        int n = roleService.updateRole(role);

        //##########################
        //返回所有數據
        List<Role> roleList_db = roleService.queryAllRole();
        //设置返回数据到前台页面
        req.setAttribute("roleList_db", roleList_db);
        //2.跳转页面
        return "view/system/role/roleList.jsp";
    }
    public String FPRole(HttpServletRequest req, HttpServletResponse resp){
        String userIdStr = req.getParameter("userIdStr");
        int userId = Integer.parseInt(userIdStr);
        System.out.println("userId:"+userId);
        String roleIdStr = req.getParameter("roleIdStr");
        int roleId = Integer.parseInt(roleIdStr);
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        int m = roleService.deleteUserRoleByUserId(userId);
        int n = roleService.addUserRoleByUserRole(userRole);
        User user_db = userService.queryByUserID(userId);
        //b.角色对象列表
        List<Role> roleList_db = roleService.queryAllRole();


        //d.选中数据
        Role role_db_XZ = roleService.queryRoleByUserId(userId);
        req.setAttribute("role_db_XZ", role_db_XZ);

        //设置返回数据到前台页面
        req.setAttribute("user_db", user_db);
        req.setAttribute("roleList_db", roleList_db);
        return "view/system/role/FPRole.jsp";
    }
    public String FPRoleUI(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String userIdSTR = req.getParameter("userIdSTR");
        //字符类型转成数字类型
        int userId = Integer.parseInt(userIdSTR);
        System.out.println("---------FPRoleUI---------" + userId);

        //3.调用业务
        //a.用户数据
        User user_db = userService.queryByUserID(userId);
        //b.角色对象列表
        List<Role> roleList_db = roleService.queryAllRole();


        //d.选中数据
        Role role_db_XZ = roleService.queryRoleByUserId(userId);
        req.setAttribute("role_db_XZ", role_db_XZ);

        //设置返回数据到前台页面
        req.setAttribute("user_db", user_db);
        req.setAttribute("roleList_db", roleList_db);

        //2.跳转页面
        return "view/system/role/FPRole.jsp";
    }
}
