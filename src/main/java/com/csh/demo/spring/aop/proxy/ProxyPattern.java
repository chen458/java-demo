package com.csh.demo.spring.aop.proxy;

/**
 * 代理模式
 * @author chenshenghong
 * @version 1.0
 * @created 2017/6/24
 * @time 下午5:43
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Subject real = new RealSubject();
        Subject proxy = new ProxySubject(real);
        proxy.request("test Proxy ");
    }
}

interface Subject{

    void request(String value);
}

/**
 * 具体对象
 */
class RealSubject implements Subject {
    @Override
    public void request(String value) {
        System.out.println("RealSubject request === " + value);
    }
}

class ProxySubject implements Subject {
    private Subject real;

    public ProxySubject(Subject real) {
        this.real = real;
    }

    @Override
    public void request(String value) {
        before(value);
        real.request(value);
        System.out.println(after(value));
    }

    private String before(String value){
        return value += " proxy before ";
    }

    private String after(String value) {
        return "proxy end";
    }
}
