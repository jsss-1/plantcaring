package com.acat.service.impl;


import com.acat.cache.JedisUtil;
import com.acat.service.CacheService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CacheServiceImpl implements CacheService {
    private JedisUtil jedisUtil;

    @Override
    public void removeFromCache(String keyPrefix) {
        Set<String> keySet = jedisUtil.getKeys().keys(keyPrefix + "*");
        for (String key : keySet) {
            jedisUtil.getKeys().del(key);
        }
    }
}
