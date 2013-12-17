/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;

class JMETextVisualNodeAC extends JMEVisualNode implements TextVisualNode {
	private Font font;
	private RGBAColor color = RGBAColor.WHITE;
	private String text = "";
	
	JMETextVisualNodeAC(RenderDevice renderDevice) {
		super(renderDevice);
		font = renderDevice.getDefaultFont();
	}
	
	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void setFont(Font newFont) {
		font = newFont;
		setText(getText());
	}

	@Override
	public RGBAColor getColor() {
		return color;
	}

	@Override
	public void setColor(RGBAColor newColor) {
		color = newColor;
		if (spatial != null) {
			((BitmapText)spatial).setColor(new ColorRGBA(newColor.r(),newColor.g(),newColor.b(),newColor.a()));
		}
	}

	@Override
	public void setColor(float red, float green, float blue) {
		setColor(new RGBAColor(red,green,blue));
	}

	@Override
	public void setText(String newText) {
		text = newText;
		if (font == null || color == null) {
			return;
		}
		
		if (getParent() != null) {
			getParent().detachChild(this);
		}
			spatial = ((JMEFontAC)getFont()).createLabel(newText);
			((BitmapText)spatial).setColor(new ColorRGBA(color.r(),color.g(),color.b(),color.a()));
		if (getParent() != null) {
			getParent().attachChild(this);
		}
	}

	@Override
	public String getText() {
		return text;
	}
}
