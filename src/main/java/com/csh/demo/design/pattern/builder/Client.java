package com.csh.demo.design.pattern.builder;

/**
 * @author: shenghong.chen
 * Date: 16/6/28
 * time: 下午7:10
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder(new ProductImpl1());
        director.build(builder);
        builder.show();


    }
}
