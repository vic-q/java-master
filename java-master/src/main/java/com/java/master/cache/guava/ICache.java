package com.java.master.cache.guava;

import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author wang_qb
 */
public interface ICache<K, V> {

    void set(K key, V value);

    void set(Map<K, V> map);

    V get(K key, TypeReference<V> type) throws ExecutionException;

    V get(K key, Callable<? extends String> valueLoader, TypeReference<V> type) throws ExecutionException;

    Map<String, V> get(List<K> keys, TypeReference<V> type) throws ExecutionException;
}
