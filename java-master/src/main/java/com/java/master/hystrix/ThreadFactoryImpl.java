package com.java.master.hystrix;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangqing 
 */

public class ThreadFactoryImpl implements ThreadFactory {

    private final AtomicInteger number = new AtomicInteger(1);

    private final String prefix;

    private ThreadFactoryImpl(final String prefix) {
        this.prefix = prefix;
    }

    public static ThreadFactoryImpl create(String prefix) {
        return new ThreadFactoryImpl(prefix);
    }


    public Thread newThread(Runnable r) {
        return new Thread(r, this.prefix + "-" + number.get());
    }
}
