package com.csh.demo.design.pattern.observer;

/**
 * 通知者接口
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午3:20
 */
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void Notify();

}
