/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

import com.gmail.mararok.igui.render.RGBAColor;

public class Border {
	private RGBAColor color = RGBAColor.BLACK;
	private BorderStyle style = BorderStyle.SOLID;
	private int radius;
	
	void setColor(RGBAColor newColor) {
		color = newColor;
	}
	
	RGBAColor getColor() {
		return color;
	}
	
	void setStyle(BorderStyle newStyle) {
		style = newStyle;
	}
	
	BorderStyle getStyle() {
		return style;
	}
	
	void setRadius(int newRadius) {
		if (newRadius >= 0) {
			radius = newRadius;
		}
	}
	
	int getRadius() {
		return radius;
	}
}
