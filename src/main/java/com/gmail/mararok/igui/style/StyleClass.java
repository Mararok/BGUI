/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.HashMap;

public class StyleClass {
	private String name;
	private Style style;
	
	private StyleClass superClass;
	private HashMap<String, StyleClass> subclasses;
	
	public StyleClass(String className) {
		name = className;
		style = new Style();
	}
	
	public Style getStyle() {
		return style;
	}
}
