package com.hqyj.emb.system.dao;

import com.hqyj.emb.system.model.User;

import java.util.List;

/**
 * <p>数据访问对象层接口：用户</p>
 *
 * @author : zlf
 * @date : 2020-07-29 14:00
 **/

public interface UserDao {
    User queryUserByUser(User user);

    List<User> queryAllUser();

    int addUserByUser(User user);

    int deleteUserByUserId(int userId);


    User queryUserByUserID(int userId);

    int updateUser(User user);
}
