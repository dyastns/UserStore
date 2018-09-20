package com.study.userstore.dao;

import com.study.userstore.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    int addUser(User user);

    int removeUserById(int id);
}
