package com.hqyj.emb.system.service;

import com.hqyj.emb.system.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> queryAllPermission();

    int addPermissionByPermission(Permission permission);

    Permission queryPermissionByPermissionId(int permissionId);

    int deletePermissionByPermissionId(int permissionId);

    int updatePermission(Permission permission);
}
