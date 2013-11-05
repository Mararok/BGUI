/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public interface VisualNode {
	Vector3f getLocalTranslation();
	void setLocalTranslation(Vector3f newTranslation);
	void setLocalTranslation(float x, float y, float z);
	
	Quat4f getLocalRotation();
	void setLocalRotation(Quat4f newRotation);
	void setLocalRotation(float xaxis, float yaxis, float zaxis, float angle);
	
	Vector3f getLocalScale();
	void setLocalScale(Vector3f newScale);
	void setLocalScale(float xscale, float yscale, float zscale);
	
	ParentVisualNode getParent();
	void setParent(ParentVisualNode newParent);
}
