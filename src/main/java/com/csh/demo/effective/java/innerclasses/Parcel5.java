package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午1:20
 */
public class Parcel5 {
    public Destination destination (String s) {
        class PDestination implements Destination {
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination("Test");
    }

    public Contents contents (){
        return new Contents() {
            private int i = 11;
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destination tasmania = parcel5.destination("Tasmania");
    }
}
