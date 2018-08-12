package com.java.master.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author wangqing
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 50; index++) {
            final int NO = index;
            Runnable r = () -> {
                try {
                    semp.acquire();
                } catch (InterruptedException e) {
                }
                System.out.println("Accessing: " + NO);
                try {
                    Thread.sleep(new Random().nextInt(6 * 1000));
                } catch (InterruptedException e) {

                }
                // 访问完后，释放
                semp.release();
                System.out.println("-----------------" + semp.availablePermits());
            };
            exec.execute(r);
        }
        exec.shutdown();

    }
}
