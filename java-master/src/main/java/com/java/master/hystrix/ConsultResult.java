package com.java.master.hystrix;

/**
 * @author wangqing 
 */

public class ConsultResult {

    private String errorCode;

    private boolean enable;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
