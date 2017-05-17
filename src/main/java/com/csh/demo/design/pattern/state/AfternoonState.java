package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午7:47
 */
public class AfternoonState implements State {
    @Override
    public void handle(Work work) {
        double hour = work.getHour();
        if (hour < 17 ) {
            System.out.println(String.format("当前时间 : %s ,下午工作,继续努力", hour));
        } else {
            work.setState(new EveningState());
            work.program();
        }
    }
}
