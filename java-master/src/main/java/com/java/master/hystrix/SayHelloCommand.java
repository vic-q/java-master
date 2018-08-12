package com.java.master.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @author wangqing
 */

public class SayHelloCommand extends HystrixCommand<Response> {

    private static final String SERVICE_KEY_GROUP = "HelloServiceGroup";

    private final Request request;

    private static final HystrixConfig HYSTRIX_CONFIG;

    private Fallback<Response> fallback;

    static {
        /**
         * 从配置中心定时拉取熔断器配置，此处只初始化一次
         */
        HYSTRIX_CONFIG = new HystrixConfig();
    }

    public SayHelloCommand(final Request request) {
        this(request, null);
    }

    public SayHelloCommand(final Request request, Fallback fallback) {
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(SERVICE_KEY_GROUP))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(HYSTRIX_CONFIG.isEnabled())
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(HYSTRIX_CONFIG.getMaxConcurrentRequests())
                        .withCircuitBreakerErrorThresholdPercentage(HYSTRIX_CONFIG.getErrorThresholdPercentage())
                        .withExecutionTimeoutInMilliseconds(HYSTRIX_CONFIG.getTimeoutInMilliseconds())));
        this.request = request;
        this.fallback = fallback;
    }

    protected Response run() throws Exception {
        return RemoteService.getInstance().invoke(request);
    }

    @Override
    protected Response getFallback() {
        if (fallback != null) {
            return fallback.execute();
        }
        return null;
    }
}
