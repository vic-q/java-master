package com.java.master.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.collect.Maps;

import com.alibaba.fastjson.TypeReference;
import com.java.master.util.JsonUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author wang_qb
 */
public class CacheImpl<K, V> implements ICache<K, V> {

    private static final String PREFIX_FORMAT = "%s_%s";

    private final String container;

    private final Cache<String, String> delegate;

    public CacheImpl(LocalCache localCache) {
        this.delegate = localCache.getCache();
        this.container = localCache.getContainer();
    }

    public void set(K key, V value) {
        this.delegate.put(buildCacheKey(container, key), toJson(value));
    }

    public void set(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.set(entry.getKey(), entry.getValue());
        }
    }

    public V get(K key, TypeReference<V> type) throws ExecutionException {
        return fromJson(this.delegate.getIfPresent(buildCacheKey(container, key)), type);
    }

    public V get(K key, Callable<? extends String> valueLoader, TypeReference<V> type) throws ExecutionException {
        return fromJson(this.delegate.get(buildCacheKey(container, key), valueLoader), type);
    }

    public Map<String, V> get(List<K> keys, TypeReference<V> type) throws ExecutionException {
        Map<String, V> resultMap = Maps.newHashMap();
        for (K key : keys) {
            resultMap.put(buildCacheKey(container, key), this.get(key, type));
        }
        return resultMap;
    }

    private String buildCacheKey(String container, K key) {
        return String.format(PREFIX_FORMAT, container, key);
    }

    private String toJson(V value) {
        return JsonUtils.objectToJsonString(value);
    }

    private V fromJson(String value, TypeReference<V> type) {
        return JsonUtils.parseObject(value, type);
    }

}
