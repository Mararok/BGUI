/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

public interface RenderDevice {
	
	Font createFont(String filename);
	Image createImage(String filename);
	MouseCursor createMouseCursor(String filename, int hotspotX, int hotspotY);
	
	ParentVisualNode createParentNode();
	GeometryVisualNode createGeometryNode();
	TextVisualNode createTextNode();
	
	void enableMouseCursor();
	void disableMouseCursor();
	
	int getWidth();
	int getHeight();
}
