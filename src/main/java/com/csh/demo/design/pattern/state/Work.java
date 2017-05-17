package com.csh.demo.design.pattern.state;

/**
 *
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午7:37
 */
public class Work {
    /**
     * 工作状态
     */
    private State state;

    /**
     * 当下时间
     */
    private double hour;

    /**
     * 任务属性
     */
    private boolean finish;



    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void program(){
        state.handle(this);
    }

    public Work(State state) {
        this.state = state;
    }
}
