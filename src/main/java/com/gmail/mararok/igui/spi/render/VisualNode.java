/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public interface VisualNode {
	Vector3f getTranslation();
	void setTranslation(float x, float y, float z);
	
	Quat4f getRotation();
	void setRotation(Quat4f newRotation);
	void setRotation(float xaxis, float yaxis, float zaxis, float angle);
	
	Vector3f getScale();
	void setScale(float scale);
	void setScale(float xScale, float yScale, float zScale);
	
	ParentVisualNode getParent();
	void setParent(ParentVisualNode newParent);
	
	RenderDevice getRenderDevice();
}
