/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.util;

public final class Rectangle {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle() {}
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.width = size;
		this.height = size;
	}
	
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
	
	public int getHalfWidth() {
		return getWidth()/2;
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	public int getHeight() {
		return height;
	}
	
	public int getHalfHeight() {
		return getHeight()/2;
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public void setSize(int newWidth, int newHeight) {
		setWidth(newWidth);
		setHeight(newHeight);
	}
	
	public int getCenterX() {
		return getX()+getHalfWidth();
	}
	
	public int getCenterY() {
		return getY()+getHalfHeight();
	}
	
	public int getLeft() {
		return x;
	}
	
	public int getTop() {
		return y;
	}
	
	public int getRight() {
		return x+width;
	}
	
	public int getBottom() {
		return y+height;
	}
	
	public boolean contains(int px, int py) {
		return (px >= getLeft() && py >= getTop() && px <= getRight() && py <= getBottom());
	}
	
	public String toString() {
		return String.format("Rectangle[%d,%d,%d,%d]",x,y,width,height);
	}
}
