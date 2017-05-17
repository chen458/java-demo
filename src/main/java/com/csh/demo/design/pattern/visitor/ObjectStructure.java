package com.csh.demo.design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:20
 */
public class ObjectStructure {
    private List<Person> list = new ArrayList<>();

    public void attach (Person p) {
        list.add(p);
    }

    public void detach (Person p ) {
        list.remove(p);
    }

    public void display(Action action) {
        for (Person person : list) {
            person.accept(action);
        }
    }
}
