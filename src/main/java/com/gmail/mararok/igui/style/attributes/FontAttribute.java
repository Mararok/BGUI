/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style.attributes;

public class FontAttribute extends Attribute {
	private String font;
	
	public String getFont() {
		return font;
	}


	public void setFont(String newFont) {
		font = newFont;
		updateStyle();
	}



	@Override
	public void setValue(AttributeValue newValue) {
		
	}


	@Override
	public AttributeType getType() {
		return AttributeType.font;
	}

}
