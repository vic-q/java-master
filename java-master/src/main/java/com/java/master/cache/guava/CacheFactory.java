package com.java.master.cache.guava;


import com.google.common.cache.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wang_qb
 */
public final class CacheFactory {

    private static final ConcurrentMap<String, com.google.common.cache.Cache<String, String>> LOCAL_CACHE = new ConcurrentHashMap<String, com.google.common.cache.Cache<String, String>>();

    private CacheFactory() {
        throw new IllegalArgumentException();
    }

    /**
     * 获取cache
     * @param container 容器名称
     * @param duration 有效时间
     * @param unit 时间单位
     * @return
     */
    public static com.google.common.cache.Cache<String, String> getCache(String container, long duration, TimeUnit unit) {
        com.google.common.cache.Cache<String, String> cache = LOCAL_CACHE.get(container);
        if (cache == null) {
            cache = CacheBuilder.newBuilder().expireAfterWrite(3000, TimeUnit.MILLISECONDS).build();
            LOCAL_CACHE.put(container, cache);
        }
        return cache;
    }
}
