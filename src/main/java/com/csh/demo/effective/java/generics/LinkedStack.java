package com.csh.demo.effective.java.generics;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午5:09
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end (){
            return null == next;
        }
    }

    private Node<T> top = new Node<T>();
    public void push (T item) {
        top = new Node<T>(item, top);
    }

    public T pop(){
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        for (String s : "Phasers on stun".split(" ")) {
            stack.push(s);
        }
        String s;
        while ((s = stack.pop()) != null) {
            System.out.println(s);
        }
    }
}
