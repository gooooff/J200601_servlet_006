package com.hqyj.emb.system.service.impl;

import com.hqyj.emb.system.dao.RoleDao;
import com.hqyj.emb.system.dao.impl.RoleDaoImpl;
import com.hqyj.emb.system.model.Role;
import com.hqyj.emb.system.model.UserRole;
import com.hqyj.emb.system.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    RoleDao roleDao = new RoleDaoImpl();
    @Override
    public Role queryRoleByRole(Role role) {
        return null;
    }

    @Override
    public List<Role> queryAllRole() {
        return roleDao.queryAllRole();
    }

    @Override
    public int addRoleByRole(Role role) {
        return roleDao.addRoleByRole(role);
    }

    @Override
    public int deleteRoleByRoleId(int roleId) {
        return roleDao.deleteRoleByRoleId(roleId);
    }

    @Override
    public Role queryByRoleID(int roleId) {
        return roleDao.queryRoleByRoleID(roleId);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public Role queryRoleByUserId(int userId) {
        return roleDao.queryRoleByUserId(userId);
    }

    @Override
    public int addUserRoleByUserRole(UserRole userRole) {
        return roleDao.addUserRoleByUserRole(userRole);
    }

    @Override
    public int deleteUserRoleByUserId(int userId) {
        return roleDao.deleteUserRoleByUserId(userId);
    }
}
