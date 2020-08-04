package com.hqyj.emb.system.service;

import com.hqyj.emb.system.model.Role;
import com.hqyj.emb.system.model.UserRole;

import java.util.List;

public interface RoleService {
    Role queryRoleByRole(Role role);

    List<Role> queryAllRole();

    int addRoleByRole(Role role);

    int deleteRoleByRoleId(int roleId);

    Role queryByRoleID(int roleId);

    int updateRole(Role role);

    Role queryRoleByUserId(int userId);

    int addUserRoleByUserRole(UserRole userRole);

    int deleteUserRoleByUserId(int userId);
}
