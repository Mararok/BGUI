/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.util;

public class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public void setPosition(int newX, int newY) {
		setX(newX);
		setY(newY);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public void setSize(int newWidth, int newHeight) {
		setWidth(newWidth);
		setHeight(newHeight);
	}
	
}
