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
	private String name;
	
	private BitmapFont realFont;
	
	public JMEFontAC(String name, BitmapFont realFont) {
		this.name = name;
		
		this.realFont = realFont;
	}
	
	BitmapText createLabel(String content) {
		return realFont.createLabel(content);
	}
	
	@Override
	public int getWidth(char character) {
		return getLineWidth(""+character);
	}

	@Override
	public int getLineWidth(String text) {
		return (int) realFont.getLineWidth(text);
	}

	@Override
	public int getHeight(char character) {
		return realFont.getCharSet().getLineHeight();
	}

	@Override
	public int getLineHeight(String text) {
		return realFont.getCharSet().getLineHeight();
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
	@Override
	public String getName() {
		return name;
	}

}
