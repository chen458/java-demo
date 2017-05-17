package com.csh.demo.effective.java.generics;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午5:48
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f(gm);
    }
}