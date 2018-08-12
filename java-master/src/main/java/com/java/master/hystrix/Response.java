package com.java.master.hystrix;

import java.util.concurrent.Future;

/**
 * @author wangqing 
 */

public class Response {

    private String type;

    private Future<Response> future;

    public Response(String type, Future<Response> future) {
        this.type = type;
        this.future = future;
    }

    public String getType() {
        return type;
    }

    public Future<Response> getFuture() {
        return future;
    }
}
