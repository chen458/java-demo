package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:12
 */
public class SuccessAction implements Action {
    @Override
    public void manAction(Man man) {
        System.out.println("男人成功时,背后多半有一个伟大的女人");
    }

    @Override
    public void womanAction(Woman woman) {
        System.out.println("女人成功时,背后大多有一个不成功的男人");
    }
}
