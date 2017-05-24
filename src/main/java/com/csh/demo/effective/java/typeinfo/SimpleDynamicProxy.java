package com.csh.demo.effective.java.typeinfo;


import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;


/**
 * @author: shenghong.chen
 * Date: 2017/3/12
 * time: 下午10:48
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("test two");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject));

    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxy;

    public DynamicProxyHandler(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("DynamicProxyHandler :" + o.getClass() + "; method " + method + "; args " + objects);

        return method.invoke(objects);
    }
}
