package com.csh.demo.design.pattern.command;

/**
 * @author: shenghong.chen
 * Date: 16/8/17
 * time: 下午8:04
 */
public class Invoker {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void ExecuteCommand(){
        command.execute();
    }
}
