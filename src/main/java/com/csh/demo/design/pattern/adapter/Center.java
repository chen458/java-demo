package com.csh.demo.design.pattern.adapter;

/**
 * @author: shenghong.chen
 * Date: 16/8/4
 * time: 下午8:05
 */
public class Center extends Player {
    public Center(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println(String.format("中锋 %s 进攻", name));
    }

    @Override
    void defense() {
        System.out.println(String.format("中锋 %s 防守", name));
    }
}
