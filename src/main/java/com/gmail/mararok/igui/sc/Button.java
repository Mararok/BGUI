/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc;

import java.awt.Color;

public interface Button {
	void setCaption(String newCaption);
	String getCaption();
	
	void setColor(Color color);
	Color getColor();
}
