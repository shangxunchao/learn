package com.qiandao.big.decimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/5 12:05
 */
public class Demo {

	@Test
	public void demo1() {
		System.out.println(new BigDecimal(2.225667));
		System.out.println(new BigDecimal(2));
		System.out.println(new BigDecimal("2.225667"));
		System.out.println(new BigDecimal("2.225667").scale());
	}

	@Test
	public void demo2() {
		BigDecimal b = new BigDecimal("2.225667").setScale(2, BigDecimal.ROUND_DOWN);
		//2.22 直接去掉多余的位数
		System.out.println(b);
	}

	@Test
	public void demo3() {
		BigDecimal c = new BigDecimal("2.224667").setScale(2, BigDecimal.ROUND_UP);
		//2.23 跟上面相反，进位处理
		System.out.println(c);
	}

	@Test
	//天花板（向上），正数进位向上，负数舍位向上
	public void demo4() {
		//2.23 如果是正数，相当于BigDecimal.ROUND_UP
		BigDecimal f = new BigDecimal("2.224667").setScale(2, BigDecimal.ROUND_CEILING);
		System.out.println(f);
        //-2.22 如果是负数，相当于BigDecimal.ROUND_DOWN
		BigDecimal g = new BigDecimal("-2.225667").setScale(2, BigDecimal.ROUND_CEILING);
		System.out.println(g);
	}

	@Test
	//地板（向下），正数舍位向下，负数进位向下
	public void demo5() {
		//2.22 如果是正数，相当于BigDecimal.ROUND_DOWN
		BigDecimal h = new BigDecimal("2.225667").setScale(2, BigDecimal.ROUND_FLOOR);
		System.out.println(h);
        //-2.23 如果是负数，相当于BigDecimal.ROUND_HALF_UP
		BigDecimal i = new BigDecimal("-2.224667").setScale(2, BigDecimal.ROUND_FLOOR);
		System.out.println(i);
	}

	@Test
	public void demo6() {
		//2.23  四舍五入（若舍弃部分>=.5，就进位）
		BigDecimal d = new BigDecimal("2.225").setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("ROUND_HALF_UP:"+d);
	}

	@Test
	public void demo7() {
		//2.22  四舍五入（若舍弃部分>.5,就进位）
		BigDecimal e = new BigDecimal("2.225").setScale(2, BigDecimal.ROUND_HALF_DOWN);
		System.out.println("ROUND_HALF_DOWN:"+e);
	}

	@Test
	public void demo8() {
		//2.22 如果舍弃部分左边的数字为偶数，则作   ROUND_HALF_DOWN
		BigDecimal j = new BigDecimal("2.225").setScale(2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(j);
        //2.22 如果舍弃部分左边的数字为奇数，则作   ROUND_HALF_UP
		BigDecimal k = new BigDecimal("2.215").setScale(2, BigDecimal.ROUND_HALF_EVEN);
		System.out.println(k);
	}

	@Test
	public void demo9() {
		//断言请求的操作具有精确的结果，因此不需要舍入。
		BigDecimal l = new BigDecimal("2.215").setScale(3, BigDecimal.ROUND_UNNECESSARY);
		System.out.println(l);
        //如果对获得精确结果的操作指定此舍入模式，则抛出ArithmeticException。
		System.out.println(new BigDecimal("2.215").setScale(2, BigDecimal.ROUND_UNNECESSARY));
	}
}
