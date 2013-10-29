/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

public interface Font {

	float getWidth(char character);
	float getLineWidth(String text);
	
	float getHieght(char character);
	float getLineHeight(String text);
}
