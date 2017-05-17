package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午7:47
 */
public class NoonState implements State {
    @Override
    public void handle(Work work) {
        double hour = work.getHour();
        if (hour < 13) {
            System.out.println(String.format("当前时间 : %s ,午休", hour));
        } else {
            work.setState(new AfternoonState());
            work.program();
        }
    }
}
