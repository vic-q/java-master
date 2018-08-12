package com.java.master.cache.local;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by wangqing on 17/12/22.
 */

public class LocalCache<K, V> implements Loader<K, V> {

    private final ConcurrentMap<K, Future<V>> cache = new ConcurrentHashMap<>();

    private final Loader<K, V> loader;

    public LocalCache(Loader<K, V> loader) {
        this.loader = loader;
    }

    public V load(K key) {
        while (true) {
            Future<V> future = cache.get(key);
            if (future == null) {
                Callable<V> call = () -> loader.load(key);
                FutureTask<V> task = new FutureTask(call);
                cache.putIfAbsent(key, task);
                if (future == null) {
                    future = task;
                    task.run();
                }
            }
            try {
                return future.get();
            } catch (CancellationException | InterruptedException ex) {
                cache.remove(key);
            } catch (ExecutionException e) {
                launderThrowable(e.getCause());
            }
        }
    }

    private void launderThrowable(Throwable t) {

    }
}
