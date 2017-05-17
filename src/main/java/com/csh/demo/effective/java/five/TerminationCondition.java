package com.csh.demo.effective.java.five;

/**
 * @author: shenghong.chen
 * Date: 2016/11/18
 * time: 下午10:16
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book noval = new Book(true);
        noval.checkIn();

        new Book(true);
        System.gc();
    }
}
