package com.study.userstore.service;

import com.study.userstore.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    int addUser(User user);

    int removeUserById(int id);
}
