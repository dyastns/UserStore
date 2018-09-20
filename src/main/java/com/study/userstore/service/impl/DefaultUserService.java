package com.study.userstore.service.impl;

import com.study.userstore.dao.UserDao;
import com.study.userstore.entity.User;
import com.study.userstore.service.UserService;

import java.util.List;

public class DefaultUserService implements UserService {
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int removeUserById(int id) {
        return userDao.removeUserById(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
