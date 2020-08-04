package com.hqyj.emb.system.dao.impl;

import com.hqyj.emb.system.dao.RoleDao;
import com.hqyj.emb.system.model.Role;
import com.hqyj.emb.system.model.User;
import com.hqyj.emb.system.model.UserRole;
import frame.dbuitl.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public Role queryRoleByRole(Role role) {

        return null;
    }

    @Override
    public List<Role> queryAllRole() {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_role";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            ArrayList<Role> roleList = new ArrayList<>();

            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                Role role_db = new Role();
                role_db.setRoleId(rs.getInt("roleId"));
                role_db.setName(rs.getString("name"));
                role_db.setState(rs.getString("state"));
                roleList.add(role_db);
            }
            return roleList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addRoleByRole(Role role) {
        {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = JdbcUtils.getConnection();
                String sql = "INSERT INTO  sys_role (roleId,name,state) VALUES(?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, role.getRoleId());
                pstmt.setString(2, role.getName());
                pstmt.setString(3, role.getState());
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
    }

    @Override
    public int deleteRoleByRoleId(int RoleId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_role WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, RoleId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Role queryRoleByRoleID(int RoleId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_role WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, RoleId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Role role_db = new Role();
                role_db.setRoleId(rs.getInt("roleId"));
                role_db.setName(rs.getString("name"));
                role_db.setState(rs.getString("state"));
                return role_db;
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateRole(Role role) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE sys_role SET name=?,state=? WHERE roleId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, role.getName());
            pstmt.setString(2, role.getState());
            pstmt.setInt(3,role.getRoleId());


            int m = pstmt.executeUpdate();
            return m;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Role queryRoleByUserId(int userId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT\n" +
                    "sys_role.roleId,\n" +
                    "sys_role.`name`,\n" +
                    "sys_role.state\n" +
                    "FROM\n" +
                    "sys_userrole\n" +
                    "INNER JOIN sys_role ON sys_userrole.roleId = sys_role.roleId\n" +
                    "WHERE userId=?\n";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Role role_db = new Role();
                role_db.setRoleId(rs.getInt("roleId"));
                role_db.setName(rs.getString("name"));
                role_db.setState(rs.getString("state"));

                return role_db;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addUserRoleByUserRole(UserRole userRole) {
        {
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = JdbcUtils.getConnection();
                String sql = "INSERT INTO  sys_userrole (userRole_id,userId,roleId) VALUES(?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userRole.getUserRole_id());
                pstmt.setInt(2, userRole.getUserId());
                pstmt.setInt(3, userRole.getRoleId());
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
    }

    @Override
    public int deleteUserRoleByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_userrole WHERE userId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
