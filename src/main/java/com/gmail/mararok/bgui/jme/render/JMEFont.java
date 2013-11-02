/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.jme.render;

import java.nio.ByteBuffer;

import jme3tools.converters.ImageToAwt;

import com.gmail.mararok.bgui.render.AWTFont;
import com.gmail.mararok.bgui.spi.render.Font;
import com.gmail.mararok.bgui.spi.render.Image;
import com.jme3.texture.Image.Format;
import com.jme3.texture.Texture2D;
import com.jme3.util.BufferUtils;

class JMEFont extends AWTFont implements Font {
	private Image nativeFontImage;

	@Override
	public void setFont(java.awt.Font newFont) {
		super.setFont(newFont);
		ByteBuffer data = BufferUtils.createByteBuffer(fontImage.getWidth()*fontImage.getHeight()*4);
		ImageToAwt.convert(fontImage,Format.RGBA8,data);
		nativeFontImage = new JMEImage(new Texture2D(
			new com.jme3.texture.Image(Format.RGBA8,fontImage.getWidth(),fontImage.getHeight(),data)));
	}
	
	@Override
	public Image getFontImage() {
		return nativeFontImage;
	}

}
