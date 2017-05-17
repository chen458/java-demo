package com.csh.demo.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenghong.chen
 * Date: 16/8/16
 * time: 下午7:36
 */
public class ConcreteAggregate implements Aggregate {

    private List<Object> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int count(){
        return items.size();
    }

    public Object get(int index) {
        return items.get(index);
    }

    public void set(Object o) {
        items.add(o);
    }
}
