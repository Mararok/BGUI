/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.jme.render;

import com.gmail.mararok.bgui.spi.render.Font;
import com.gmail.mararok.bgui.spi.render.GeometryVisualNode;
import com.gmail.mararok.bgui.spi.render.Image;
import com.gmail.mararok.bgui.spi.render.MouseCursor;
import com.gmail.mararok.bgui.spi.render.ParentVisualNode;
import com.gmail.mararok.bgui.spi.render.RenderDevice;
import com.gmail.mararok.bgui.spi.render.TextVisualNode;

public class JMERenderDevice implements RenderDevice {

	@Override
	public Font createFont(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image createImage(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouseCursor createMouseCursor(String filename, int hotspotX,
			int hotspotY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParentVisualNode createParentNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeometryVisualNode createGeometryNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextVisualNode createTextNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableMouseCursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableMouseCursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
