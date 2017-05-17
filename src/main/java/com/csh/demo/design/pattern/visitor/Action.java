package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/22
 * time: 下午2:30
 */
public interface Action {
    void manAction(Man man);

    void womanAction(Woman woman);

}
