/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.render.Glyph;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.Image;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;

public class JMEFontAC implements Font {
	private BitmapFont realFont;
	
	public JMEFontAC(BitmapFont realFont) {
		this.realFont = realFont;
	}
	BitmapText createLabel(String content) {
		return realFont.createLabel(content);
	}
	
	@Override
	public float getWidth(char character) {
		return getLineWidth(""+character);
	}

	@Override
	public float getLineWidth(String text) {
		return realFont.getLineWidth(text);
	}

	@Override
	public float getHeight(char character) {
		return getLineHeight(""+character);
	}

	@Override
	public float getLineHeight(String text) {
		return 10;
	}

	@Override
	public Glyph getGlyph(char character) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getFontImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
