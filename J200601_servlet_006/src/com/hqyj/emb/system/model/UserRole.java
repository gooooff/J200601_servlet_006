package com.hqyj.emb.system.model;

public class UserRole {
    private int userRole_id;
    private int userId;
    private int roleId;

    public UserRole(int userRole_id, int userId, int roleId) {
        this.userRole_id = userRole_id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole() {
    }

    public int getUserRole_id() {
        return userRole_id;
    }

    public void setUserRole_id(int userRole_id) {
        this.userRole_id = userRole_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRole_id=" + userRole_id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
