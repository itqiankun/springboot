package com.itqiankun.repository;

import com.itqiankun.model.User;

/**
 * Created by itqiankun on 2017/5/5.
 */
public interface UserRepository {

    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public long updateUser(User user);

    public void deleteUserById(Long id);

}
