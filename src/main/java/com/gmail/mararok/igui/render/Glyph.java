/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

import java.awt.image.BufferedImage;

public class Glyph {
	private int xOffset;
	private int yOffset;
	private int width;
	private int height;
	
	private float uMin;
	private float vMin;
	
	private float uMax;
	private float vMax;
	
	public void setOffset(int newXOffset, int newYOffset) {
		xOffset = newXOffset;
		yOffset = newYOffset;
	}
	
	public void calcTextureCoordinates(BufferedImage fontImage) {
		uMin = (float)xOffset/(float)fontImage.getWidth();
		vMin = (float)yOffset/(float)fontImage.getHeight();
		
		uMax = (float)(xOffset+width)/(float)fontImage.getWidth();
		vMax = (float)(yOffset+height)/(float)fontImage.getHeight();
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
	
	public float getUMinTexture() {
		return uMin;
	}
	
	public float getVMinTexture() {
		return vMin;
	}
	
	public float getUMaxTexture() {
		return uMax;
	}
	
	public float getVMaxTexture() {
		return vMax;
	}

}
