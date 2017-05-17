package com.csh.demo.design.pattern.decorator;

/**
 * 
 * @author shenghong.chen 
 * @version 2016年5月18日 下午4:24:06 
 * 类说明:
 */
public class ConcreteComponent implements Component {

	public void operation() {
		System.out.println("装饰操作！");
	}

}
