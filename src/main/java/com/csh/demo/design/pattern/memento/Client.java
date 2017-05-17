package com.csh.demo.design.pattern.memento;

/**
 * @author: shenghong.chen
 * Date: 16/8/14
 * time: 下午4:55
 */
public class Client {

    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("打开");
        o.show();

        Caretaker c = new Caretaker();
        c.setMemento(o.createMemento());
        o.setState("关闭");
        o.show();

        o.setMemento(c.getMemento());
        o.show();
    }
}
