package com.csh.demo.design.pattern.builder;

/**
 * @author: shenghong.chen
 * Date: 16/6/28
 * time: 下午7:11
 */
public class Director {
    public void build(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }

}
