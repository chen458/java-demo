package com.csh.demo.design.pattern.bridge;

/**
 * @author: shenghong.chen
 * Date: 16/8/17
 * time: 下午6:33
 */
public class HandsetAddressList implements HandsetSoft {
    @Override
    public void run() {
        System.out.println("运行手机通讯录");
    }
}
