/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.style.Style;

public class FontAttribute extends Attribute {
	private Font font;
	private RGBAColor color;
	private FontStyle style;
	
	public FontAttribute(Style parentStyle) {
		super(parentStyle);
	}

}
