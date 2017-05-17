package com.csh.demo.design.pattern.iterator;

/**
 * 迭代器 接口类
 * @author: shenghong.chen
 * Date: 16/8/16
 * time: 下午7:31
 */
public interface Iterator {

    Object first();

    Object next();

    void remove();
}
