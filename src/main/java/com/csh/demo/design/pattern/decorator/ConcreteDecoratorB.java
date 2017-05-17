package com.csh.demo.design.pattern.decorator;

public class ConcreteDecoratorB extends Decorator{
	@Override
	public void operation() {
		super.operation();
		System.out.println("ConcreteDecoratorB 运行");
	}

}
