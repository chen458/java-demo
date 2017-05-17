package com.csh.demo.design.pattern.chain.responsibility;

/**
 * 抽象处理者
 * @author: shenghong.chen
 * Date: 16/8/18
 * time: 下午7:24
 */
public abstract class Handler {
    //下个处理者
    Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /**
     * 请求处理,
     * @param requeat 处理条件
     */
    abstract void handlerRequest(String requeat);
}
