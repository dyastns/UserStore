package com.study.userstore.dao.jdbc.mapper;

import com.study.userstore.entity.User;

import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper {
    public User mapRow(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setSalary(resultSet.getDouble("salary"));
        String strDateOfBirth = resultSet.getString("dateOfBirth");
        if (strDateOfBirth != null) {
            LocalDate dateOfBirth = LocalDate.parse(strDateOfBirth);
            user.setDateOfBirth(dateOfBirth);
        }
        return user;
    }
}

