/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.spi.render.Image;
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
