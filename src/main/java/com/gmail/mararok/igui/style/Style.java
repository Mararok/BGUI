/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

public class Style {
	private String styleString;
	public BackgroundStyle background;
	
	public String get() {
		return styleString;
	}
	
	public void set(String newStyle) {
		styleString = newStyle;
		// @TODO process new style;
	}

}
