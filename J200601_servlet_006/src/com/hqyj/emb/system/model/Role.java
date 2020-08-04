package com.hqyj.emb.system.model;

public class Role {
    private int roleId;
    private String name;
    private String state;

    public Role(int roleId, String name, String state) {
        this.roleId = roleId;
        this.name = name;
        this.state = state;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
