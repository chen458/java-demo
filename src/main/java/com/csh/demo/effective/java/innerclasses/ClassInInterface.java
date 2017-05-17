package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/14
 * time: 上午12:04
 */
public interface ClassInInterface {
    void howdy ();

    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
