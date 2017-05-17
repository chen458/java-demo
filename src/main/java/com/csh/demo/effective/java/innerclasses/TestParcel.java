package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/12
 * time: 下午9:38
 */
public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();

        Contents contents = parcel4.contents();
        Destination destination = parcel4.destination("test");
    }
}
