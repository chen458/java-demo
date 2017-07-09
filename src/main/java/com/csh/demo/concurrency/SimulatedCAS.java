package com.csh.demo.concurrency;

/**
 * CAS 结构
 * @author chenshenghong
 * @version 1.0
 * @created 2017/7/10
 * @time 上午12:02
 */
public class SimulatedCAS {
    private int value;

    private synchronized int get(){
        return value;
    }

    /**
     * 比较并更新
     * @param expectedValue 原来的值
     * @param newValue 需要更新的值
     * @return
     */
    private synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (value == expectedValue)
            value = newValue;
        return oldValue;
    }

    private synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
