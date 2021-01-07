package com.qiandao.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/10/9 15:31
 */
public class LearnJavaIterator {

	@Test
	public  void learnIterator() {
		List<String> lists = Arrays.asList("A", "B", "C", "D");

		Spliterator<String> spliterator = lists.stream().spliterator();

		while (spliterator.tryAdvance(System.out::println));
	}

	@Test
	public void learnIterator2() {
		List<String> lists = Arrays.asList("A", "B", "C", "D");
		lists.stream().spliterator().forEachRemaining(System.out::println);
	}

	@Test
	public void learnIterator3() {
		List<String> lists = Arrays.asList("A", "B", "C", "D");

		Spliterator<String> spliterator = lists.stream().spliterator();

		Spliterator<String> stringSpliterator = spliterator.trySplit();

		if (stringSpliterator != null) stringSpliterator.forEachRemaining(System.out::println);

		System.out.println("------------------");

		spliterator.forEachRemaining(System.out::println);
	}


}
