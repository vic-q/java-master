package com.java.master.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wang_qb
 *         <p>
 *         使用线程组管理线程
 */
public class DemoThreadFactory implements ThreadFactory {

    /**
     * 线程数量
     */
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    /**
     * 前缀
     */
    private final String namePrefix;

    private final boolean daemon;

    private static final ThreadGroup THREAD_GROUP = new ThreadGroup("demo-master");

    public DemoThreadFactory(String namePrefix, boolean daemon) {
        this.namePrefix = namePrefix;
        this.daemon = daemon;
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(THREAD_GROUP, r, THREAD_GROUP.getName() + "-" + namePrefix + "-" + threadNumber.getAndIncrement());
        thread.setDaemon(daemon);
        return thread;
    }

}
