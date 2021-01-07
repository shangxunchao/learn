/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.enums;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/4 14:48
 **/
public enum TestOperator {
	ADD("+") {
		@Override
		public int calculate(int a, int b) {
			return a + b;
		}
	},
	SUBTRACT("-") {
		@Override
		public int calculate(int a, int b) {
			return a - b;
		}
	},
	MULTIPLY("*") {
		@Override
		public int calculate(int a, int b) {
			return a * b;
		}
	},
	DIVIDE("/") {
		@Override
		public int calculate(int a, int b) {
			if (b == 0) {
				throw new IllegalArgumentException("divisor must not be 0");
			}
			return a / b;
		}
	};

	TestOperator(String operator) {
		this.operator = operator;
	}

	private String operator;

	public abstract int calculate(int a, int b);

	public String getOperator() {
		return operator;
	}
}