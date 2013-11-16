/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import java.util.HashMap;

public class StyleClassManager {
	private HashMap<String,Style> styleClasses;
	
	public StyleClassManager() {
		styleClasses = new HashMap<String,Style>();
	}
	
	public void addClass(String className, Style classStyle) {
		styleClasses.put(className,classStyle);
	}
	
	public Style getClassByName(String className) {
		return styleClasses.get(className);
	}

	
	public void loadTheme(String themeName) {
		
	}
}
