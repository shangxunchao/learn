/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/13 10:28
 **/
public class ClassB {
	@JSONField(name = "c_Id")
	private Integer cId;
	@JSONField(name = "c_Name")
	private String cName;

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "ClassB{" +
				"cId=" + cId +
				", cName='" + cName + '\'' +
				'}';
	}
}