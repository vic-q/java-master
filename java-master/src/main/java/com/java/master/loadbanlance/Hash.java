package com.java.master.loadbanlance;

import java.util.List;

/**
 * @author wang_qb
 *         HASH
 */
public class Hash implements Selector {

    private final String ip;

    public Hash(String ip) {
        this.ip = ip;
    }

    @Override
    public String select() {
        List<String> ipList = Constants.ipList;
        int hashCode = ip.hashCode();
        int idx = hashCode % ipList.size();
        return ipList.get(idx);
    }
}
