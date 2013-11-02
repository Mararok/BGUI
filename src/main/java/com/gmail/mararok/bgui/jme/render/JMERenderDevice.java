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
import com.jme3.app.SimpleApplication;

public class JMERenderDevice implements RenderDevice {
	private SimpleApplication application;
	
	public JMERenderDevice(SimpleApplication application) {
		this.application = application;
	}
	
	@Override
	public Font createFont(String fontName, Font.Style style, int size) {
		JMEFont font = new JMEFont();
		font.setFont(new java.awt.Font(fontName,style.toAWTStyle(),size));
		return font;
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
	public ParentVisualNode createParentNode(String id) {
		return new JMEParentVisualNode(id);
	}

	@Override
	public GeometryVisualNode createGeometryNode(String id) {
		return new JMEGeometryVisualNode(id);
	}

	@Override
	public TextVisualNode createTextNode(String id) {
		return new JMETextVisualNode(id);
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
		return 800;
	}

	@Override
	public int getHeight() {
		return 600;
	}

}
