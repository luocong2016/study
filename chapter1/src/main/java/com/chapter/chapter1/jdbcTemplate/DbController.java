package com.chapter.chapter1.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mmall")
public class DbController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/user")
    public List<User> getUserAll() {
        String sql = "select * from mmall_user";
        List<User> users = jdbcTemplate.query(sql, new MyRowMapper());
        return users;
    }

    @GetMapping("/user/{username}")
    public List<User> getUser(@PathVariable String username) {
        String sql = "select * from mmall_user where username = ?";
        List<User> users = jdbcTemplate.query(sql, new MyRowMapper(), username);
        return users;
    }
}
