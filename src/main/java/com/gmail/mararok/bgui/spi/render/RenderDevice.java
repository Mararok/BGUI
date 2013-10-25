/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

public interface RenderDevice {
	void beginFrame();
	void endFrame();
	
	void clear();
	
	RenderableFont createFont(String filename);
	RenderableImage createImage(String filename);
	MouseCursor createMouseCursor(String filename, int hotspotX, int hotspotY);
	
	void enableCliping(int x, int y, int width, int height);
	void disableCliping();
	
	void enableMouseCursor();
	void disableMouseCursor();
	
	int getWidth();
	int getHeight();
}
