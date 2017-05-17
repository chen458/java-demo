package com.csh.demo.design.pattern.proxy;

public class Client {
	public static void main(String[] args) {
		Proxy proxy = new Proxy(new RealSubject());
		proxy.request();
	}
}
