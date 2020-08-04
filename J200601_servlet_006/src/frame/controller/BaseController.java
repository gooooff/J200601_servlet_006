package frame.controller;

import com.hqyj.emb.system.service.UserService;
import com.hqyj.emb.system.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>基础控制器</p>
 *
 * @author : zlf
 * @date : 2020-07-30 14:12
 **/

public class BaseController extends HttpServlet {
    public UserService userService = new UserServiceImpl();

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受方法参数
        String method = req.getParameter("method");
        //判断
        if (method.equals("add")) {
            this.add(req, resp);
        }
        if (method.equals("delete")) {
            this.delete(req, resp);
        }
        if (method.equals("update")) {
            this.update(req, resp);
        }
        if (method.equals("queryUserByUserId")) {
            this.queryUserByUserId(req, resp);
        }
        if (method.equals("queryAllUser")) {
            this.queryAllUser(req, resp);
        }
        if (method.equals("login")) {
            this.login(req, resp);
        }
    }

    //1.增加
    public void add(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("add");
    }


    //2.删除
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("delete");
    }


    //3.修改
    public void update(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("update");
    }


    //4.查询
    public void queryUserByUserId(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("queryUserByUserId");
    }

    //4.查询
    public void queryAllUser(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("queryAllUser");
    }
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("login");
        return null;
    }

}
