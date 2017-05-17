package com.csh.demo.effective.java.innerclasses;

/**
 * @author: shenghong.chen
 * Date: 2016/11/23
 * time: 下午5:12
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add (Object v) {
        if (next < items.length) {
            items[next ++ ] = v;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }
        public Object current() {
            return items[i];
        }
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
       return new SequenceSelector();
    }
    public static void main(String[] args) {
        Sequence s = new Sequence(10);
        for (int i = 0; i < 10; i ++) {
            s.add(Integer.toString(i));
        }
        Selector selector = s.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}

