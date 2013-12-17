/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.style.Style;

public class FontAttribute extends Attribute {
	private String font;
	private RGBAColor color;
	private FontStyle style;
	
	public FontAttribute(Style parentStyle) {
		super(parentStyle);
	}

	
	public String getFont() {
		return font;
	}


	public void setFont(String newFont) {
		font = newFont;
	}


	public RGBAColor getColor() {
		return color;
	}


	public void setColor(RGBAColor newColor) {
		color = newColor;
	}


	public FontStyle getStyle() {
		return style;
	}


	public void setStyle(FontStyle newStyle) {
		style = newStyle;
	}


	@Override
	public void setValue(AttributeValue newValue) {
		
	}

}
