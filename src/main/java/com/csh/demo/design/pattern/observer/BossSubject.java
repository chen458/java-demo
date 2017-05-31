package com.csh.demo.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体观察者
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午3:28
 */
public class BossSubject implements Subject {
    //定义一个观察者集合用于存储所有观察者对象
    private List<Observer> observers = new ArrayList<>();
    private String action ;
    private String state;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
