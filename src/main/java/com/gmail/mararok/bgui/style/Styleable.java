/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.style;

import java.util.List;

public interface Styleable {
	void setStyle(String newStyle);
	String getStyle();
	
	List<String> getStyleClasses();
	
	Styleable getStyleableParent();
}
