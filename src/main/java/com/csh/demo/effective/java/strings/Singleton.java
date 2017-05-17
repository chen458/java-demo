package com.csh.demo.effective.java.strings;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午4:10
 */
public class Singleton {
    public static void main(String[] args) {
        int i10 = 1000;
        int i11 = 1000;
        Integer i20 = 100;
        Integer i21 = 100;
        Integer i200 = new Integer(100);
        Integer i210 = new Integer(100);
        Integer i30 = 1000;
        Integer i31 = 1000;
        System.out.println(i10 == i11);
        System.out.println(i20 == i21);
        System.out.println(i200 == i210);
        System.out.println(i30 == i31);
    }
}
