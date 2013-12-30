/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.render.SolidGradient;

public class ColorAttribute extends Attribute {
	private Gradient color;
	
	public Gradient getColor() {
		return color;
	}
	
	public void setColor(RGBAColor newColor) {
		setColor(new SolidGradient(newColor));
	}
	
	public void setColor(Gradient newColor) {
		color = newColor;
	}
	
	@Override
	public void setValue(AttributeValue newValue) {
		if (newValue.getValue() instanceof RGBAColor) {
			setColor((RGBAColor)newValue.getValue());
		}
	}

	@Override
	public AttributeType getType() {
		return AttributeType.color;
	}
	
}
