/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

import com.gmail.mararok.igui.render.RGBAColor;

public interface TextVisualNode extends VisualNode {
	
	Font getFont();
	void setFont(Font newFont);
	
	RGBAColor getColor();
	void setColor(RGBAColor newColor);
	void setColor(float red, float green, float blue);
	
	void setText(String newText);
	String getText();
}
