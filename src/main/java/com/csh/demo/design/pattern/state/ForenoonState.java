package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午7:44
 */
public class ForenoonState implements State {
    @Override
    public void handle(Work work) {
        if (work.getHour() < 12 ) {
            System.out.println(String.format("当前时间 %s 点,上午工作,精神好", work.getHour()));
        } else {
            work.setState(new NoonState());
            work.program();
        }
    }
}
