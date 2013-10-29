/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

import java.awt.Color;

public interface TextVisualNode extends VisualNode {
	
	Font getFont();
	void setFont(Font newFont);
	
	Color getColor();
	void setColor(Color newColor);
	void setColor(float red, float green, float blue);
	
	void setText(String newText);
	String getText();
}
