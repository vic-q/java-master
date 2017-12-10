package com.java.master.cache.guava;


import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangqing on 17/12/10.
 */

public final class GuavaCacheBuilder {

    private String container;

    private CacheBuilder cacheBuilder = CacheBuilder.newBuilder();

    public static GuavaCacheBuilder newBuilder() {
        return new GuavaCacheBuilder();
    }

    public GuavaCacheBuilder container(String container) {
        this.container = container;
        return this;
    }

    public GuavaCacheBuilder initialCapacity(int initialCapacity) {
        this.cacheBuilder.initialCapacity(initialCapacity);
        return this;
    }

    public GuavaCacheBuilder concurrencyLevel(int concurrencyLevel) {
        this.cacheBuilder.concurrencyLevel(concurrencyLevel);
        return this;
    }

    public GuavaCacheBuilder expireAfterWrite(long duration, TimeUnit unit) {
        this.cacheBuilder.expireAfterWrite(duration, unit);
        return this;
    }

    public GuavaCacheBuilder expireAfterAccess(long duration, TimeUnit unit) {
        this.cacheBuilder.expireAfterAccess(duration, unit);
        return this;
    }

    public GuavaCacheBuilder refreshAfterWrite(long duration, TimeUnit unit) {
        this.cacheBuilder.refreshAfterWrite(duration, unit);
        return this;
    }

    public LocalCache build() {
        return new LocalCache(container, cacheBuilder.build());
    }

}
