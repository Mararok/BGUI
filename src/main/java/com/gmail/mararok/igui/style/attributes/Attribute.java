/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.style.Style;

public abstract class Attribute {
	private Style parentStyle;
	
	public Attribute(Style parentStyle) {
		this.parentStyle = parentStyle;
	}
	
	public Style getParent() {
		return parentStyle;
	}
	
	public abstract void setValue(AttributeValue newValue);
}
