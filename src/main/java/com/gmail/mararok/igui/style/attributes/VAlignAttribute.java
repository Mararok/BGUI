/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

import com.gmail.mararok.igui.style.Style;

public class VAlignAttribute extends Attribute {
	private VAlign align;
	
	public VAlignAttribute(Style parentStyle) {
		super(parentStyle);
	}

	public VAlign getAlign() {
		return align;
	}
	
	public void setAlign(VAlign newAlign) {
		align = newAlign;
	}
	
	@Override
	public void setValue(AttributeValue newValue) {
		// TODO Auto-generated method stub
		
	}

}
