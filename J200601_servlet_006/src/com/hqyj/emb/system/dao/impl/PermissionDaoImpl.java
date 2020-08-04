package com.hqyj.emb.system.dao.impl;

import com.hqyj.emb.system.dao.PermissionDao;
import com.hqyj.emb.system.model.Permission;
import frame.dbuitl.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionDaoImpl implements PermissionDao {
    @Override
    public List<Permission> queryAllPermission() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_permission";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            List<Permission> permissionList = new ArrayList<>();
            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setState(rs.getString("state"));


                permissionList.add(permission_db);
            }
            return permissionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addPermissionByPermission(Permission permission) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO  sys_permission (permissionId,pId,name,type,url,state) VALUES(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permission.getPermissionId());
            pstmt.setInt(2, permission.getpId());
            pstmt.setString(3, permission.getName());
            pstmt.setString(4, permission.getType());
            pstmt.setString(5, permission.getUrl());
            pstmt.setString(6, permission.getState());


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
    public Permission queryPermissionByPermissionId(int permissionId) {
        //操作数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 查询数据库
        // prepareStatement与Statement区别
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM sys_permission WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permissionId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Permission permission_db = new Permission();
                permission_db.setPermissionId(rs.getInt("permissionId"));
                permission_db.setpId(rs.getInt("pId"));
                permission_db.setName(rs.getString("name"));
                permission_db.setType(rs.getString("type"));
                permission_db.setUrl(rs.getString("url"));
                permission_db.setState(rs.getString("state"));

                return permission_db;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int deletePermissionByPermissionId(int permissionId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();

            String sql = "DELETE FROM sys_permission WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permissionId);

            int m = pstmt.executeUpdate();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updatePermission(Permission permission) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE sys_permission SET pId=?,name=?,type=?,url=?,state=? WHERE permissionId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, permission.getpId());
            pstmt.setString(2, permission.getName());
            pstmt.setString(3, permission.getType());
            pstmt.setString(4, permission.getUrl());
            pstmt.setString(5, permission.getState());
            pstmt.setInt(6, permission.getPermissionId());

            int m = pstmt.executeUpdate();
            return m;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
