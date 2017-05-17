package com.csh.demo.design.pattern.chain.responsibility;

/**
 * @author: shenghong.chen
 * Date: 16/8/18
 * time: 下午7:27
 */
public class ConcreteHandlerA extends Handler {
    @Override
    void handlerRequest(String requeat) {
        if ("A".equals(requeat)){
            System.out.println("A 处理者完成");
        } else {
            if (null == handler) {
                System.out.println("任务处理完成");
            } else {
                handler.handlerRequest(requeat);
            }
        }
    }
}
