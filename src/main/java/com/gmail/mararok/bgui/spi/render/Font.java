/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

import com.gmail.mararok.bgui.render.Glyph;

public interface Font {

	public enum Style {
		PLAIN(java.awt.Font.PLAIN),
		BOLD(java.awt.Font.BOLD),
		ITALIC(java.awt.Font.ITALIC);

		private int awtStyle;
		
		private Style(int awtStyle) {
			this.awtStyle = awtStyle;
		}
		
		public int toAWTStyle() {
			return awtStyle;
		}
	}
	
	float getWidth(char character);
	float getLineWidth(String text);
	
	float getHeight(char character);
	float getLineHeight(String text);
	
	Glyph getGlyph(char character);
	Image getFontImage();
}
