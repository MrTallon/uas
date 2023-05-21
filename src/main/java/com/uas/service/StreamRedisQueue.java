package com.uas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class StreamRedisQueue {
    //队列名
    public static final String KEY = "stream_queue";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String  produce(Map<String, String> value) {
        return Objects.requireNonNull(redisTemplate.opsForStream().add(KEY, value)).getValue();
    }

    public void createGroup(String key, String group){
        redisTemplate.opsForStream().createGroup(key, group);
    }
}
