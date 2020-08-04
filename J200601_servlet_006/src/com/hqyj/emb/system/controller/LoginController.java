package com.hqyj.emb.system.controller;

import com.hqyj.emb.system.model.User;
import frame.controller.BaseController;
import frame.controller.BaseController2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>登录</p>
 *
 * @author : zlf
 * @date : 2020-07-30 15:19
 **/
@WebServlet("/loginController.do")
public class LoginController extends BaseController2 {

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @return
     */
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        //1.接受数据
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        //封装思想
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        //3.调用业务
        User user_db = userService.queryUserByUser(user);
        HttpSession session = req.getSession();
        Object safeCode = session.getAttribute("safeCode");
        String safecode = safeCode.toString();
        System.out.println(safecode);
        String safecodeFromUser = req.getParameter("checkCode");
        if (userName.isEmpty()|| password.isEmpty()) {
            req.setAttribute("message", "请输入用户名或密码！");
            //2.跳转页面
//            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {

            if (safeCode.equals(safecodeFromUser) || safecode.toLowerCase().equals(safecodeFromUser)) {


                if (user_db!=null) {
                    //友情提示
                    req.setAttribute("message", "登录成功！");
                    req.setAttribute("username",user_db.getUserName());
                    //2.跳转页面

                    return "view/frame/main.jsp";
                } else {
                    req.setAttribute("message", "用户名或密码错误！");

                    return "index.jsp";
                }

            } else {
                System.out.println("验证码有误");
                req.setAttribute("message", "验证码错误，请重新输入！");
            }
        }

        return "index.jsp";
    }
}
