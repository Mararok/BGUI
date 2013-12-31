/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

import com.gmail.mararok.igui.render.Glyph;

public interface Font {
	String getName();
	
	int getWidth(char character);
	int getLineWidth(String text);
	
	int getHeight(char character);
	int getLineHeight(String text);
	
	Glyph getGlyph(char character);
	Image getFontImage();
}
