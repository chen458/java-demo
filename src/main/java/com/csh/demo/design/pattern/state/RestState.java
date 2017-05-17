package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午7:59
 */
public class RestState implements State {
    @Override
    public void handle(Work work) {
        System.out.println(String.format("当前时间 : %s ,下班了 吼吼 ", work.getHour()));
    }
}
