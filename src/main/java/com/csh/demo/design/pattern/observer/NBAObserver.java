package com.csh.demo.design.pattern.observer;

/**
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午4:09
 */
public class NBAObserver extends Observer {

    public NBAObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println("NBA 通知者通知");
    }
}
