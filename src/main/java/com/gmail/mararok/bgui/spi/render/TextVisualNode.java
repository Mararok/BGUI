/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

import com.gmail.mararok.bgui.render.RGBAColor;

public interface TextVisualNode extends VisualNode {
	
	Font getFont();
	void setFont(Font newFont);
	
	RGBAColor getColor();
	void setColor(RGBAColor newColor);
	void setColor(float red, float green, float blue);
	
	void setText(String newText);
	String getText();
}
