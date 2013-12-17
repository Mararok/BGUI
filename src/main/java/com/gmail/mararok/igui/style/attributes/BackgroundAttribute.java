/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.render.SolidGradient;
import com.gmail.mararok.igui.style.Style;

public class BackgroundAttribute extends Attribute {
	private Gradient color;
	private String image;
	
	public BackgroundAttribute(Style parentStyle) {
		super(parentStyle);
	}
	
	public Gradient getColor() {
		return color;
	}
	
	public void setColor(RGBAColor newColor) {
		setColor(new SolidGradient(newColor));
	}
	
	public void setColor(Gradient newColor) {
		color = newColor;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String newImage) {
		image = newImage;
	}

	@Override
	public void setValue(AttributeValue newValue) {
		if (newValue.getValue() instanceof RGBAColor) {
			setColor((RGBAColor)newValue.getValue());
		}
	}
}
