/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

public interface RenderDevice {
	
	Font createFont(String fontName,Font.Style style, int size);
	Image createImage(String filename);
	MouseCursor createMouseCursor(String filename, int hotspotX, int hotspotY);
	
	ParentVisualNode createParentNode(String id);
	GeometryVisualNode createGeometryNode(String id);
	TextVisualNode createTextNode(String id);
	
	void enableMouseCursor();
	void disableMouseCursor();
	
	int getWidth();
	int getHeight();
	void resize(int newWidth, int newHeight);
	
	ParentVisualNode getRootGUINode();
}
