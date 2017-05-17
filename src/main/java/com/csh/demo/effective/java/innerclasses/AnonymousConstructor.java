package com.csh.demo.effective.java.innerclasses;

import static com.sun.deploy.trace.Trace.print;

/**
 * @author: shenghong.chen
 * Date: 2017/2/13
 * time: 下午11:43
 */
public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                print("Inside instance initializer");
            }
            @Override
            public void f() {
                print("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
