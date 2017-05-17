package com.csh.demo.algorithm;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * “从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。”
 * @author: shenghong.chen
 * Date: 2016/12/14
 * time: 下午11:27
 */
public class TreePrint {
    public static void main(String[] args) {
        BinaryTree<Integer> bt5 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> bt7 = new BinaryTree<Integer>(7);
        BinaryTree<Integer> bt9 = new BinaryTree<Integer>(9);
        BinaryTree<Integer> bt11 = new BinaryTree<Integer>(11);
        BinaryTree<Integer> bt6 = new BinaryTree<Integer>(6, bt5, bt7);
        BinaryTree<Integer> bt10 = new BinaryTree<Integer>(10, bt9, bt11);
        BinaryTree<Integer> boot =  new BinaryTree<Integer>(8, bt6, bt10);
        TreePrint.print(boot);
    }

    public static void print (BinaryTree<Integer> bt) {
        if (null == bt)
            return;
        Queue<BinaryTree> q = new ConcurrentLinkedQueue<BinaryTree>();
        q.add(bt);
        while (null != q.peek()) {
            BinaryTree root = q.poll();
            System.out.println(root.value);
            if (null != root.left)
                q.add(root.left);
            if (null != root.right)
                q.add(root.right);
        }
    }
}

class BinaryTree<T> {
    T value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
