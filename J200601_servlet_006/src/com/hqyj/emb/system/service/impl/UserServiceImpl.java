package com.hqyj.emb.system.service.impl;

import com.hqyj.emb.system.dao.UserDao;
import com.hqyj.emb.system.dao.impl.UserDaoImpl;
import com.hqyj.emb.system.model.User;
import com.hqyj.emb.system.service.UserService;

import java.util.List;

/**
 * <p>业务实现层：用户</p>
 *
 * @author : zlf
 * @date : 2020-07-29 13:59
 **/

public class UserServiceImpl implements UserService {
    //注入（DI）：DAO接口
    UserDao userDao = new UserDaoImpl();

    @Override
    public User queryUserByUser(User user) {
//        User user_db = userDao.queryUserByUser(user);
//        return user_db;
        return userDao.queryUserByUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public int addUserByUser(User user) {
        return userDao.addUserByUser(user);
    }

    @Override
    public int deleteUserByUserId(int userId) {
        return userDao.deleteUserByUserId(userId);
    }

    @Override
    public User queryByUserID(int userId) {
        return userDao.queryUserByUserID(userId);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
