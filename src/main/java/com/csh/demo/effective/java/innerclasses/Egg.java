package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/27
 * time: 下午11:56
 */
public class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk");
        }
    }

    public Egg() {
        System.out.println("new Egg()");
        y = new Yolk();
    }
}

