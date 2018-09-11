package com.study.userstore.dao.jdbc.mapper;


import com.study.userstore.entity.User;
import org.junit.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {
        //prepare
        UserRowMapper userRowMapper = new UserRowMapper();
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("firstName")).thenReturn("test_firstName");
        when(mockResultSet.getString("lastName")).thenReturn("test_lastName");
        when(mockResultSet.getDouble("salary")).thenReturn(1456.11);

        LocalDate dateOfBirth = LocalDate.of(1711,9,10);
        when(mockResultSet.getString("dateOfBirth")).thenReturn("1711-09-10");

        //when
        User actual = userRowMapper.mapRow(mockResultSet);

        //then
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals("test_firstName", actual.getFirstName());
        assertEquals("test_lastName", actual.getLastName());
        assertEquals(1456.11, actual.getSalary(), 0.0001);
        assertEquals(dateOfBirth, actual.getDateOfBirth());
    }
}