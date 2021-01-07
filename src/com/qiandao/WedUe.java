/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao;

import com.alibaba.fastjson.JSON;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/12/15 14:15
 **/
public class WedUe {
	private int code;

	public static void main(String[] args) {
		WedUe wedUe = new WedUe();
		wedUe.setCode(1);
		WedUe.We we = new WedUe().new We();
		we.setErrorMessage("error");
		Wed wed = new Wed();
		System.out.println(JSON.toJSONString(wedUe));
	}

	public class We {
		private String errorMessage;

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
	}

	static class Wed {
		private boolean sussess;

		public boolean isSussess() {
			return sussess;
		}

		public void setSussess(boolean sussess) {
			this.sussess = sussess;
		}
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}