/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.style.Style;

public class HAlignAttribute extends Attribute {
	
	private HAlign align = HAlign.left;
	
	public HAlignAttribute(Style parentStyle) {
		super(parentStyle);
	}
	
	@Override
	public void setValue(String newValue) throws IllegalArgumentException {
		align = HAlign.valueOf(newValue);
	}
	
	public HAlign getAlign() {
		return align;
	}
}
