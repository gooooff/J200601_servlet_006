package com.hqyj.emb.system.service;

import com.hqyj.emb.system.model.User;

import java.util.List;

/**
 * <p>业务层：用户</p>
 *
 * @author : zlf
 * @date : 2020-07-29 13:57
 **/

public interface UserService {
    User queryUserByUser(User user);

    List<User> queryAllUser();

    int addUserByUser(User user);

    int deleteUserByUserId(int userId);

    User queryByUserID(int userId);

    int updateUser(User user);
}
