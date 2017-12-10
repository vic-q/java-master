package com.java.master.loadbanlance;

import java.util.List;

/**
 * @author wang_qb
 *         随机算法
 */
public class Random implements Selector {

    @Override
    public String select() {
        List<String> ipList = Constants.ipList;
        java.util.Random r = new java.util.Random(ipList.size());
        int idx = r.nextInt();
        return ipList.get(idx);
    }
}
