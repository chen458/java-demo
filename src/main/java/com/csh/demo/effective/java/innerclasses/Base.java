package com.csh.demo.effective.java.innerclasses;

import static com.sun.deploy.trace.Trace.print;

/**
 * @author: shenghong.chen
 * Date: 2017/2/13
 * time: 下午11:41
 */
public abstract class Base {
    public Base(int i) {
        print("Base Construct, i = " + i);
    }

    public abstract void f();
}
