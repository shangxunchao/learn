package com.qiandao.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/9/11 10:40
 */

public class Student extends BaseModel {

	@JSONField(name = "studentName")
	private String name;
	private Integer score;
	private Integer age;
	private Long id;
	private Boolean isTrue;

	public Student(String name, Integer score) {
		this.name = name;
		this.score = score;
	}

	public Student(String name, Integer score, Long id) {
		this.name = name;
		this.score = score;
		this.id = id;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public Integer getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean aTrue) {
		isTrue = aTrue;
	}
}
