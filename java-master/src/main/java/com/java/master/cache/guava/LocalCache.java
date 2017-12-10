package com.java.master.cache.guava;

import com.google.common.cache.Cache;

/**
 * Created by wangqing on 17/12/10.
 */

public class LocalCache<K, V> {

    private String container;
    private Cache<K, V> cache;

    public LocalCache(String container, Cache<K, V> cache) {
        this.container = container;
        this.cache = cache;
    }

    public String getContainer() {
        return container;
    }

    public Cache<K, V> getCache() {
        return cache;
    }
}
