package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午8:01
 */
public class SleepState implements State {
    @Override
    public void handle(Work work) {
        System.out.println(String.format("当前时间 : %s ,梦中 ", work.getHour()));
    }
}
