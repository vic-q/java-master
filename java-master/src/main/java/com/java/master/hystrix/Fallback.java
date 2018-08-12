package com.java.master.hystrix;

/**
 * @author wangqing
 */
public interface Fallback<T> {

    T execute();
}
