/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

public class MarginAttribute extends Attribute {
	private int left;
	private int top;
	
	private int right;
	private int bottom;

	@Override
	public void setValue(AttributeValue newValue) {
		// TODO Auto-generated method stub
		
	}

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

	@Override
	public AttributeType getType() {
		return AttributeType.margin;
	}
	
}
