package com.redis.chapter3.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable(value="user", key="#id", unless="#result==null")
    public String getUser(String id) {
        System.out.println("I am form userService");
        System.out.println(stringRedisTemplate.getValueSerializer());
        System.out.println(redisTemplate.getValueSerializer());
        return id;
    }
}
