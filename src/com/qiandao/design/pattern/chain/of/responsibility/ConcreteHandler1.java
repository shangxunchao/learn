/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.chain.of.responsibility;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 16:48
 **/
public class ConcreteHandler1 extends Handler {
	public ConcreteHandler1(Handler successor) {
		super(successor);
	}


	@Override
	protected void handleRequest(Request request) {
		if (request.getType() == RequestType.TYPE1) {
			System.out.println(request.getName() + " is handle by ConcreteHandler1");
			return;
		}
		if (successor != null) {
			successor.handleRequest(request);
		}
	}
}