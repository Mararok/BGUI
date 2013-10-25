/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

public interface SpatiaNode {
	// @TODO add one axis methods
	void setLocalTranslation(float x, float y, float z);
	void setLocalRotation(float xaxis, float yaxis, float zaxis);
	void setLocalScale(float xscale, float yscale, float zscale);
}
