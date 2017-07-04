package com.csh.demo.concurrency;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 在可变对象基础上构建的不可变类
 * @author: shenghong.chen
 * Date: 2017/6/29
 * time: 下午11:55
 */
@Immutable
public final class ThreeStooges {
    private final Set<String> stooge = new HashSet<>();

    public ThreeStooges() {
        stooge.add("moe");
        stooge.add("gagg");
        stooge.add("gtry");
    }

    public boolean isStooge(String name) {
        return stooge.contains(name);
    }
}
