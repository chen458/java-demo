package com.csh.demo.design.pattern.decorator;

public class Client {
	public static void main(String[] args) {
		ConcreteComponent cc = new ConcreteComponent();
		ConcreteDecoratorA cda = new ConcreteDecoratorA();
		ConcreteDecoratorB cdb = new ConcreteDecoratorB();
		
		cda.setComponent(cc);
		cdb.setComponent(cda);
		cdb.operation();
	}
}
