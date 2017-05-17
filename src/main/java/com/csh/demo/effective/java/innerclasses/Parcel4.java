package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2017/2/12
 * time: 下午9:34
 */
public class Parcel4 {

    private class PContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination (String s ) {
        return new PDestination(s);
    }

    public Contents contents () {
        return new PContents();
    }
}
