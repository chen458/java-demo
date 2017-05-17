package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午7:48
 */
public class EveningState implements State {
    @Override
    public void handle(Work work) {
        double hour = work.getHour();
        if (work.isFinish()) {
            work.setState(new RestState());
            work.program();
        } else {
            if (hour < 21) {
                System.out.println(String.format("当前时间 : %s ,加班,赶紧下班 ", hour));
            } else {
                work.setState(new SleepState());
                work.program();
            }
        }
    }
}
