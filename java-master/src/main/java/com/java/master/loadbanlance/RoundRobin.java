package com.java.master.loadbanlance;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wang_qb
 *         轮询算法
 */
public class RoundRobin implements Selector {

    private int pos = 0;

    private ReentrantLock lock = new ReentrantLock();

    /**
     * 选举
     * @return
     */
    @Override
    public String select() {
        String targetIp;
        List<String> ipList = Constants.ipList;
        lock.lock();
        try {
            if (pos > ipList.size()) {
                pos = 0;
            }
            targetIp = ipList.get(pos);
            pos++;
            return targetIp;
        } finally {
            lock.unlock();
        }
    }
}
