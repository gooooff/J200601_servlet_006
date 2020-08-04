package com.hqyj.emb.system.controller;

import com.hqyj.emb.system.model.User;
import frame.controller.BaseController2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>用户</p>
 *
 * @author : zlf
 * @date : 2020-07-30 11:20
 **/
@WebServlet("/userController.do")
public class UserController extends BaseController2 {
    /**
     * @Description:列表
     * @return: java.lang.String
     * @Author: zlf
     * @Date: 2020/7/31 10:36
     */
    public String list(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        //3.调用业务
        List<User> userList_db = userService.queryAllUser();
//        for (User user : userList_db) {
//            System.out.println("--------------list()---------------" + user);
//        }
        //设置返回数据到前台页面
        req.setAttribute("userList_db", userList_db);
        //2.跳转页面
        return "view/system/user/userList.jsp";
    }

    /**
     * @Description:增加
     * @return: java.lang.String
     * @Author: zlf
     * @Date: 2020/7/31 10:37
     */
    public String add(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String adress = req.getParameter("adress");
        String tel = req.getParameter("tel");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        //封裝
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setAdress(adress);
        user.setTel(tel);
        user.setUserName(userName);
        user.setPassword(password);
        System.out.println(user);

        //3.调用业务
        int n = userService.addUserByUser(user);


        //##########################
        //返回所有數據
        List<User> userList_db = userService.queryAllUser();
        req.setAttribute("userList_db", userList_db);

        //2.跳转页面
        return "view/system/user/userList.jsp";
    }

    /**
     * @Description: 刪除
     * @return: java.lang.String
     * @Author: zlf
     * @Date: 2020/7/31 11:03
     */
    public String delete(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
        String userIdSTR = req.getParameter("userIdSTR");
        //字符类型转成数字类型
        int userId = Integer.parseInt(userIdSTR);
        System.out.println("------------" + userId);
        //3.调用业务
        int n = userService.deleteUserByUserId(userId);
        //##########################
        //返回所有數據
        List<User> userList_db = userService.queryAllUser();
        req.setAttribute("userList_db", userList_db);

        //2.跳转页面
        return "view/system/user/userList.jsp";
    }
    public String queryUserByUserId(HttpServletRequest req, HttpServletResponse resp){
        String userIdStr = req.getParameter("userIdStr");
        int userId = Integer.parseInt(userIdStr);
        User user_db= userService.queryByUserID(userId);
        System.out.println(user_db);
        req.setAttribute("user_db", user_db);
        return "view/system/user/updateUser.jsp";
    }
    public String update(HttpServletRequest req, HttpServletResponse resp){
        String userIdStr = req.getParameter("userIdStr");
        int userId = Integer.parseInt(userIdStr);
        User user_db= userService.queryByUserID(userId);
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String adress = req.getParameter("adress");
        String tel = req.getParameter("tel");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        //封裝
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setSex(sex);
        user.setAdress(adress);
        user.setTel(tel);
        user.setUserName(userName);
        user.setPassword(password);
        System.out.println("界面"+user);
        int n = userService.updateUser(user);
        return "view/system/user/userList.jsp";
    }



}

