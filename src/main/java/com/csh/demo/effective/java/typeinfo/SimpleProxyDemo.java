package com.csh.demo.effective.java.typeinfo;

/**
 * @author: shenghong.chen
 * Date: 2017/3/12
 * time: 下午5:34
 */
public class SimpleProxyDemo implements Interface{
    private Interface proxy;

    public SimpleProxyDemo(Interface proxy) {
        this.proxy = proxy;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxyDemo doSomething");
        proxy.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxyDemo somethingElse arg : " + arg);
        proxy.somethingElse(arg);
    }

    public static void main(String[] args) {
        String test = "Test";
        RealObject realObject = new RealObject();
        realObject.doSomething();
        realObject.somethingElse(test);

        SimpleProxyDemo demo = new SimpleProxyDemo(realObject);
        demo.doSomething();
        demo.somethingElse(test);
    }
}

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("RealObject doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("RealObject somethingElse arg : " + arg );
    }
}
