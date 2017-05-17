package com.csh.demo.design.pattern.decorator;

public class ConcreteDecoratorA extends Decorator{
	@Override
	public void operation() {
		super.operation();
		System.out.println("ConcreteDecoratorA 运行");
	}

}
