package com.csh.demo.effective.java;

import java.util.Set;

/**
 * @author: shenghong.chen
 * Date: 2016/11/17
 * time: 下午10:45
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> s) {
        super(s);
    }

}
