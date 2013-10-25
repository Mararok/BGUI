/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

import java.awt.Color;

public interface RenderableText {
	void setSize();
	int getSize();
	
	void setColor(Color color);
	Color getColor();
	
	void setText(String text);
	String getText();
}
