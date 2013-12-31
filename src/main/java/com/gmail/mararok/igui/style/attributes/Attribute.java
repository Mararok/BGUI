/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.style.Style;

public abstract class Attribute {
	private Style style;
	
	public Attribute() {}
	
	public Style getStyle() {
		return style;
	}
	
	public void setStyle(Style newStyle) {
		style = newStyle;
	}
	
	public abstract AttributeType getType();
	
	public void updateStyle() {
		if (style != null) {
			style.updateAttribute(getType());
		}
	}
	
	public abstract void setValue(AttributeValue newValue);
}
