/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

import java.util.HashMap;

public class GlyphSet {
	private HashMap<Character,Glyph> glyphs;
	
	public GlyphSet() {
		glyphs = new HashMap<Character,Glyph>();
	}
	
	public Glyph getGlyph(char character) {
		return glyphs.get(character);
	}
	
	public void setGlyph(char character, Glyph newGlyph) {
		glyphs.put(character,newGlyph);
	}
	
	public int getGlyphCount() {
		return glyphs.size();
	}
}
