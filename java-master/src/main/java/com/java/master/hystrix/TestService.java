package com.java.master.hystrix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangqing
 */

public class TestService {

    private static final String THREAD_NAME = "Test";

    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(CORE_SIZE,
            CORE_SIZE,
            60,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            ThreadFactoryImpl.create(THREAD_NAME),
            new DefaultRejectedExecutionHandler());

    public List<PayTypeInfo> list(List<String> typeList) {

        if (access()) {
            // 限流
            final List<Response> responseList = new ArrayList<>(typeList.size());
            for (String type : typeList) {
                Future<Response> future = EXECUTOR.submit(new Task(new Request(type)));
                responseList.add(new Response(type, future));
            }

            final List<PayTypeInfo> resultList = new ArrayList<>(typeList.size());
            for (Response response : responseList) {

                boolean enable = false;
                try {
                    response.getFuture().get();
                } catch (InterruptedException e) {
                } catch (ExecutionException e) {
                }
                resultList.add(new PayTypeInfo(response.getType(), enable));
            }
            return resultList;
        } else {
            return null;
        }
    }

    private boolean access() {
        return AccessLimitService.getInstance().tryAcquire();
    }


    private static class Task implements Callable<Response> {

        private Request request;

        public Task(Request request) {
            this.request = request;
        }

        public Response call() throws Exception {
            return new SayHelloCommand(request).execute();
        }
    }
}
