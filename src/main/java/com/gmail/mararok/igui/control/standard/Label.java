/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.Font;

public interface Label extends Panel {
	void setText(String newText);
	String getText();
	
	void setColor(RGBAColor newColor);
	RGBAColor getColor();
	
	void setFont(Font newFont);
	Font getFont();
}
