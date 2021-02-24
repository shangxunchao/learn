/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.design.pattern.proxy;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2021/2/24 18:24
 **/
public class ImageProxy implements Image {
	private HighResolutionImage highResolutionImage;

	public ImageProxy(HighResolutionImage highResolutionImage) {
		this.highResolutionImage = highResolutionImage;
	}

	@Override
	public void showImage() {
		while (!highResolutionImage.isLoad()) {
			try {
				System.out.println("Temp Image: " + highResolutionImage.getWidth() + " " + highResolutionImage.getHeight());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		highResolutionImage.showImage();
	}
}