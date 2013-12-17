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
	
	public HAlign getAlign() {
		return align;
	}
	
	public void setAlign(HAlign newAlign) {
		align = newAlign;
	}

	@Override
	public void setValue(AttributeValue newValue) {
		// TODO Auto-generated method stub
		
	}
}
