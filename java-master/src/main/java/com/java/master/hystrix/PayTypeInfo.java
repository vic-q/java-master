package com.java.master.hystrix;

/**
 * @author wangqing 
 */

public class PayTypeInfo {

    private final String type;

    private final Boolean enable;

    public PayTypeInfo(final String type, final Boolean enable) {
        this.type = type;
        this.enable = enable;
    }

    public String getType() {
        return type;
    }

    public Boolean getEnable() {
        return enable;
    }
}
