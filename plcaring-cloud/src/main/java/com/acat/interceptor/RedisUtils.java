package com.acat.interceptor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 这是一个用于注入RedisTemplate的类，如果不提前注入会报空指针异常
    因为Spring池中没有注入RedisTemplate 此时的RedisTemplate为空
 */
@Component
public class RedisUtils {
    @Resource
    private RedisTemplate<String,Object> redis;

    public static RedisTemplate redisTemplate;
    @PostConstruct //此注解表示构造时赋值
    public void redisTemplate() {

        redisTemplate = this.redis;
    }
}
