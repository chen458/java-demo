package com.csh.demo.concurrency;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer 实例
 * @author chenshenghong
 * @version 1.0
 * @created 2017/7/6
 * @time 上午9:25
 */
public class TimerDemo {
    public static void main(String[] args) {

        delayConcurrency(10000);
    }

    public static void delayConcurrency(long delay){
        Timer timer = new Timer();
        timer.schedule(new TimerTaskDemo1(), delay);
    }

    static class TimerTaskDemo1 extends TimerTask {
        @Override
        public void run() {
            System.out.println("TimerTaskDemo1 running ......");
        }
    }
}
