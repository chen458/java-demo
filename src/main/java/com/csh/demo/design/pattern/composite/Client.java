package com.csh.demo.design.pattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: shenghong.chen
 * Date: 16/8/15
 * time: 下午7:51
 */
public class Client {
    public static void main(String[] args) {
        Component root = new Composite("根");
        root.add(new Leaf("枝叶 A"));
        root.add(new Leaf("枝叶 b"));

        Component comp1 = new Composite("树干 1");
        comp1.add(new Leaf("枝叶 1——A"));
        comp1.add(new Leaf("枝叶 1——b"));
        root.add(comp1);

        Component comp2 = new Composite("树干 2");
        comp2.add(new Leaf("枝叶 2——A"));
        comp2.add(new Leaf("枝叶 2——b"));
        root.add(comp1);

        root.add(new Leaf("枝叶 C"));
        Leaf leafD = new Leaf("枝叶 D");
        root.add(leafD);
        root.remove(leafD);

        root.display(1);

        List list = new ArrayList<>();
        final Iterator iterator = list.iterator();
    }
}
