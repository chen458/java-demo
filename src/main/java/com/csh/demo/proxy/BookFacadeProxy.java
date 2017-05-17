package com.csh.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: shenghong.chen
 * Date: 2016/11/14
 * time: 下午4:10
 */
public class BookFacadeProxy implements InvocationHandler {
    private Object target;
    /**
     * 绑定委托对象并返回一个代理类
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("事物开始");
        result = method.invoke(target, args);
        System.out.println("事物结束");
        return result;
    }
}
