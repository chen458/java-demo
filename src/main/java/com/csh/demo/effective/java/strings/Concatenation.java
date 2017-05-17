package com.csh.demo.effective.java.strings;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午2:59
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + "gadfd" + 47;
        System.out.println(s + mango);
    }
}
