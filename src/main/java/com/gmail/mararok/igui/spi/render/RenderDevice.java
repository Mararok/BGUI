/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

public interface RenderDevice {
	
	Font createFont(String fontName);
	Image createImage(String filename);
	
	ParentVisualNode createParentNode();
	GeometryVisualNode createGeometryNode();
	TextVisualNode createTextNode();
	
	void showMouseCursor();
	void hideMouseCursor();
	
	int getWidth();
	int getHeight();
	
	ParentVisualNode getRootGUINode();
	Font getDefaultFont();
}
