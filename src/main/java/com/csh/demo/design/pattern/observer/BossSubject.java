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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public void Notify() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
