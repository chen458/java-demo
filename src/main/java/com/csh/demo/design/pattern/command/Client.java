package com.csh.demo.design.pattern.command;

/**
 * @author: shenghong.chen
 * Date: 16/8/17
 * time: 下午8:05
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Command command = new ConcreteCommand(receiver);

        Invoker invoker = new Invoker();

        invoker.setCommand(command);

        invoker.ExecuteCommand();


    }
}
