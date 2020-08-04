package com.hqyj.emb.system.service.impl;

import com.hqyj.emb.system.dao.PermissionDao;
import com.hqyj.emb.system.dao.impl.PermissionDaoImpl;
import com.hqyj.emb.system.model.Permission;
import com.hqyj.emb.system.service.PermissionService;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    PermissionDao permissionDao = new PermissionDaoImpl();
    @Override
    public List<Permission> queryAllPermission() {
        return permissionDao.queryAllPermission();
    }

    @Override
    public int addPermissionByPermission(Permission permission) {
        return permissionDao.addPermissionByPermission(permission);
    }

    @Override
    public Permission queryPermissionByPermissionId(int permissionId) {
        return permissionDao.queryPermissionByPermissionId(permissionId);
    }

    @Override
    public int deletePermissionByPermissionId(int permissionId) {
        return permissionDao.deletePermissionByPermissionId(permissionId);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionDao.updatePermission(permission);
    }
}
