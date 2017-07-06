package com.csh.demo.spring.aop.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现
 * 1、JDK 实现 : implements InvocationHandler
 * 2、cglib 实现 : implements MethodInterceptor
 *
 * @author chenshenghong
 * @version 1.0
 * @created 2017/6/24
 * @time 下午5:53
 */
public class DynamicProxy {
    public static void main(String[] args) {
        BookFacede real = new RealBookFacede();

        System.out.println("JDK proxy 执行 ====");
        JdkProxy jdkProxy = new JdkProxy();
        BookFacede jdkBF = (BookFacede)jdkProxy.bind(real);
        jdkBF.addBook();

        System.out.println("cglib proxy 执行 ====");
        CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealBookFacede.class);
        enhancer.setCallback(cglibProxy);
        BookFacede cglibBF = (RealBookFacede)enhancer.create();//获取代理类
        cglibBF.addBook();
    }
}

/**
 * 图书管理接口
 */
interface BookFacede {
    void addBook();
}

/**
 * 真实实现方法
 */
class RealBookFacede implements BookFacede {

    @Override
    public void addBook() {
        System.out.println("添加图书方法");
    }
}

/**
 * JDK 代理类
 */
class JdkProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target){
        this.target = target;
        // 返回动态代理类, 内部调用 invoke
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK proxy 开始!");
        Object result = method.invoke(target, args);//执行真实方法
        System.out.println("JDK proxy 结束!");
        return result;
    }
}

/**
 * cglib 代理类
 */
class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy 开始!");
        Object proxyObject = methodProxy.invoke(o, args);
        System.out.println("cglib proxy 结束!");
        return proxyObject;
    }
}