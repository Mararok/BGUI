/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

import com.gmail.mararok.igui.render.MemoryMesh;

public interface GeometryVisualNode extends VisualNode {
	
	MemoryMesh getMesh();
	void setMesh(MemoryMesh newMesh);
	
	void updateGeometry();
}
