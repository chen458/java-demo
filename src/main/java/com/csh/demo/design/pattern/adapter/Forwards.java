package com.csh.demo.design.pattern.adapter;

/**
 * @author: shenghong.chen
 * Date: 16/8/4
 * time: 下午8:01
 */
public class Forwards extends Player {

    public Forwards(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println(String.format("前锋 %s 进攻", name));
    }

    @Override
    void defense() {
        System.out.println(String.format("前锋 %s 防守", name));
    }
}
