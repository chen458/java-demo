package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午1:38
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementational1.factory);
        serviceConsumer(Implementational2.factory);
    }
}

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementational1 implements Service {
    private Implementational1() {
    }

    public void method1() {
        System.out.println("Implementational1 method1");
    }

    public void method2() {
        System.out.println("Implementational1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementational1();
        }
    };
}

class Implementational2 implements Service {
    private Implementational2() {
    }

    public void method1() {
        System.out.println("Implementational2 method1");
    }

    public void method2() {
        System.out.println("Implementational2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementational2();
        }
    };
}