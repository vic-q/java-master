package com.java.master.hystrix;

/**
 * @author wangqing 
 */

public class Request {

    private final String type;

    public Request(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
