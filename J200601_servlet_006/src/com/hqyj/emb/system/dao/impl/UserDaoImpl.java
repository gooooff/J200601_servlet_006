package com.hqyj.emb.system.dao.impl;

import com.hqyj.emb.system.dao.UserDao;
import com.hqyj.emb.system.model.User;
import frame.dbuitl.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @return:
 * @Author: zlf
 * @Date: 2020/7/30 17:38
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User queryUserByUser(User user) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_user WHERE userName=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user_db = new User();
                user_db.setUserId(rs.getInt("userId"));
                user_db.setName(rs.getString("name"));
                user_db.setSex(rs.getString("sex"));
                user_db.setAdress(rs.getString("adress"));
                user_db.setTel(rs.getString("tel"));
                user_db.setUserName(rs.getString("userName"));
                user_db.setPassword(rs.getString("password"));
                return user_db;
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> queryAllUser() {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_user";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                User user_db = new User();
                user_db.setUserId(rs.getInt("userId"));
                user_db.setName(rs.getString("name"));
                user_db.setSex(rs.getString("sex"));
                user_db.setAdress(rs.getString("adress"));
                user_db.setTel(rs.getString("tel"));
                user_db.setUserName(rs.getString("userName"));
                user_db.setPassword(rs.getString("password"));
                userList.add(user_db);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addUserByUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_user (userId,name,sex,adress,tel,userName,password) VALUES(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getSex());
            pstmt.setString(4, user.getAdress());
            pstmt.setString(5, user.getTel());
            pstmt.setString(6, user.getUserName());
            pstmt.setString(7, user.getPassword());

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int deleteUserByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_user WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User queryUserByUserID(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "select * FROM sys_user WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user_db = new User();
                user_db.setUserId(rs.getInt("userId"));
                user_db.setName(rs.getString("name"));
                user_db.setSex(rs.getString("sex"));
                user_db.setAdress(rs.getString("adress"));
                user_db.setTel(rs.getString("tel"));
                user_db.setUserName(rs.getString("userName"));
                user_db.setPassword(rs.getString("password"));
                return user_db;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(User user) {
//        System.out.println("准备修改"+user);
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = JdbcUtils.getConnection();
//            String sql = "update sys_user SET name=?,sex=?,adress=?,tel=?,userName=?,password=? where userId=?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, user.getName());
//            pstmt.setString(2, user.getSex());
//            pstmt.setString(3, user.getAdress());
//            pstmt.setString(4, user.getTel());
//            pstmt.setString(5, user.getUserName());
//            pstmt.setString(6, user.getPassword());
//            pstmt.setInt(7, user.getUserId());
//
//
//            int m = pstmt.executeUpdate();
//            return m;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                pstmt.close();
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE sys_user SET name=?,sex=?,adress=?,tel=?,userName=?,password=? WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSex());
            pstmt.setString(3, user.getAdress());
            pstmt.setString(4, user.getTel());
            pstmt.setString(5, user.getUserName());
            pstmt.setString(6, user.getPassword());
            pstmt.setInt(7, user.getUserId());

            int m = pstmt.executeUpdate();
            return m;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
