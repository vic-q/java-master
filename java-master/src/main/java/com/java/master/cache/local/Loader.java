package com.java.master.cache.local;


/**
 * Created by wangqing on 17/12/22.
 */
public interface Loader<K, V> {

    V load(K key);

}
