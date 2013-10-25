/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

public interface RenderableFont extends Renderable {
	int getCharacterAdvence(char curChar, char nextChar, float size);
	float getLineWidth(String text);
	float getLineHeight(String text);
}
