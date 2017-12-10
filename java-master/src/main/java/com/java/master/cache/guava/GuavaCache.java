package com.java.master.cache.guava;

import com.alibaba.fastjson.TypeReference;
import com.java.master.util.JsonUtils;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author wang_qb
 */
public class GuavaCache<V> implements Cache<V> {

    private static final String PREFIX_FORMAT = "%s_%s";

    private final LoadingCache<String, String> delegate;

    public GuavaCache(LoadingCache cache) {
        this.delegate = cache;
    }

    public void set(String prefix, String key, V value) {
        this.delegate.put(buildCacheKey(prefix, key), toJson(value));
    }

    public void set(String prefix, Map<String, V> map) {
        for (Map.Entry<String, V> entry : map.entrySet()) {
            this.set(prefix, entry.getKey(), entry.getValue());
        }
    }

    public V get(String prefix, String key, TypeReference<V> type) throws ExecutionException {
        return fromJson(this.delegate.get(buildCacheKey(prefix, key)), type);
    }

    public Map<String, V> get(String prefix, List<String> keys, TypeReference<V> type) throws ExecutionException {
        Map<String, V> resultMap = Maps.newHashMap();
        for (String key : keys) {
            resultMap.put(buildCacheKey(prefix, key), this.get(prefix, key, type));
        }
        return resultMap;
    }

    private String buildCacheKey(String prefix, String key) {
        return String.format(PREFIX_FORMAT, prefix, key);
    }

    private String toJson(V value) {
        return JsonUtils.objectToJsonString(value);
    }

    private V fromJson(String value, TypeReference<V> type) {
        return JsonUtils.parseObject(value, type);
    }

}
