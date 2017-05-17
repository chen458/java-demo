package com.csh.demo.design.pattern.builder;

/**
 * @author: shenghong.chen
 * Date: 16/6/27
 * time: 下午8:04
 */
public class ConcreteBuilder extends Builder {

    public ConcreteBuilder(Product product) {
        super(product);
    }

    @Override
    public void buildPartA() {
        product.add("测试A1");
    }

    @Override
    public void buildPartB() {
        product.add("测试B1");
    }

    @Override
    public void show() {
        product.show();
    }


}
