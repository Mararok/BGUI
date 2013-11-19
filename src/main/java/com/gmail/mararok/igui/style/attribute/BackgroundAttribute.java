/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

import com.gmail.mararok.igui.spi.render.Image;
import com.gmail.mararok.igui.style.Style;

public class BackgroundAttribute extends Attribute {
	public BackgroundAttribute(Style parentStyle) {
		super(parentStyle);
	}
	
	public Gradient color;
	public Image image;
}
