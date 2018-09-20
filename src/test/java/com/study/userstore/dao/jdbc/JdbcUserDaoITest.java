package com.study.userstore.dao.jdbc;

import com.study.userstore.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcUserDaoITest {
    @Test
    public void testGetAll() {
        //prepare
        JdbcUserDao jdbcUserDao = new JdbcUserDao();
        //when
        List<User> actualUsers = jdbcUserDao.getAll();
        //then
        assertNotNull(actualUsers);
        assertFalse(actualUsers.isEmpty());
        for (User user : actualUsers) {
            assertNotNull(user);
            assertNotNull(user.getFirstName());
            assertNotNull(user.getLastName());
            //System.out.println(user);
        }
    }
}