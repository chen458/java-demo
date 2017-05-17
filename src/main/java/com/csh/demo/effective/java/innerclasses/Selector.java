package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/12
 * time: 下午8:36
 */
interface Selector {
    boolean end();

    Object current();

    void next();
}
