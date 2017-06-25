package com.csh.demo.spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: shenghong.chen
 * Date: 2017/6/22
 * time: 下午11:51
 */
public class CountingBeforeAdvice extends MethodCounter implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        count(method);
    }
}
