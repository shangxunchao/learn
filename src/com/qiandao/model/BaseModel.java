package com.qiandao.model;

import java.io.Serializable;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2020/7/1 11:03
 */
public class BaseModel implements Serializable {
	Long ip;
	String host;

	public Long getIp() {
		return ip;
	}

	public void setIp(Long ip) {
		this.ip = ip;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
