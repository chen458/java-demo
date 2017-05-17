package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/14
 * time: 上午12:16
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);

        Caller ca1 = new Caller(c1);
        Caller ca2 = new Caller(c2.getCallbackReference());
        ca1.go();
        ca1.go();
        ca2.go();
        ca2.go();


    }

}

class Caller {
    private Incrementable reference;

    public Caller(Incrementable reference) {
        this.reference = reference;
    }

    void go (){
        reference.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i ++;
        System.out.println("Callee2 : " +i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference () {
        return new Closure();
    }
}


class MyIncrement {
    public void increment() {
        System.out.println("Other Operation");
    }

    static void f (MyIncrement mi) {
        mi.increment();
    }
}

class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i ++;
        System.out.println("Callee1 : " + i);
    }
}

interface Incrementable {
    void increment();
}
