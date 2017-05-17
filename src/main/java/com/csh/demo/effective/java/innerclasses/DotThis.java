package com.csh.demo.effective.java.innerclasses;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午12:40
 */
public class DotThis {
    void f () {
        System.out.println("DotThis.f()");
    }
    public class Inner {
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner inner = dt.inner();
        inner.outer().f();
    }
}
