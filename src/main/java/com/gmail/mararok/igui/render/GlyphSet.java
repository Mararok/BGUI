/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

import gnu.trove.map.hash.THashMap;

public class GlyphSet {
	private THashMap<Character,Glyph> glyphs;
	
	public GlyphSet() {
		glyphs = new THashMap<Character,Glyph>();
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
