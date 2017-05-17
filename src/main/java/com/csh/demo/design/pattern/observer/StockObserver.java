package com.csh.demo.design.pattern.observer;

/**
 * 具体通知者一
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午3:32
 */
public class StockObserver extends Observer {

    public StockObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println("看股票通知");
    }
}
