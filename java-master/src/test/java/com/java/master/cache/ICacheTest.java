package com.java.master.cache;

import com.alibaba.fastjson.TypeReference;
import com.java.master.cache.guava.CacheImpl;
import com.java.master.cache.guava.GuavaCacheBuilder;
import com.java.master.cache.guava.ICache;
import com.java.master.cache.guava.LocalCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangqing on 17/12/10.
 */

public class ICacheTest {

    LocalCache<String, User> localCache = GuavaCacheBuilder
            .newBuilder()
            .container("test")
            .expireAfterWrite(5000, TimeUnit.MILLISECONDS)
            .build();

    final ICache<String, User> cache = new CacheImpl<String, User>(localCache);

    private TypeReference<User> type = new TypeReference<User>() {
    };

    public void testPut() {
        cache.set("user", new User("ok"));

    }

    public void testGet() throws ExecutionException {
        User user = cache.get("user", new Call(), type);
        System.out.println("user name=" + user.getName());
    }


    private class Call implements Callable<String> {
        public String call() throws Exception {
            System.out.println("access");
            return "{\"name\":\"i am ok\"}";
        }
    }


    private static class User {
        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ICacheTest iCacheTest = new ICacheTest();

        try {
            new Thread(new Runnable() {
                public void run() {
                    iCacheTest.testPut();
                    throw new RuntimeException();
                }
            }).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(1000);

        for (; ; ) {
            iCacheTest.testGet();
            Thread.sleep(1000);
        }

    }

}
