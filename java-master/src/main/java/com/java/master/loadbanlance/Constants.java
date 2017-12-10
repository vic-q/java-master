package com.java.master.loadbanlance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wang_qb
 */
public class Constants {

    public static List<String> ipList;

    private Constants() {
    }

    static {
        List<String> temp = new ArrayList<String>();
        ipList.add("192.168.1.100");
        ipList.add("192.168.1.101");
        ipList.add("192.168.1.102");
        ipList.add("192.168.1.103");
        ipList.add("192.168.1.104");
        ipList.add("192.168.1.105");
        ipList.add("192.168.1.106");
        ipList.add("192.168.1.107");
        ipList.add("192.168.1.108");
        ipList = Collections.unmodifiableList(temp);
    }

}
