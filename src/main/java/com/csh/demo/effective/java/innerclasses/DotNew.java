package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午12:44
 */
public class DotNew {
    public class Inner{
        public Inner() {
            System.out.println("Inner constructer");
        }
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner inner = dn.new Inner();
        new DotNew().new Inner();
    }
}
