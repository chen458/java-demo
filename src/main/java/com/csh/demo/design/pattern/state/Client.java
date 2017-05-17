package com.csh.demo.design.pattern.state;

/**
 * @author: shenghong.chen
 * Date: 16/8/1
 * time: 下午8:04
 */
public class Client {
    public static void main(String[] args) {
        Work work = new Work(new ForenoonState());
        for (int i = 8; i < 24; i++) {
            work.setHour(i);
            work.program();
            if (i > 19) {
                work.setFinish(true);
            }
        }

    }
}
