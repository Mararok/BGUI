/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import gnu.trove.map.hash.THashMap;


public class StyleClassManager {
	private THashMap<String,Style> styleClasses;
	
	public StyleClassManager() {
		styleClasses = new THashMap<String,Style>();
	}
	
	public void addClass(String className, Style classStyle) {
		styleClasses.put(className,classStyle);
	}
	
	public Style getClassByName(String className) {
		return styleClasses.get(className);
	}

}
