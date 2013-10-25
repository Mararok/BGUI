/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

public interface SpatialContainerNode extends SpatiaNode {
	void attachChild(SpatiaNode node);
	void detachChild(SpatiaNode node);
	void detachAllChildren();
}
