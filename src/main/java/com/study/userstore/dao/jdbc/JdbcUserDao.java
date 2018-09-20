package com.study.userstore.dao.jdbc;

import com.study.userstore.dao.UserDao;
import com.study.userstore.dao.jdbc.mapper.UserRowMapper;
import com.study.userstore.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements UserDao {
    private static final String GET_ALL_SQL = "SELECT id, firstName, lastName, salary, dateOfBirth FROM users;";
    private static final String ADD_USER_SQL = "INSERT INTO users (id, firstName, lastName, salary, dateOfBirth) VALUES (?, ?, ?, ?, ?);";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?;";
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

    @Override
    public int addUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER_SQL);) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setDouble(4, user.getSalary());
            preparedStatement.setString(5, user.getDateOfBirth().toString());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int removeUserById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
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
