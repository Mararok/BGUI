/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.RGBAColor;

public class BorderAttribute extends Attribute {

	private RGBAColor color = RGBAColor.BLACK;
	private BorderStyle style = BorderStyle.SOLID;
	private int radius;
	
	RGBAColor getColor() {
		return color;
	}
	
	void setColor(RGBAColor newColor) {
		color = newColor;
	}
	
	BorderStyle getBorderStyle() {
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

	@Override
	public void setValue(AttributeValue newValue) {
		
	}

	@Override
	public AttributeType getType() {
		return AttributeType.border;
	}

}
