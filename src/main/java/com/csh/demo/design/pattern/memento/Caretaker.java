package com.csh.demo.design.pattern.memento;

/**
 * 备忘录模式  管理者
 * @author: shenghong.chen
 * Date: 16/8/14
 * time: 下午4:53
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
