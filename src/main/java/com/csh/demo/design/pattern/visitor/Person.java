package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:10
 */
public interface Person {

    void accept(Action action);
}
