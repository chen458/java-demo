package com.csh.demo.design.pattern.composite;

/**
 * 字部分的抽象
 * @author: shenghong.chen
 * Date: 16/8/15
 * time: 下午7:36
 */
public abstract class Component {
    String name;

    public Component(String name) {
        this.name = name;
    }

    /**
     * 增加子对象
     * @param c
     */
    abstract void add(Component c);

    /**
     * 移除子对象
     * @param c
     */
    abstract void remove(Component c);

    /**
     * 展示
     */
    abstract void display(int depth);

}
