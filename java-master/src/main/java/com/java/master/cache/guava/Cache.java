package com.java.master.cache.guava;

import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author wang_qb
 */
public interface Cache<V> {

    void set(String prefix, String key, V value);

    void set(String prefix, Map<String, V> map);

    V get(String prefix, String key, TypeReference<V> type) throws ExecutionException;

    Map<String, V> get(String prefix, List<String> keys, TypeReference<V> type) throws ExecutionException;
}
