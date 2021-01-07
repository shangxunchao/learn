package com.qiandao.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/10/10 14:57
 */
public class StreamTest {

	@Test
	public void learnFlatMap() {
		//(广州  深圳  上海  北京)的全拼的一些组合,下面我们就把每一个城市都划分一下
		List<String> citys = Arrays.asList("GuangZhou ShangHai", "GuangZhou ShenZhen",
				"ShangHai ShenZhen", "BeiJing ShangHai", "GuangZhou BeiJing", "ShenZhen BeiJing");

		//这里打印的数组对应的地址
		citys.stream().map(mCitys -> Arrays.stream(mCitys.split(" "))).forEach(System.out::println);//note1

		System.out.println();

		//流里面的元素还是一个数组
		citys.stream()
				.map(mCities -> Arrays.stream(mCities.split(" ")))//流里面的每个元素还是数组
				.forEach(cities ->cities.forEach(city-> System.out.print(city+" ")));//note2

		System.out.println();
		System.out.println();

		//直接一个flatMap()就把数组合并到映射流里面了
		citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).forEach(System.out::println);//note3

		System.out.println();

		//使用distinct()方法去重！
		citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).distinct().forEach(System.out::println);//note4

	}

	@Test
	public void learnStream() {
		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(5);
		lists.add(6);

		Optional<Integer> sum = lists.parallelStream().reduce((a, b) -> a + b);//这里把stream()换成了parallelStream（）
		if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());//21
		//<====> lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

		Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
		System.out.println("list的总和为:" + sum2);

		Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
		if (product.isPresent()) System.out.println("list的积为:" + product.get());//720

		Integer product2 = lists.parallelStream().reduce(1, (a, b) -> a * b);//这里把stream()换成了parallelStream（）
		System.out.println("list的积为:" + product2);//720
	}

    @Test
	public void reduce3th() {
		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(5);
		lists.add(6);

		Integer product2 = lists.parallelStream().reduce(1, (a, b) -> a * b,
				(a, b) -> a * b);
		System.out.println("list的积为:" + product2);//720
	}

	@Test
	public void learnStream2() {
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(5);
		lists.add(6);

		Optional<Integer> sum = lists.stream().reduce((a, b) -> a + b);
		if (sum.isPresent()) System.out.println("list的总和为:" + sum.get());//21
		//<====> lists.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);

		Integer sum2 = lists.stream().reduce(0, (a, b) -> a + b);//21
		System.out.println("list的总和为:" + sum2);

		Optional<Integer> product = lists.stream().reduce((a, b) -> a * b);
		if (product.isPresent()) System.out.println("list的积为:" + product.get());//720

		Integer product2 = lists.stream().reduce(1, (a, b) -> a * b);
		System.out.println("list的积为:" + product2);//720
	}

	@Test
	public void learnStream3() {
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(5);
		lists.add(6);

		Integer product3 = lists.stream().reduce(1, (a, b) -> {
			if (b % 2 == 0) return a * b; else return a;//这里你可以为所欲为!
		});
		System.out.println("list的偶数的积为:" + product3);//48
	}

	@Test
	public void learnStream4() {
		//首先,创建一个1-6乱序的List
		List<Integer> lists = new ArrayList<>();
		lists.add(4);
		lists.add(3);
		lists.add(6);
		lists.add(1);
		lists.add(5);
		lists.add(2);

		//看看List里面的数据是什么样子的先
		System.out.print("List里面的数据:");
		for (Integer elem : lists) System.out.print(elem + " ");// 4 3 6 1 5 2

		System.out.println();

		//最小值
		System.out.print("List中最小的值为:");
		Stream<Integer> stream = lists.stream();
		Optional<Integer> min = stream.min(Integer::compareTo);
		if (min.isPresent()) {
			System.out.println(min.get());//1
		}


		//最大值
		System.out.print("List中最大的值为:");
		lists.stream().max(Integer::compareTo).ifPresent(System.out::println);//6

		//排序
		System.out.print("将List流进行排序:");
		Stream<Integer> sorted = lists.stream().sorted();
		sorted.forEach(elem -> System.out.print(elem + " "));// 1 2 3 4 5 6

		System.out.println();

		//过滤
		System.out.print("过滤List流,只剩下那些大于3的元素:");
		lists.stream()
				.filter(elem -> elem > 3)
				.forEach(elem -> System.out.print(elem + " "));// 4 5 6

		System.out.println();

		//过滤
		System.out.println("过滤List流,只剩下那些大于0并且小于4的元素:\n=====begin=====");
		lists.stream()
				.filter(elem -> elem > 0)
				.filter(elem -> elem < 4)
				.sorted(Integer::compareTo)
				.forEach(System.out::println);// 1 2 3

		System.out.println("=====end=====");
		//经过了前面的这么多流操作,我们再来看看List里面的值有没有发生什么改变
		System.out.print("原List里面的数据:");
		for (Integer elem : lists) System.out.print(elem + " ");// 4 3 6 1 5 2
	}



}
