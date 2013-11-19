/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attribute;

import com.gmail.mararok.igui.style.Style;

public abstract class Attribute {
	private Style parentStyle;
	private String value;
	
	public Attribute(Style parentStyle) {
		this.parentStyle = parentStyle;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(AttributeType type, String newValue) throws IllegalArgumentException {
		if (type.isMain()) {
			value = newValue;
		} else {
			throw new IllegalArgumentException("Attribute type: "+type+" isn't main type");
		}
	}
	
	public void setValue(String newValue) throws IllegalArgumentException {
		value = newValue;
	}

}
