/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.spi.render;

import com.gmail.mararok.bgui.render.MemoryMesh;

public interface GeometryVisualNode extends VisualNode {
	
	MemoryMesh getMesh();
	void setMesh(MemoryMesh newMesh);
	
	void updateGeometry();
}
