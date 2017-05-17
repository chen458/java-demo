package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/27
 * time: 下午11:59
 */
public class BigEgg extends Egg{
    protected class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
