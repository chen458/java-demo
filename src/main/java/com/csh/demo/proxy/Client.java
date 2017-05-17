package com.csh.demo.proxy;

/**
 * @author: shenghong.chen
 * Date: 2016/11/14
 * time: 下午4:49
 */
public class Client {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade book1 = new BookFacadeImpl();
        System.out.println("地址 1 :" + book1);
        BookFacade book2 = (BookFacade)proxy.bind(book1);
        System.out.println("地址 2 :" + book2);
        System.out.println(book1 == book2 ? "等于" : "不等于");
        book2.addBook();
    }
}
