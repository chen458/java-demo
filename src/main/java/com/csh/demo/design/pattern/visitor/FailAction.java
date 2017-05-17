package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:18
 */
public class FailAction implements Action {
    @Override
    public void manAction(Man man) {
        System.out.println("男人失败时,门头喝酒");
    }

    @Override
    public void womanAction(Woman woman) {
        System.out.println("女人失败是,眼泪汪汪");
    }
}
