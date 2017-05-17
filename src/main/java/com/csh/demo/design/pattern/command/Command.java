package com.csh.demo.design.pattern.command;

/**
 * @author: shenghong.chen
 * Date: 16/8/17
 * time: 下午8:00
 */
public abstract class Command {
    Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 操作
     */
    public abstract void execute();
}
