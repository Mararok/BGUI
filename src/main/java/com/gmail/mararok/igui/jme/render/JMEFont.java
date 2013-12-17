/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import java.nio.ByteBuffer;

import jme3tools.converters.ImageToAwt;

import com.gmail.mararok.igui.render.AWTFont;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.Image;
import com.jme3.material.Material;
import com.jme3.texture.Image.Format;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

class JMEFont extends AWTFont implements Font {
	private Image nativeFontImage;
	private Material fontMaterial;
	
	public JMEFont(Material fontMaterial) {
		this.fontMaterial = fontMaterial;
	}
	
	Material getFontMaterial() {
		return fontMaterial;
	}
	
	@Override
	public void setFont(java.awt.Font newFont) {
		super.setFont(newFont);
		ByteBuffer data = BufferUtils.createByteBuffer(fontImage.getWidth()*fontImage.getHeight()*4);
		ImageToAwt.convert(fontImage,Format.RGBA8,data);
		Texture2D texture = new Texture2D(
			new com.jme3.texture.Image(Format.RGBA8,fontImage.getWidth(),fontImage.getHeight(),data));
		nativeFontImage = new JMEImage(texture);
		
		fontMaterial.setTexture("ColorMap",texture);
	}
	
	@Override
	public Image getFontImage() {
		return nativeFontImage;
	}

}
