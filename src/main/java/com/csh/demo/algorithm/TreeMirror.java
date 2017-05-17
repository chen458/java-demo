package com.csh.demo.algorithm;

/**
 * @author: shenghong.chen
 * Date: 2016/11/29
 * time: 下午5:03
 */
public class TreeMirror {
    public static void main(String[] args) {
        Tree boot = new Tree(8);
        Tree left01 = new Tree(6);
        Tree left02 = new Tree(5);
        Tree left03 = new Tree(7);
        Tree right01 = new Tree(10);
        Tree right02 = new Tree(9);
        Tree right03 = new Tree(11);
        boot.left = left01;
        boot.right = right01;

//        left01.left = left02;
        left01.right = left03;

//        right01.left = right02;
        right01.right = right03;

        System.out.println(boot);
        TreeMirror.mirror(boot);
        System.out.println(boot);
    }

    public static void mirror(Tree tree) {
        if (null == tree)
            return;
        Tree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        mirror(tree.left);
        mirror(tree.right);
    }
}

class Tree {
    Object value;
    Tree left;
    Tree right;

    public Tree(Object value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
