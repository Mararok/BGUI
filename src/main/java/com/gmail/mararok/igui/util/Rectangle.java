/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.util;

public final class Rectangle {
	private int left;
	private int top;
	private int right;
	private int bottom;
	
	public int getLeft() {
		return left;
	}
	
	public void setLeft(int newLeft) {
		left = newLeft;
	}
	
	public int getTop() {
		return top;
	}
	
	public void setTop(int newTop) {
		top = newTop;
	}
	
	public void setLeftTop(int newLeft, int newTop) {
		setLeft(newLeft);
		setLeft(newTop);
	}
	
	public int getRight() {
		return right;
	}
	
	public void setRight(int newRight) {
		right = newRight;
	}
	
	public int getBottom() {
		return bottom;
	}
	
	public void setBottom(int newBottom) {
		bottom = newBottom;
	}
	
	public void setRightBottom(int newRight, int newBottom) {
		setRight(newRight);
		setBottom(newBottom);
	}
	
	public int getWidth() {
		return getRight() - getLeft();
	}
	
	public int getHalfWidth() {
		return getWidth()/2;
	}
	
	public void setWidth(int newWidth) {
		setRight(getLeft()+newWidth);
	}

	public int getHeight() {
		return getBottom() - getTop();
	}
	
	public int getHalfHeight() {
		return getHeight()/2;
	}
	
	public void setHeight(int newHeight) {
		setBottom(getTop()+newHeight);
	}
	
	public int getCenterX() {
		return getLeft()+getHalfWidth();
	}
	
	public int getCenterY() {
		return getTop()+getHalfHeight();
	}
}
