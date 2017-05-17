package com.csh.demo.design.pattern.template.method;

/**
 * @author: shenghong.chen
 * Date: 16/6/25
 * time: 下午5:09
 */
public class TemplateClient {
    public static void main(String[] args) {
        Template t1 = new TemplateImpl01();
        t1.method1();
        Template t2 = new TemplateImpl02();
        t2.method1();
    }

}
