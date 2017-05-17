package com.csh.demo.design.pattern.proxy;

/**
 * 代理模式：代理主题角色内部包含对真实主题的引用，从而可以在任何时候操作真实主题对象
 * @author shenghong.chen 
 * @version 2016年5月18日 下午10:33:19
 */
public class Proxy extends Subject {
	
	private Subject subject;
	
	public Proxy(Subject subject) {
		super();
		this.subject = subject;
	}

	@Override
	public void request() {
		if (null != subject) {
			subject.request();
		}
	}
}
