package com.hqyj.emb.system.dao;

import com.hqyj.emb.system.model.Role;
import com.hqyj.emb.system.model.UserRole;

import java.util.List;

public interface RoleDao {
    Role queryRoleByRole(Role role);

    List<Role> queryAllRole();

    int addRoleByRole(Role role);

    int deleteRoleByRoleId(int RoleId);


    Role queryRoleByRoleID(int RoleId);

    int updateRole(Role role);

    Role queryRoleByUserId(int userId);

    int addUserRoleByUserRole(UserRole userRole);

    int deleteUserRoleByUserId(int userId);
}
