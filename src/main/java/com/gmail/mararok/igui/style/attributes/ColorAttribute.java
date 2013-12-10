/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.style.Style;

public class ColorAttribute extends Attribute {
	private RGBAColor color;
	
	public ColorAttribute(Style parentStyle) {
		super(parentStyle);
	}
	
	public RGBAColor getColor() {
		return color;
	}
	
}
