package com.csh.demo.design.pattern.Strategy;

/**
 * 策略 A 实现
 * @author chenshenghong
 * @version 1.0
 * @created 2017/6/25
 * @time 下午11:23
 */
public class StatagyA implements Statagy {
    @Override
    public void algorithm() {
        System.out.println("算法A执行");
    }
}
