package com.java.master.hystrix;

/**
 * @author wangqing 
 */

public class RemoteService {

    private static final RemoteService INSTANCE = new RemoteService();

    public static RemoteService getInstance() {
        return INSTANCE;
    }

    public Response invoke(Request request) {
        return null;
    }

}
