package com.study.userstore.dao.jdbc;

import com.study.userstore.dao.UserDao;
import com.study.userstore.dao.jdbc.mapper.UserRowMapper;
import com.study.userstore.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao {
    private static final String GET_ALL_SQL = "SELECT id, firstName, lastName, salary, dateOfBirth FROM users;";
    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();

    @Override
    public List<User> getAll() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_SQL)) {

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = USER_ROW_MAPPER.mapRow(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        String dbUrl = "jdbc:sqlite:userstore.sqlite";
        try {
            return DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create create connection to database", e);
        }
    }
}
