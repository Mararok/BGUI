/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.style.Style;

public class SizeAttribute extends Attribute {
	
	private int minWidth;
	private int width;
	private int maxWidth;
	
	private int minHeight;
	private int height;
	private int maxHeight;
	
	public SizeAttribute(Style parentStyle) {
		super(parentStyle);
	}

	public int getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(int newMinWidth) {
		minWidth = newMinWidth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int newWidth) {
		width = newWidth;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int newMaxWidth) {
		maxWidth = newMaxWidth;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(int newMinHeight) {
		minHeight = newMinHeight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int newMaxHeight) {
		maxHeight = newMaxHeight;
	}

	@Override
	public void setValue(AttributeValue newValue) {
		// TODO Auto-generated method stub
		
	}
	
}
