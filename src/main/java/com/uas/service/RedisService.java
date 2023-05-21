package com.uas.service;

public interface RedisService {
    /**
     * 设置缓存
     */
    void set(String key, Object value);

    /**
     * 设置缓存(时效性)
     */
    void set(String key, Object value, int seconds);

    /**
     * 获取缓存
     */
    Object get(String key);

    /**
     * 删除缓存
     */
    void delete(String key);
}
