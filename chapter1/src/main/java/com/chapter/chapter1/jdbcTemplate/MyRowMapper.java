package com.chapter.chapter1.jdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password =  resultSet.getString("password");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

}
