/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

public class Padding {
	public int left;
	public int top;
	public int right;
	public int bottom;
	
	public Padding() {}
	
	public Padding(int leftTop, int rightBottom) {
		this(leftTop,leftTop,rightBottom,rightBottom);
	}
	
	public Padding(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
}
