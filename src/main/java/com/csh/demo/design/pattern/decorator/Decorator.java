package com.csh.demo.design.pattern.decorator;

/**
 * 装饰
 * @author shenghong.chen 
 * @version 2016年5月18日 下午5:46:26 
 * 类说明:
 */
public abstract class Decorator implements Component{
	private Component component;
	
	public void setComponent(Component component) {
		this.component = component;
	}
	
	public void operation() {
		if ( null != component) {
			component.operation();
		}
	}

}
