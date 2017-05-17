package com.csh.demo.design.pattern.chain.responsibility;

/**
 * @author: shenghong.chen
 * Date: 16/8/18
 * time: 下午7:34
 */
public class Client {
    public static void main(String[] args) {
        Handler ha = new ConcreteHandlerA();
        Handler hb = new ConcreteHandlerB();

        ha.setHandler(hb);

        String[] array = {"A", "B"};

        for (String s : array) {
            ha.handlerRequest(s);
        }

    }
}
