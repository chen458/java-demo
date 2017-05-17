package com.csh.demo.effective.java.five;

/**
 * @author: shenghong.chen
 * Date: 2016/11/18
 * time: 下午10:14
 */
public class Book {
    boolean checkout = false;

    public Book(boolean checkout) {
        this.checkout = checkout;
    }

    void checkIn(){
        checkout = false;
    }

    protected void finalize(){
        if (checkout) {
            System.out.println(this.toString() + "Error : checked out");
        }
    }

}
