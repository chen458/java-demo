package com.csh.demo.design.pattern.memento;

/**
 * 备忘录类
 * @author: shenghong.chen
 * Date: 16/8/14
 * time: 下午4:49
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
