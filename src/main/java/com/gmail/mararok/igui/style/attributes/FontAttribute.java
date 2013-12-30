/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.render.RGBAColor;

public class FontAttribute extends Attribute {
	private String font;
	private RGBAColor color;
	private FontStyle style;

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


	public FontStyle getFontStyle() {
		return style;
	}


	public void setStyle(FontStyle newStyle) {
		style = newStyle;
	}


	@Override
	public void setValue(AttributeValue newValue) {
		
	}


	@Override
	public AttributeType getType() {
		return AttributeType.font;
	}

}
