package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2016/11/23
 * time: 下午4:44
 */
public class Parcel {
    class Contents {
        private int i = 11;
        public int value () {
            return i;
        }
    }

    class Destination {
        private String label;
        public Destination(String label) {
            this.label = label;
        }
        String readLabel (){
            return label;
        }
    }

    public Destination to (String s) {
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    public void ship (String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        parcel.ship("测试");
        Parcel q = new Parcel();
        Parcel.Contents c = q.contents();
        Parcel.Destination borneo = q.to("Borneo");
    }
}
