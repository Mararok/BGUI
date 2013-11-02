/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.jme.render;

import com.gmail.mararok.bgui.spi.render.Image;
import com.jme3.texture.Texture;

class JMEImage implements Image {
	private Texture texture;
	
	JMEImage(Texture texture) {
		this.texture = texture;
	}
	
	@Override
	public int getWidth() {
		return texture.getImage().getWidth();
	}

	@Override
	public int getHeight() {
		return texture.getImage().getHeight();
	}

	
	Texture getTexture() {
		return texture;
	}
}
