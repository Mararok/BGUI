/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.style.Style;

public class BorderAttribute extends Attribute {

	private RGBAColor color = RGBAColor.BLACK;
	private BorderStyle style = BorderStyle.SOLID;
	private int radius;
	
	public BorderAttribute(Style parentStyle) {
		super(parentStyle);
	}
	
	RGBAColor getColor() {
		return color;
	}
	
	void setColor(RGBAColor newColor) {
		color = newColor;
	}
	
	BorderStyle getStyle() {
		return style;
	}
	
	void setStyle(BorderStyle newStyle) {
		style = newStyle;
	}
	
	int getRadius() {
		return radius;
	}
	
	void setRadius(int newRadius) {
		if (newRadius >= 0) {
			radius = newRadius;
		}
	}

}
