package com.csh.demo.effective.java.reusing;

/**
 * @author: shenghong.chen
 * Date: 2016/11/21
 * time: 下午10:23
 */
public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        new Cartoon();
    }
}

class Art {
    public Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing constructor");
    }
}
