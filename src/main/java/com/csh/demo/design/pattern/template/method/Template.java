package com.csh.demo.design.pattern.template.method;

/**
 * 模板方法 抽象模板类
 * @author: shenghong.chen
 * Date: 16/6/25
 * time: 下午5:04
 */
public abstract class Template {
    public void method1() {
        System.out.println("测试01");
        System.out.println("测试01的答案:" + result());
    }
    abstract String result();
}
