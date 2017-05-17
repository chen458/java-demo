package com.csh.demo.design.pattern.memento;

/**
 * 备忘录模式 ———— 发起人
 * @author: shenghong.chen
 * Date: 16/8/14
 * time: 下午4:48
 */
public class Originator {
    private String state;

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setMemento(Memento m) {
        this.state = m.getState();
    }

    public void show () {
        System.out.println("state : " + state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
