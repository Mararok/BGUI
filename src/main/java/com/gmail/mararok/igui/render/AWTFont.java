/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class AWTFont implements com.gmail.mararok.igui.spi.render.Font {
	private Font font;
	private int fontHeight;
	private GlyphSet glyphs;
	protected BufferedImage fontImage;
	
	public AWTFont() {
	}
	
	public void setFont(Font newFont) {
		font = newFont;
		fontHeight = font.getSize();
		glyphs = new GlyphSet();
		generate();
	}
	
	private void generate() {
		generateStandardGlyphSet();
		generateFontImage();
	}
	
	private void generateStandardGlyphSet() {
		for (char ch = 32; ch < 127; ++ch) {
			glyphs.setGlyph(ch,new Glyph());
		}
	}
	
	private void generateFontImage() {
		int glyphsPerLine = 32;
		int imageWidth = font.getSize()*glyphsPerLine;
		int imageHeight =font.getSize()*4;
		fontImage = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = fontImage.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,font.getSize()*glyphsPerLine+glyphsPerLine,font.getSize()*5+5);
		g.setColor(Color.WHITE);
		
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		
		int rowHeight = fontHeight;
		int xPosition = 0;
		int yPosition = rowHeight;
		
		for (char ch = 32; ch < 127;++ch) {
			Glyph glyph = glyphs.getGlyph(ch);
			glyph.setSize(fm.charWidth(ch),fm.getHeight());
			
			if (xPosition+glyph.getWidth() >= imageWidth) {
				xPosition = 0;
				yPosition += rowHeight;
			}
			
			glyph.setOffset(xPosition,yPosition);
			g.drawString(String.valueOf(ch),xPosition,yPosition);
			xPosition += glyph.getWidth();
		}
		
		File file = new File("test.png");
		try {
			ImageIO.write(fontImage,"png",file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public float getWidth(char character) {
		return getGlyph(character).getWidth();
	}

	@Override
	public float getLineWidth(String text) {
		float width = 0;
		for (char ch : text.toCharArray()) {
			width += getGlyph(ch).getWidth();
		}
		
		return width;
	}

	@Override
	public float getHeight(char character) {
		return getGlyph(character).getHeight();
	}

	@Override
	public float getLineHeight(String text) {
		return getHeight(text.charAt(0));
	}

	@Override
	public Glyph getGlyph(char character) {
		return glyphs.getGlyph(character);
	}
}
