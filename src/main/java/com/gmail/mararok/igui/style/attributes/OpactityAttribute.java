/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.style.Style;

public class OpactityAttribute extends Attribute {
	private float opacity;
	
	public OpactityAttribute(Style parentStyle) {
		super(parentStyle);
	}

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float newOpacity) {
		opacity = newOpacity;
	}
	
	@Override
	public void setValue(AttributeValue newValue) {
		// TODO Auto-generated method stub
		
	}

}
