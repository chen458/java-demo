package com.csh.demo.effective.java.innerclasses;

import com.sun.deploy.xml.XMLable;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午1:48
 */
public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }
    protected static class ParceDestinaton implements Destination {
        private String label;
        public ParceDestinaton(String label) {
            this.label = label;
        }
        public String readLabel() {
            return label;
        }
        public static void f(){}
        static int x =19;
        static class Anotherlevel {
            public static void f(){};
            static int x = 19;
        }

        public static Destination destination (String s) {
            return new ParceDestinaton(s);
        }

        public static Contents contents (){
            return new ParcelContents();
        }

        public static void main(String[] args) {
            Contents contents = contents();
            Destination destination = destination("test");
        }
    }
}
