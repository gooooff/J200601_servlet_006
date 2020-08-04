package com.hqyj.emb.system.test;

import com.hqyj.emb.system.dao.impl.RoleDaoImpl;
import com.hqyj.emb.system.model.Role;

public class RoleDaoTest {
    public static void main(String[] args) {
        RoleDaoImpl roleDao = new RoleDaoImpl();
        Role role1 = new Role();
//        role1.setRoleId(4);
        role1.setState("管理员");
        role1.setName("feizhuzhuzhu");
        Role role2 = new Role();
        role2.setName("gaofei");
        role2.setState("管理员");
        role2.setRoleId(1);


//        System.out.println(roleDao.queryAllRole());
//        System.out.println(roleDao.queryRoleByRoleID(1));
//        roleDao.addRoleByRole(role1);
//        roleDao.deleteRoleByRoleId(3);
//        System.out.println(roleDao.updateRole(role1));
    }
}
