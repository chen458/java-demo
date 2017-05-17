package com.csh.demo.effective.java.polymorphism;

/**
 * 只有普通方式可使用多态
 * 静态方法不支持多态
 * @author: shenghong.chen
 * Date: 2017/2/9
 * time: 下午11:42
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        Sub sub = new Sub();
        System.out.println("sup : field = " + sup.field +
                "; getField = " + sup.getField());
        System.out.println("sub : field = " + sub.field +
                "; getField = " + sub.getField() +
                "; getSuperField = " + sub.getSuperField());
    }
}

class Super {
    public int field = 0;

    public int getField (){
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    public int getField (){
        return field;
    }

    public int getSuperField (){
        return super.field;
    }
}