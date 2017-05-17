package com.csh.demo.design.pattern.adapter;

/**
 * @author: shenghong.chen
 * Date: 16/8/4
 * time: 下午8:06
 */
public class Client {
    public static void main(String[] args) {
        Player forwards = new Forwards("巴蒂尔");
        forwards.attack();
        forwards.defense();

        Player center = new Center("姚明");
        center.attack();
        center.defense();
    }
}
