/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

import com.gmail.mararok.bgui.spi.render.Image;

public class Glyph {
	private int xOffset;
	private int yOffset;
	private int width;
	private int height;
	
	private Image fontImage;
	
	public void setOffset(int newXOffset, int newYOffset) {
		xOffset = newXOffset;
		yOffset = newYOffset;
	}
	
	public void setSize(int newWidth, int newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	public int getXOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setFontImage(Image newFontImage) {
		fontImage = newFontImage;
	}
	
	public float getUMinTexture() {
		return xOffset/(float)fontImage.getWidth();
	}
	
	public float getVMinTexture() {
		return yOffset/(float)fontImage.getHeight();
	}
	
	public float getUMaxTexture() {
		return (xOffset+width)/(float)fontImage.getWidth();
	}
	
	public float getVMaxTexture() {
		return (yOffset+height)/(float)fontImage.getHeight();
	}

}
