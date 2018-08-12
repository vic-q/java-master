package com.java.master.thread;

/**
 * @author wangqing
 */
public class Monitor {

    private static Lock lock = new Lock();

    private static class Lock {

    }

    public void waitTest() throws InterruptedException {
        lock.wait();
    }

    public void notifyTest() {
        synchronized (lock) {
            lock.notifyAll();
            System.out.println("释放锁成功");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();

        Runnable runnable = () -> {
            synchronized (lock) {
                try {
                    monitor.waitTest();
                    System.out.println("thread name = [" + Thread.currentThread().getName() + "]被唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(1000);

        monitor.notifyTest();

    }


}
