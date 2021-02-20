/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.thread.schedule;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/1/18 19:41
 **/

import com.qiandao.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实时配置文件缓冲池
 */
final class ConfigPool {
	private static final Map<String, Student> pool = new ConcurrentHashMap<>();

	private static Map<String, Long> configFiles = new HashMap<>();

	public static Map<String, Long> getConfigUpdateTime() {
		return configFiles;
	}

	public static void updateConfigUpdateTime(String name, Long updateTime) {
		configFiles.put(name, updateTime);
	}


	static <T extends Student> T get(String confName) {
		Student config = pool.get(confName);
		if (config != null) {
			return (T) config;
		}
		return null;
	}

	private static void updateToPool(String confName, Student conf) {
		pool.put(confName, conf);
		//ConfigScanner.getInstance().scan(confName);
	}

	static boolean update(String confName, Student remoteConf) {
		Student localConf = pool.get(confName);
		if (localConf == null) {
			updateToPool(confName, remoteConf);
			return true;
		} else {
			/*if (remoteConf.getMajorVersion() > localConf.getMajorVersion()) {
				updateToPool(confName, remoteConf);
				return true;
			} else {
				if (remoteConf.getMinorVersion() > localConf.getMinorVersion()) {
					updateToPool(confName, remoteConf);
					return true;
				}
			}*/
		}
		return false;
	}

	static void clear() {
		pool.clear();
	}

	static boolean isFilled() {
		return pool.size() != 0;
	}

	static boolean isNull() {
		return pool.size() == 0;
	}
}