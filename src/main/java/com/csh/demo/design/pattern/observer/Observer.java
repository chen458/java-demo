package com.csh.demo.design.pattern.observer;

/**
 * 抽象观察者
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午3:14
 */
public abstract class Observer {
    String name;

    Subject subject;

    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();
}
