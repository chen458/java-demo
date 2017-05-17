package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:11
 */
public class Man implements Person {
    @Override
    public void accept(Action action) {
        action.manAction(this);
    }
}
