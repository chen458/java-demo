package com.csh.demo.effective.java;

import java.util.concurrent.TimeUnit;

/**
 * @author: shenghong.chen
 * Date: 2016/11/17
 * time: 下午9:35
 */
public class StopThread {
    private static boolean stopReq;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopReq) {
                    System.out.println(i++ + " 次 运行");
                }
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(1);
        stopReq = true;
    }
}
