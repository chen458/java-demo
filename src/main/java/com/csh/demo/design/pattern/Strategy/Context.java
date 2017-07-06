package com.csh.demo.design.pattern.Strategy;

/**
 * 策略执行对象
 *
 * @author chenshenghong
 * @version 1.0
 * @created 2017/6/25
 * @time 下午11:24
 */
public class Context {
    private Statagy statagy;

    public Context(Statagy statagy) {
        this.statagy = statagy;
    }

    /**
     * 策略执行
     */
    public void context(){
        statagy.algorithm();
    }
}
