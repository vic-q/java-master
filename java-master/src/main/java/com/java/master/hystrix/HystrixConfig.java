package com.java.master.hystrix;

/**
 * @author wangqing
 */

public class HystrixConfig {

    /**
     * 是否开启熔断器
     */
    private boolean enabled;

    /**
     * 最大并发量
     */
    private int maxConcurrentRequests;

    /**
     * 超时时间
     */
    private int timeoutInMilliseconds;

    /**
     * 错误比率阀值
     */
    private int errorThresholdPercentage;

    public HystrixConfig() {
        this.enabled = true;
        this.maxConcurrentRequests = 50;
        this.timeoutInMilliseconds = 1000;
        this.errorThresholdPercentage = 50;
        //TODO 开启线程刷新配置
    }

    /**
     * 其他参数省略
     * @return
     */

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getMaxConcurrentRequests() {
        return maxConcurrentRequests;
    }

    public void setMaxConcurrentRequests(int maxConcurrentRequests) {
        this.maxConcurrentRequests = maxConcurrentRequests;
    }

    public int getErrorThresholdPercentage() {
        return errorThresholdPercentage;
    }

    public void setErrorThresholdPercentage(int errorThresholdPercentage) {
        this.errorThresholdPercentage = errorThresholdPercentage;
    }

    public int getTimeoutInMilliseconds() {
        return timeoutInMilliseconds;
    }

    public void setTimeoutInMilliseconds(int timeoutInMilliseconds) {
        this.timeoutInMilliseconds = timeoutInMilliseconds;
    }
}
