package com.csh.demo.design.pattern.iterator;

/**
 * @author: shenghong.chen
 * Date: 16/8/16
 * time: 下午7:38
 */
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate aggregate ;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public Object first() {
        return aggregate.get(0);
    }

    @Override
    public Object next() {
        return aggregate.get( ++ current );
    }

    @Override
    public void remove() {

    }
}
