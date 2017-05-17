package com.csh.demo.effective.java.typeinfo;


/**
 * instanceof 和Class 的等价性
 * @author: shenghong.chen
 * Date: 2017/3/12
 * time: 下午2:32
 */
public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Testing x of type : " + x.getClass());
        System.out.println("x instanceof base : " + (x instanceof Base));
        System.out.println("x instanceof Derived : " + (x instanceof  Derived));
        System.out.println("Base.isInstance(x) : " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) : " + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class : " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class : " + (x.getClass() == Derived.class));
        System.out.println("x.getClass().equals(Base.class) : " + x.getClass().equals(Base.class));
        System.out.println("x.getClass().equals(Derived.class) : " + x.getClass().equals(Derived.class));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println("==================");
        test(new Derived());
    }
}

class Base{}

class Derived extends Base {}