package com.csh.demo.design.pattern.visitor;

/**
 * @author: shenghong.chen
 * Date: 16/8/23
 * time: 下午7:19
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new Man());
        os.attach(new Woman());

        Action success = new SuccessAction();
        Action fail = new FailAction();

        os.display(success);
        os.display(fail);
    }
}
