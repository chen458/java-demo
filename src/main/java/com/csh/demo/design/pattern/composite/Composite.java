package com.csh.demo.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenghong.chen
 * Date: 16/8/15
 * time: 下午7:46
 */
public class Composite extends Component {
    private List<Component> list = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    void add(Component c) {
        list.add(c);
    }

    @Override
    void remove(Component c) {
        list.remove(c);
    }

    @Override
    void display(int depth) {
        String s = "";
        for (int i = 0; i < depth; i ++ ) {
            s += " - ";
        }
        System.out.println(s + name);
        for (Component component : list) {
            component.display(depth + 2);
        }
    }
}
