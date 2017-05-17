package com.csh.demo.design.pattern.proxy;

/**
 * 代理模式：真实主题角色定义了代理角色所代表的真实对象，在真实主题角色中实现了真实的业务操作
 * @author shenghong.chen 
 * @version 2016年5月18日 下午10:31:14
 */
public class RealSubject extends Subject {
	@Override
	public void request() {
		System.out.println("真实请求！");
	}

}
