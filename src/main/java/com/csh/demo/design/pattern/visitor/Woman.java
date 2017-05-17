package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:12
 */
public class Woman implements Person {
    @Override
    public void accept(Action action) {
        action.womanAction(this);
    }
}
