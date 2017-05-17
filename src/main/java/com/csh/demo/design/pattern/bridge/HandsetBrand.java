package com.csh.demo.design.pattern.bridge;

/**
 * @author: shenghong.chen
 * Date: 16/8/17
 * time: 下午6:34
 */
public abstract class HandsetBrand {
    HandsetSoft soft;

    public HandsetSoft getSoft() {
        return soft;
    }

    public void setSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();

}
