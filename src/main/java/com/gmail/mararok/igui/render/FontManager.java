/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.RenderDevice;

import gnu.trove.map.hash.THashMap;

public class FontManager {
	private THashMap<String,Font> fonts;
	private RenderDevice renderDevice;
	
	public FontManager(RenderDevice renderDevice) {
		fonts = new THashMap<String, Font>();
		this.renderDevice = renderDevice;
	}
	
	public Font getFontByName(String fontName) {
		if (fontName == null) {
			return getDefaultFont();
		}
		
		Font font = fonts.get(fontName);
		if (font == null) {
			font = loadFont(fontName);
		}
		
		return font;
	}
	
	public Font getDefaultFont() {
		return renderDevice.getDefaultFont();
	}
	
	private Font loadFont(String fontName) {
		Font newFont = renderDevice.createFont(fontName);
		fonts.put(fontName,newFont);
		return newFont;
	}
}
