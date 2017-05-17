package com.csh.demo.effective.java.innerclasses.controller;

/**
 * @author: shenghong.chen
 * Date: 2017/2/26
 * time: 下午5:06
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
