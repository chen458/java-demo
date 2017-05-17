package com.csh.demo.design.pattern.command;

/**
 * @author: shenghong.chen
 * Date: 16/8/17
 * time: 下午8:02
 */
public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
