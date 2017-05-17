package com.csh.demo.design.pattern.builder;

/**
 * @author: shenghong.chen
 * Date: 16/6/27
 * time: 下午7:43
 */
public abstract class Builder {
    Product product;

    public Builder(Product product) {
        this.product = product;
    }

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void show();
}
