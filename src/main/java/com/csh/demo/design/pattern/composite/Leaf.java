package com.csh.demo.design.pattern.composite;

/**
 * 枝叶 对象,没子对象
 * @author: shenghong.chen
 * Date: 16/8/15
 * time: 下午7:41
 */
public class Leaf extends Component{

    public Leaf(String name) {
        super(name);
    }

    @Override
    void add(Component c) {

    }

    @Override
    void remove(Component c) {

    }

    @Override
    void display(int depth) {
        String s = "";
        for (int i = 0; i < depth; i ++ ) {
            s += " - ";
        }
        System.out.println(s + name);
    }
}
