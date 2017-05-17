package com.csh.demo.design.pattern.adapter;

/**
 * @author: shenghong.chen
 * Date: 16/8/4
 * time: 下午7:59
 */
public abstract class Player {

    String name;

    public Player(String name) {
        this.name = name;
    }

    /**
     * 进攻
     */
    abstract void attack();

    /**
     * 防守
     */
    abstract void defense();
}
