package com.csh.demo.spring.aop.advice;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author: shenghong.chen
 * Date: 2017/6/22
 * time: 下午11:38
 */
public class MethodCounter implements Serializable {
    //存储 <方法名, 调用次数>
    private HashMap<String, Integer> map = new HashMap<>();
    //所有方法调用总数
    private int allCount;

    protected void count(Method m) {

    }

    private void count(String methodName) {
        //线程不安全
        Integer n = map.get(methodName);
        n = null != n ? (n.intValue() + 1) : 1;
        map.put(methodName, n);
        ++ allCount;
    }
}
