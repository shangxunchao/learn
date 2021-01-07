/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/7 14:18
 **/
public class Car {
	private String make;
	private String model;
	private int year;

	public Car(String theMake, String theModel, int yearOfMake) {
		make = theMake;
		model = theModel;
		year = yearOfMake;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public static List<Car> createCars() {
		return Arrays.asList(
				new Car("Jeep", "Wrangler", 2011),
				new Car("Jeep", "Comanche", 1990),
				new Car("Dodge", "Avenger", 2010),
				new Car("Buick", "Cascada", 2016),
				new Car("Ford", "Focus", 2012),
				new Car("Chevrolet", "Geo Metro", 1992)
		);
	}

	public static List<String> getModelsAfter2000UsingPipeline(
			List<Car> cars) {
		return
				cars.stream()
						.filter(car -> car.getYear() > 2000)
						.sorted(Comparator.comparing(Car::getYear))
						.map(Car::getModel).distinct()
						.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		getModelsAfter2000UsingPipeline(createCars()).forEach(System.out::println);
	}
}