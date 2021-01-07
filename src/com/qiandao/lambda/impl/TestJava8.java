package com.qiandao.lambda.impl;

import com.qiandao.lambda.InterfaceUnVoidWithNoParam;
import com.qiandao.lambda.InterfaceUnVoidWithParams;
import com.qiandao.lambda.InterfaceWithNoParam;
import com.qiandao.lambda.InterfaceWithParams;
import org.junit.Test;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/29 14:36
 *
 * Lambda表达式只能用来替代那些函数式接口的匿名内部类
 * 函数式接口就是只定义一个抽象方法的接口
 */
public class TestJava8 {
	//匿名内部类
	InterfaceWithNoParam param1 = new InterfaceWithNoParam() {
		@Override
		public void run() {
			System.out.println("通过匿名内部类实现run()");
		}
	};
	//Lambda表达式
	//空括号表示无参
	InterfaceWithNoParam param2 = () -> System.out.println("通过Lambda表达式实现run()") ;

	InterfaceWithParams param3 = new InterfaceWithParams() {
		@Override
		public void run(String s) {
			System.out.println("通过" + s + "实现run(String)");
		}
	};
	InterfaceWithParams param4 = (s) -> System.out.println("通过" + s + "实现run(String)");

	@Test
	public void demoTest() {
		this.param1.run();
		this.param2.run();
		this.param3.run("匿名类");
		this.param4.run("Lambda");
	}

	InterfaceUnVoidWithNoParam interfaceUnVoidWithNoParam = new InterfaceUnVoidWithNoParam() {
		@Override
		public String run() {
			return "Hello World!";
		}
	};
	InterfaceUnVoidWithNoParam interfaceUnVoidWithNoParam1 = () -> "Hello Lambda!";

	InterfaceUnVoidWithParams interfaceWithParams = new InterfaceUnVoidWithParams() {
		@Override
		public String run(Integer integer) {
			return String.valueOf(integer);
		}
	};
	InterfaceUnVoidWithParams interfaceWithParams1 = (Integer integer) -> {
		return String.valueOf(integer);
	};

	@Test
	public void demo2(){
		String s = this.interfaceUnVoidWithNoParam.run();
		System.out.println("返回结果是："+s);
		String s0 = this.interfaceUnVoidWithNoParam1.run();
		System.out.println("返回结果是："+s0);

		String s1 = this.interfaceWithParams.run(1);
		System.out.println("您输入的是："+s1);
		String s2 = this.interfaceWithParams1.run(2);
		System.out.println("您输入的是："+s2);
	}
}
