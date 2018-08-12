package com.java.master.hystrix;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author wangqing 
 */

public class AccessLimitService {

    private static final AccessLimitService INSTANCE = new AccessLimitService();

    private AccessLimitService() {

    }

    public static AccessLimitService getInstance() {
        return INSTANCE;
    }

    //每秒只发出5个令牌
    private RateLimiter rateLimiter = RateLimiter.create(5.0);

    /**
     * 尝试获取令牌
     * @return
     */
    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }

}
