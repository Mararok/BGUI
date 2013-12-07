/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

public interface Styleable {
	Style getStyle();
	void setStyle(Style newStyle);
	
	StyleClass getStyleClass(String className);
	boolean hasStyleClass(String className);
	void addStyleClass(StyleClass newClass);
	void removeStyleClass(String className);
}
