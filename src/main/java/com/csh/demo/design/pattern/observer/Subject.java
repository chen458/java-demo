package com.csh.demo.design.pattern.observer;

/**
 * 通知者接口
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午3:20
 */
public interface Subject {
    /**
     * 注册方法，用于向观察者集合中增加一个观察者
     * @param observer
     */
    void attach(Observer observer);
    /**
     * 注销方法，用于在观察者集合中删除一个观察者
     * @param observer
     */
    void detach(Observer observer);
    /**
     * 通知方法
     */
    void Notify();
}
