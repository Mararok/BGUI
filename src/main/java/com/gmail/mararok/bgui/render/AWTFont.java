/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AWTFont {
	private Font font;
	private int fontHeight;
	private GlyphSet glyphs;
	private BufferedImage fontImage;
	
	public AWTFont() {
	}
	
	public void setFont(Font newFont) {
		font = newFont;
		fontHeight = font.getSize();
		glyphs = new GlyphSet();
	}
	
	public void generate() {
		glyphs = new GlyphSet();
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
			glyph.width = fm.charWidth(ch);
			glyph.height = fm.getHeight();
			
			if (xPosition+glyph.width >= imageWidth) {
				xPosition = 0;
				yPosition += rowHeight;
			}
			
			glyph.xOffset = xPosition;
			glyph.yOffset = yPosition;
			g.drawString(String.valueOf(ch),xPosition,yPosition);
			xPosition += glyph.width;
		}
		
		File file = new File("test.png");
		try {
			ImageIO.write(fontImage,"png",file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public GlyphSet getGlyphs() {
		return glyphs;
	}
}
