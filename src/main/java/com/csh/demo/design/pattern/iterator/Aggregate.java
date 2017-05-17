package com.csh.demo.design.pattern.iterator;

/**
 * 聚集抽象类
 * @author: shenghong.chen
 * Date: 16/8/16
 * time: 下午7:34
 */
public interface Aggregate {

    Iterator createIterator();
}
