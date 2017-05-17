package com.csh.demo.design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式:需要创建的对象
 * @author: shenghong.chen
 * Date: 16/6/27
 * time: 下午7:40
 */
public class ProductImpl1 implements Product{
    private List<String> parts = new ArrayList<>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
