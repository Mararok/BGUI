/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.style.Styleable;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;

public interface Region extends Styleable,ParentSceneNode {
	
	int getLocalCenterX();
	int getLocalCenterY();
	
	int getLocalX();
	void setLocalX(int newX);
	
	int getLocalY();
	void setLocalY(int newY);
	
	void setLocalPosition(int newX, int newY);
	
	int getLocalZ();
	void setLocalZ(int newZ);
	
	int getWidth();
	void setWidth(int newWidth);
	
	int getHeight();
	void setHeight(int newHeight);
	
	void setSize(int newWidth, int newHeight);
	
	void updateAttribute(AttributeType type, Attribute value);
	
}
